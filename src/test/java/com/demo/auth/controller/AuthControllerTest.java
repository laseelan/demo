package com.demo.auth.controller;

import com.demo.auth.model.User;
import com.demo.auth.service.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(AuthControler.class)
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthService service;

    @Test
    public void should_authenticate() throws Exception {
        // Arrange
        when(service.authenticate(any(User.class))).thenReturn(true);

        this.mockMvc.perform(get("/auth")
                .param("username", "admin")
                .param("password", "password"))
                .andDo(print()).andExpect(status().isOk())
                // Asset
                .andExpect(content().string("true"));
    }

    @Test
    public void should_not_authenticate() throws Exception {
        // Arrange
        when(service.authenticate(any(User.class))).thenReturn(false);
        this.mockMvc.perform(get("/auth")
                .param("username", "admin")
                .param("password", "password1"))
                .andDo(print()).andExpect(status().isOk())
                // Assert
                .andExpect(content().string("false"));
    }
}

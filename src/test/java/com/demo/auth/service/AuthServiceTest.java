package com.demo.auth.service;

import com.demo.auth.aws.AWSCognitoIdentityProvider;
import com.demo.auth.aws.AdminInitializeAuthRequest;
import com.demo.auth.model.User;
import com.demo.auth.service.impl.AuthServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @Mock
    private AWSCognitoIdentityProvider provider;

    private AuthService service;

    @BeforeEach
    public void beforeEachTestMethod() {
        service = new AuthServiceImpl(provider);
    }
    @Test
    public void should_successfully_authenticate() {
        // Arrange
        when(provider.adminInitialization(any(AdminInitializeAuthRequest.class)))
                .thenReturn(true);
        // Act
        boolean result = service.authenticate(new User("admin", "password"));

        // Assert
        assertTrue(result);
    }
    @Test
    public void should_not_authenticate_the_given_user() {
        // Arrange
        when(provider.adminInitialization(any(AdminInitializeAuthRequest.class)))
                .thenReturn(false);
        // Act
        boolean result = service.authenticate(new User("admin", "password"));

        // Assert
        assertFalse(result);
    }
}

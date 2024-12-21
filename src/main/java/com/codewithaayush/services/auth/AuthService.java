package com.codewithaayush.services.auth;

import com.codewithaayush.dto.SignupRequest;
import com.codewithaayush.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {

    UserDto createCustomer(SignupRequest signupRequest);

    boolean hasCustomerwithEmail(String email);
}

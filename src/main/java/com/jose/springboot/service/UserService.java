package com.jose.springboot.service;

import com.jose.springboot.dto.RegistrationDto;
import jakarta.validation.constraints.NotEmpty;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    boolean emailExists(@NotEmpty(message = "Email should not be empty") String email);
}

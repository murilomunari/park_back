package com.mbissiato.demo_park_api.DTO;

import com.mbissiato.demo_park_api.Entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record UserRequest(
        @NotBlank(message = "Username não pode estar vazio")
        @Email(message = "Email fora do padrão")
        String username,

        @NotBlank(message = "Password não pode estar vazio")
        @Size(min = 6, max = 9, message = "Password deve ter entre 6 e 9 caracteres")
        String password,

        Role role
) {}


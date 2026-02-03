package com.mbissiato.demo_park_api.DTO;

public record UpdatePasswordDTO(String currentPassword,
                                String newPassword,
                                String confirmPassword) {
}

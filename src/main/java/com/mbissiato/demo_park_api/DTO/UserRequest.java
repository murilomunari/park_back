package com.mbissiato.demo_park_api.DTO;

import com.mbissiato.demo_park_api.Entity.Role;

public record UserRequest(String username,
                          String password,
                          Role role) {
}

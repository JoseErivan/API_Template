package com.api.dto;

import com.api.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}

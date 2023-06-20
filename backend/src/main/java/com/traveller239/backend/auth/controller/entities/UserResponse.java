package com.traveller239.backend.auth.controller.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.traveller239.backend.auth.user.Role;
import com.traveller239.backend.auth.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String firstname;
    private String lastname;
    @JsonProperty("telegram_handle")
    private String telegramHandle;
    private Role role;

    public static UserResponse createUserResponse(User user) {
        return UserResponse
                .builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .telegramHandle(user.getTelegramHandle())
                .role(user.getRole())
                .build();
    }
}

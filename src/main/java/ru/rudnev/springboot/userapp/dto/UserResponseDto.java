package ru.rudnev.springboot.userapp.dto;

import lombok.Data;

@Data
public class UserResponseDto {
    private int id;

    private String username;

    private String email;
}

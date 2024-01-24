package ru.rudnev.springboot.userapp.dto;

import lombok.Data;

@Data
public class UserGetDto {
    private String username;

    private String email;
}

package ru.rudnev.springboot.userapp.dto;

import lombok.Data;

@Data
public class UserPostDto {
    private Integer id;

    private String username;

    private String email;

    private String password;
}

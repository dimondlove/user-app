package ru.rudnev.springboot.userapp.service;

import ru.rudnev.springboot.userapp.dto.UserCreateDto;
import ru.rudnev.springboot.userapp.dto.UserResponseDto;

import java.util.Collection;

public interface UserService {
    Collection<UserResponseDto> getAllUsers();

    UserResponseDto getUserById(int id);

    UserResponseDto createUser(UserCreateDto userCreateDto);

    UserResponseDto updateUser(int id, UserCreateDto userCreateDto);

    void deleteUser(int id);

    void deleteAllUsers();
}

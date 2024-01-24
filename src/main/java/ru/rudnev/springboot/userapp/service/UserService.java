package ru.rudnev.springboot.userapp.service;

import org.springframework.http.ResponseEntity;
import ru.rudnev.springboot.userapp.dto.UserGetDto;
import ru.rudnev.springboot.userapp.dto.UserPostDto;
import ru.rudnev.springboot.userapp.model.User;

import java.util.Collection;

public interface UserService {
    Collection<UserGetDto> getAllUsers();

    ResponseEntity<UserGetDto> getUserById(int id);

    User createUser(UserPostDto userPostDto);

    ResponseEntity<User> updateUser(int id, UserPostDto userPostDto);

    void deleteUser(int id);

    void deleteAllUsers();
}

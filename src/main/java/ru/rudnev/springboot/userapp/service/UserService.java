package ru.rudnev.springboot.userapp.service;

import org.springframework.http.ResponseEntity;
import ru.rudnev.springboot.userapp.model.User;

import java.util.Collection;

public interface UserService {
    Collection<User> getAllUsers();

    ResponseEntity<User> getUserById(int id);

    User createUser(User user);

    ResponseEntity<User> updateUser(int id, User user);

    void deleteUser(int id);

    void deleteAllUsers();
}

package ru.rudnev.springboot.userapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.rudnev.springboot.userapp.dto.UserGetDto;
import ru.rudnev.springboot.userapp.dto.UserPostDto;
import ru.rudnev.springboot.userapp.model.User;
import ru.rudnev.springboot.userapp.repository.UserRepository;
import ru.rudnev.springboot.userapp.service.UserService;

import java.util.Collection;

@Controller
@RequestMapping(path="/api")
@AllArgsConstructor
public class MainController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Collection<UserGetDto>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserGetDto> getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody UserPostDto userPostDto) {
        return new ResponseEntity<>(userService.createUser(userPostDto), HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody UserPostDto userPostDto) {
        return userService.updateUser(id, userPostDto);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/users")
    public ResponseEntity<HttpStatus> deleteAllUsers() {
        userService.deleteAllUsers();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

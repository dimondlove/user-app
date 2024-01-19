package ru.rudnev.springboot.userapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.rudnev.springboot.userapp.model.User;
import ru.rudnev.springboot.userapp.repository.UserRepository;

@Controller
@RequestMapping(path="/app")
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public ResponseEntity<User> addNewUser (@RequestBody User user) {
        User _user = userRepository.save(new User(user.getUsername(), user.getEmail(), user.getPassword()));
        return new ResponseEntity<>(_user, HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}

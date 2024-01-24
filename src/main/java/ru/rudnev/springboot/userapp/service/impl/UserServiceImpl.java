package ru.rudnev.springboot.userapp.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.rudnev.springboot.userapp.dto.UserGetDto;
import ru.rudnev.springboot.userapp.dto.UserPostDto;
import ru.rudnev.springboot.userapp.model.User;
import ru.rudnev.springboot.userapp.repository.UserRepository;
import ru.rudnev.springboot.userapp.service.MappingUtils;
import ru.rudnev.springboot.userapp.service.UserService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final MappingUtils mappingUtils;

    @Override
    public Collection<UserGetDto> getAllUsers() {
        Collection<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users
                .stream()
                .map(mappingUtils::mapToUserGetDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public ResponseEntity<UserGetDto> getUserById(int id) {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent())
            return new ResponseEntity<>(mappingUtils.mapToUserGetDto(userData.get()), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public User createUser(UserPostDto userPostDto) {
        return userRepository.save(mappingUtils.mapToUSer(userPostDto));
    }

    @Override
    public ResponseEntity<User> updateUser(int id, UserPostDto userPostDto) {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            User user = userData.get();
            user.setUsername(userPostDto.getUsername());
            user.setEmail(userPostDto.getEmail());
            user.setPassword(userPostDto.getPassword());
            return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}

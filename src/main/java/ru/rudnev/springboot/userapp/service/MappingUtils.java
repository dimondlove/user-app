package ru.rudnev.springboot.userapp.service;

import org.springframework.stereotype.Service;
import ru.rudnev.springboot.userapp.dto.UserGetDto;
import ru.rudnev.springboot.userapp.dto.UserPostDto;
import ru.rudnev.springboot.userapp.model.User;

@Service
public class MappingUtils {
    public UserGetDto mapToUserGetDto(User user) {
        UserGetDto userGetDto = new UserGetDto();
        userGetDto.setUsername(user.getUsername());
        userGetDto.setEmail(user.getEmail());

        return userGetDto;
    }

    public User mapToUSer(UserPostDto userPostDto) {
        User user = new User();
        user.setId(userPostDto.getId());
        user.setUsername(userPostDto.getUsername());
        user.setEmail(userPostDto.getEmail());
        user.setPassword(userPostDto.getPassword());

        return user;
    }
}

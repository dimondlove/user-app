package ru.rudnev.springboot.userapp.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rudnev.springboot.userapp.dto.UserCreateDto;
import ru.rudnev.springboot.userapp.dto.UserResponseDto;
import ru.rudnev.springboot.userapp.model.User;
import ru.rudnev.springboot.userapp.repository.UserRepository;
import ru.rudnev.springboot.userapp.service.MappingUtils;
import ru.rudnev.springboot.userapp.service.UserService;

import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final MappingUtils mappingUtils;

    @Override
    public Collection<UserResponseDto> getAllUsers() {
        Collection<User> users = userRepository.findAll();
        return users
                .stream()
                .map(mappingUtils::mapToUserResponseDto)
                .toList();
    }

    @Override
    public UserResponseDto getUserById(int id) {
        Optional<User> userData = userRepository.findById(id);
        if (userData.isEmpty())
            return null;
        return mappingUtils.mapToUserResponseDto(userData.get());
    }

    @Override
    public UserResponseDto createUser(UserCreateDto userCreateDto) {
        return mappingUtils.mapToUserResponseDto(userRepository.save(mappingUtils.mapToUser(userCreateDto)));
    }

    @Override
    public UserResponseDto updateUser(int id, UserCreateDto userCreateDto) {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isEmpty())
            return null;

        User user = userData.get();
        user.setUsername(userCreateDto.getUsername());
        user.setEmail(userCreateDto.getEmail());
        user.setPassword(userCreateDto.getPassword());

        return mappingUtils.mapToUserResponseDto(userRepository.save(user));
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

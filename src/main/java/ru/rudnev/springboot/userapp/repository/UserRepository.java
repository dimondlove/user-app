package ru.rudnev.springboot.userapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.rudnev.springboot.userapp.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}

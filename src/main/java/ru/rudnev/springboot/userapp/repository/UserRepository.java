package ru.rudnev.springboot.userapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.rudnev.springboot.userapp.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

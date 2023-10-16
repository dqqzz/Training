package com.example.revatureproject5.JPA;

import com.example.revatureproject5.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long userId);
    Optional<User> findByUserName(String userName);

}


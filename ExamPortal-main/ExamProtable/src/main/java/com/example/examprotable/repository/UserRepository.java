package com.example.examprotable.repository;

import com.example.examprotable.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);

}

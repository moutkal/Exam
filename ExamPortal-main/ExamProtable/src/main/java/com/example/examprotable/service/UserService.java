package com.example.examprotable.service;

import com.example.examprotable.entities.User;
import com.example.examprotable.entities.UserRole;

import java.util.List;
import java.util.Set;

public interface UserService {
    public User createUser(User user, Set<UserRole> userRoles) ;

    public User getUser(String username);

    public List<User> getAllUser();

    public User updateUser(User user,Long id);

    public void deleteUser(Long id);
}

package com.example.examprotable.service;

import com.example.examprotable.entities.User;
import com.example.examprotable.entities.UserRole;
import com.example.examprotable.repository.RoleRepository;
import com.example.examprotable.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Override
    public User createUser(User user, Set<UserRole> userRoles) {
        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User already exists");
          //  throw new UserFoundException();

        } else {

            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user, Long id) {
        Optional<User> data=userRepository.findById(id);
        User _user=data.get();
        _user.setUsername(user.getUsername());
        return userRepository.save(_user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }
}

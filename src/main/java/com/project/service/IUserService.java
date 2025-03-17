package com.project.service;

import com.project.entity.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IUserService {

    List<User> getUsers();

    Optional<User> getUserById(Long id);
    User addUser(User user);
    Optional<User> updateUser(User user);
    Optional<User> deleteUser(User user);
}

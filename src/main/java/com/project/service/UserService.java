package com.project.service;

import com.project.entity.domain.User;
import com.project.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> updateUser(User user) {
        return getUserById(user.getId())
                .map(existingUser -> {
                    existingUser.setName(user.getName());
                    existingUser.setLastname(user.getLastname());
                    existingUser.setEmail(user.getEmail());
                    userRepository.save(existingUser);
                    return existingUser;
                });
    }

    @Override
    public Optional<User> deleteUser(User user) {
        return getUserById(user.getId())
                .map(existingUser -> {
                    userRepository.delete(existingUser);
                    return existingUser;
                });
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.of(userRepository.findById(id)
                .orElseThrow(new Exception("User not found")));
    }

}

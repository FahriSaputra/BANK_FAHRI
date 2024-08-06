package com.example.BANK_FAHRI.services;

import com.example.BANK_FAHRI.entity.User;
import com.example.BANK_FAHRI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(UUID uuid) {
        Optional<User> user = userRepository.findById(uuid);

        if (user.isEmpty()) {
            throw new NoSuchElementException("User not found");
        }

        return user;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(UUID uuid) {
        Optional<User> user = userRepository.findById(uuid);

        if (user.isEmpty()) {
            throw new NoSuchElementException("User not found with UUID: " + uuid);
        }

        userRepository.deleteById(uuid);
    }

    public void updateUser(UUID uuid, User user) {
        Optional<User> existingUser = userRepository.findById(uuid);

        if(existingUser.isEmpty()) {
            throw new NoSuchElementException("user not found");
        }

        if (user.getFull_name() != null) {
            existingUser.get().setFull_name(user.getFull_name());
        }
        if (user.getAddress() != null) {
            existingUser.get().setAddress(user.getAddress());
        }
        if (user.getBirth_place() != null) {
            existingUser.get().setBirth_place(user.getBirth_place());
        }
        if (user.getBirth_date() != null) {
            existingUser.get().setBirth_date(user.getBirth_date());
        }
        if (user.getPhone() != null) {
            existingUser.get().setPhone(user.getPhone());
        }

        userRepository.save(existingUser.get());
    }
}

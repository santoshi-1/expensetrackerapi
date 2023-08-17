package com.santoshi.expensetrackerapi.service;

import com.santoshi.expensetrackerapi.entity.User;
import com.santoshi.expensetrackerapi.entity.UserModal;
import com.santoshi.expensetrackerapi.exceptions.ItemAlreadyExistsException;
import com.santoshi.expensetrackerapi.exceptions.ResourceNotFoundException;
import com.santoshi.expensetrackerapi.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(UserModal userModal) {

        if (userRepository.existsByEmail(userModal.getEmail())) {
            throw new ItemAlreadyExistsException("User with email " + userModal.getEmail() + " already exists");
        }

        User user = new User();
        BeanUtils.copyProperties(userModal, user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User readUser(Long id) {
        return userRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

    @Override
    public User updateUser(User user, Long id) {
        User updatedUser = readUser(id);
        updatedUser.setName(user.getName() != null ? user.getName() : updatedUser.getName());
        updatedUser.setEmail(user.getEmail() != null ? user.getEmail() : updatedUser.getEmail());
        updatedUser.setPassword(user.getPassword() != null ? passwordEncoder.encode(user.getPassword()) : updatedUser.getPassword());
        updatedUser.setAge(user.getAge() != null ? user.getAge() : updatedUser.getAge());
        return userRepository.save(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = readUser(id);
        userRepository.delete(user);
    }
}

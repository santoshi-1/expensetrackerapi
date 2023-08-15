package com.santoshi.expensetrackerapi.service;

import com.santoshi.expensetrackerapi.entity.User;
import com.santoshi.expensetrackerapi.entity.UserModal;

public interface UserService {

    User registerUser(UserModal userModal);

    User readUser(Long id);

    User updateUser(User user, Long id);

    void deleteUser(Long id);

}

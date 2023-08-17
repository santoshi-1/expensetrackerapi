package com.santoshi.expensetrackerapi.service;

import com.santoshi.expensetrackerapi.entity.User;
import com.santoshi.expensetrackerapi.entity.UserModal;

public interface UserService {

    User registerUser(UserModal userModal);

    User readUser();

    User updateUser(User user);

    void deleteUser();

    User getLoggedInUser();

}

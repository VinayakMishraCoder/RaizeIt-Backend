package com.raiseit.backend.service;

import com.raiseit.backend.dto.UserRequest;
import com.raiseit.backend.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    User createUser(UserRequest request);

    User updateUser(Long id, UserRequest request);

    void deleteUser(Long id);
}


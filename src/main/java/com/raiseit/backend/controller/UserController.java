package com.raiseit.backend.controller;

import com.raiseit.backend.dto.user.UserRequest;
import com.raiseit.backend.model.User;
import com.raiseit.backend.service.UserService;
import com.raiseit.backend.utils.ResultWrapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ResultWrapper<?>> createUser(@Valid @RequestBody UserRequest request) {
        User user = userService.createUser(request);
        return ResponseEntity.ok(ResultWrapper.success("User created successfully", user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultWrapper<?>> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(ResultWrapper.success("User retrieved", user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResultWrapper<?>> updateUser(@PathVariable Long id, @Valid @RequestBody UserRequest request) {
        User user = userService.updateUser(id, request);
        return ResponseEntity.ok(ResultWrapper.success("User updated successfully", user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResultWrapper<?>> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(ResultWrapper.success("User deleted successfully", null));
    }

    @GetMapping
    public ResponseEntity<ResultWrapper<?>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(ResultWrapper.success("Users fetched", users));
    }
}

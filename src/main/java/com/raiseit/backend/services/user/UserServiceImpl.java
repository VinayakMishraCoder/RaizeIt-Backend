package com.raiseit.backend.services.user;

import com.raiseit.backend.dto.user.UserRequest;
import com.raiseit.backend.model.Role;
import com.raiseit.backend.model.User;
import com.raiseit.backend.repository.RoleRepository;
import com.raiseit.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User createUser(UserRequest request) {
        Role role = roleRepo.findByName(request.getRole())
                .orElseGet(() -> roleRepo.save(new Role(null, request.getRole())));

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setMobileNo(request.getMobileNo());
        user.setStatus(request.getStatus());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(role);

        return userRepo.save(user);
    }

    @Override
    public User updateUser(Long id, UserRequest request) {
        User user = getUserById(id);
        if (request.getName() != null) user.setName(request.getName());
        if (request.getMobileNo() != null) user.setMobileNo(request.getMobileNo());
        if (request.getStatus() != null) user.setStatus(request.getStatus());
        if (request.getPassword() != null) user.setPassword(passwordEncoder.encode(request.getPassword()));

        if (request.getRole() != null) {
            Role role = roleRepo.findByName(request.getRole())
                    .orElseGet(() -> roleRepo.save(new Role(null, request.getRole())));
            user.setRole(role);
        }

        return userRepo.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepo.delete(user);
    }
}


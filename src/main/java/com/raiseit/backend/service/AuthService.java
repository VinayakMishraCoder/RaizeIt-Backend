package com.raiseit.backend.service;

import com.raiseit.backend.config.JwtUtils;
import com.raiseit.backend.dto.RegisterRequest;
import com.raiseit.backend.model.Role;
import com.raiseit.backend.model.User;
import com.raiseit.backend.repository.RoleRepository;
import com.raiseit.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    public String login(String email, String password) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(),
                List.of(new SimpleGrantedAuthority(user.getRole().getName()))
        );

        return jwtUtils.generateToken(userDetails);
    }

    public void register(RegisterRequest request) {
        Role role = roleRepo.findByName(request.getRole())
                .orElseGet(() -> {
                    Role newRole = new Role();
                    newRole.setName(request.getRole());
                    return roleRepo.save(newRole);
                });


        User user = new User();
        user.setName(request.getName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setMobileNo(request.getMobileNo());
        user.setStatus(request.getStatus());
        user.setRole(role);

        userRepo.save(user);
    }

    public User loadUserByEmail(String email) {
        return userRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}


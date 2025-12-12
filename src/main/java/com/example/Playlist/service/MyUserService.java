package com.example.Playlist.service;

import com.example.Playlist.model.Permission;
import com.example.Playlist.model.User;
import com.example.Playlist.repository.PermissionRepository;
import com.example.Playlist.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PermissionRepository permissionRep;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }
        return user;
    }

    public User registr(User model) {
        if (userRepository.findByUsername(model.getEmail()) != null) {
            throw new IllegalArgumentException("User with this email already exists");
        }

        model.setPassword(passwordEncoder.encode(model.getPassword()));

        Permission userRole = permissionRep.findByName("ROLE_USER");
        if (userRole == null) {
            throw new IllegalStateException("ROLE_USER permission not found in DB");
        }

        model.setPermissions(List.of(userRole));
        return userRepository.save(model);
    }
}
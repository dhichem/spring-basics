package com.milkiyti.property_management.service.impl;

import com.milkiyti.property_management.dto.UserDTO;
import com.milkiyti.property_management.repository.UserRepository;
import com.milkiyti.property_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO register(UserDTO userDTO) {
        userRepository.save();
        return null;
    }

    @Override
    public UserDTO login(String email, String password) {
        return null;
    }
}
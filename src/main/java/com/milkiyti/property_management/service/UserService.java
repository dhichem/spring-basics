package com.milkiyti.property_management.service;

import com.milkiyti.property_management.dto.UserDTO;

public interface UserService {
    UserDTO register(UserDTO userDTO);
    UserDTO login(String email, String password);
}

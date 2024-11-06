package com.milkiyti.property_management.controller;

import com.milkiyti.property_management.dto.UserDTO;
import com.milkiyti.property_management.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.register(userDTO), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
        UserDTO ud = userService.login(userDTO.getEmail(), userDTO.getPassword());
        return new ResponseEntity<>(userService.login(userDTO.getEmail(), userDTO.getPassword()), HttpStatus.OK);
    }
}

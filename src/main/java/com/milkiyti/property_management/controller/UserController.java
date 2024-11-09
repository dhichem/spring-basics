package com.milkiyti.property_management.controller;

import com.milkiyti.property_management.dto.UserDTO;
import com.milkiyti.property_management.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "user login")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Login successfull",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = UserDTO.class)) }),
        @ApiResponse(responseCode = "400", description = "Email or Password incorrect") })
    @PostMapping(path = "/login", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
        UserDTO ud = userService.login(userDTO.getEmail(), userDTO.getPassword());
        return new ResponseEntity<>(userService.login(userDTO.getEmail(), userDTO.getPassword()), HttpStatus.OK);
    }
}

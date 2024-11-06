package com.milkiyti.property_management.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private Long id;
    @NotBlank(message = "first name is mandatory")
    private String fname;
    @NotBlank(message = "first name is mandatory")
    private String lname;
    @NotBlank(message = "Email is mandatory")
    private String email;
    private String phone;
    @NotBlank(message = "Password is mandatory")
    private String password;
}

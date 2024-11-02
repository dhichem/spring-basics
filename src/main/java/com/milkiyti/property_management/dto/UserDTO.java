package com.milkiyti.property_management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String fname;
    private String lname;
    private String email;
    private String phone;
    private String password;
}

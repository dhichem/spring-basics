package com.milkiyti.property_management.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private Long id;
    private String fname;
    private String lname;
    private String email;
    private String phone;
    private String password;
}

package com.milkiyti.property_management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDTO {
    private String title;
    private String description;
    private String ownerName;
    private String ownerEmail;
    private Double Price;
    private String address;
}

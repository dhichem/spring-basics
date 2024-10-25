package com.milkiyti.property_management.controller;

import com.milkiyti.property_management.dto.PropertyDTO;
import com.milkiyti.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    @Autowired
    public PropertyService propertyService;

    @GetMapping("/hello")
    public String printHello() {
        return "Hello";
    }

    @PostMapping()
    public PropertyDTO saveProperty(@RequestBody PropertyDTO propertyDTO) {
        propertyService.saveProperty(propertyDTO);
        return propertyDTO;
    }
}

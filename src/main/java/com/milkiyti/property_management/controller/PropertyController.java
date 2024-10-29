package com.milkiyti.property_management.controller;

import com.milkiyti.property_management.dto.PropertyDTO;
import com.milkiyti.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO) {
        propertyDTO = propertyService.saveProperty(propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping()
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
        List<PropertyDTO> listPd = propertyService.getAllProperties();
        ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(listPd, HttpStatus.OK);
        return responseEntity;
    }
}

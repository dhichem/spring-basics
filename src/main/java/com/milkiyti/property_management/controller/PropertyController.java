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

    @PutMapping("/{id}/update")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long id) {
        PropertyDTO pd = propertyService.updateProperty(propertyDTO, id);
        ResponseEntity<PropertyDTO> responseEntity;
        if(pd != null)
            responseEntity = new ResponseEntity<>(pd, HttpStatus.OK);
        else
            responseEntity = new ResponseEntity<>(pd, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
        ResponseEntity<String> responseEntity = new ResponseEntity<>("Delete Success", HttpStatus.OK);
        return responseEntity;
    }
}

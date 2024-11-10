package com.milkiyti.property_management.controller;

import com.milkiyti.property_management.dto.PropertyDTO;
import com.milkiyti.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    @Autowired
    public PropertyService propertyService;

    @Value("${test.var2:}")
    private String testVar;

    @GetMapping("/hello")
    public String printHello() {
        return testVar;
    }

    @PostMapping()
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO) {
        propertyDTO = propertyService.saveProperty(propertyDTO);
        return new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
        List<PropertyDTO> listPd = propertyService.getAllProperties();
        return new ResponseEntity<>(listPd, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<List<PropertyDTO>> getUserProperties(@PathVariable("id") Long id) {
        List<PropertyDTO> listPd = propertyService.getUserProperties(id);
        return new ResponseEntity<>(listPd, HttpStatus.OK);
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
        return new ResponseEntity<>("Delete Success", HttpStatus.OK);
    }
}

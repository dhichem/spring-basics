package com.milkiyti.property_management.service;

import com.milkiyti.property_management.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {
    PropertyDTO saveProperty(PropertyDTO propertyDTO);
    List<PropertyDTO> getAllProperties();
    List<PropertyDTO> getUserProperties(Long id);
    PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId);
    void deleteProperty(Long id);
}

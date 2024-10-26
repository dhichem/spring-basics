package com.milkiyti.property_management.service.impl;

import com.milkiyti.property_management.dto.PropertyDTO;
import com.milkiyti.property_management.entity.PropertyEntity;
import com.milkiyti.property_management.repository.PropertyRepository;
import com.milkiyti.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// by using "service" (it can be component, repository, ...) we're making this serivce implementation class a singelton
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity pe = new PropertyEntity();
        pe.setTitle(propertyDTO.getTitle());
        pe.setDescription(propertyDTO.getDescription());
        pe.setOwnerName(propertyDTO.getOwnerName());
        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
        pe.setAddress(propertyDTO.getAddress());
        pe.setPrice(propertyDTO.getPrice());
        propertyRepository.save(pe);
        return null;
    }
}

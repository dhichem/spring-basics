package com.milkiyti.property_management.service.impl;

import com.milkiyti.property_management.converter.PropertyConverter;
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
    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = propertyRepository.save(propertyConverter.convertDTOToEntity(propertyDTO));
        return propertyConverter.convertEntityToDTO(propertyEntity);
    }
}

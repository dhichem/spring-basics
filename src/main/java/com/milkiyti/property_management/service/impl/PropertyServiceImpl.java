package com.milkiyti.property_management.service.impl;

import com.milkiyti.property_management.dto.PropertyDTO;
import com.milkiyti.property_management.service.PropertyService;
import org.springframework.stereotype.Service;

@Service // by using "service" (it can be component, repository, ...) we're making this serivce implementation class a singelton
public class PropertyServiceImpl implements PropertyService {
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        return null;
    }
}

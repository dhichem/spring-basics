package com.milkiyti.property_management.converter;

import com.milkiyti.property_management.dto.PropertyDTO;
import com.milkiyti.property_management.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {
    public PropertyEntity convertDTOToEntity(PropertyDTO pd) {
        PropertyEntity pe = new PropertyEntity();
        pe.setTitle(pd.getTitle());
        pe.setDescription(pd.getDescription());
        pe.setOwnerName(pd.getOwnerName());
        pe.setOwnerEmail(pd.getOwnerEmail());
        pe.setAddress(pd.getAddress());
        pe.setPrice(pd.getPrice());

        return pe;
    }
}

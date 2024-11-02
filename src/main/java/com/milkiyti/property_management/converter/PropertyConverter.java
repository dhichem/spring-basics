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
        pe.setAddress(pd.getAddress());
        pe.setPrice(pd.getPrice());

        return pe;
    }

    public PropertyDTO convertEntityToDTO(PropertyEntity pe) {
        PropertyDTO pd = new PropertyDTO();
        pd.setId(pe.getId());
        pd.setTitle(pe.getTitle());
        pd.setDescription(pe.getDescription());
        pd.setAddress(pe.getAddress());
        pd.setPrice(pe.getPrice());

        return pd;
    }
}

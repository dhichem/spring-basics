package com.milkiyti.property_management.service.impl;

import com.milkiyti.property_management.converter.PropertyConverter;
import com.milkiyti.property_management.dto.PropertyDTO;
import com.milkiyti.property_management.entity.PropertyEntity;
import com.milkiyti.property_management.repository.PropertyRepository;
import com.milkiyti.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> listPe = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> listPd = new ArrayList<>();
        for (PropertyEntity pe : listPe) {
            listPd.add(propertyConverter.convertEntityToDTO(pe));
        }
        return  listPd;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO pd, Long propertyId) {
        Optional<PropertyEntity> optEntity = propertyRepository.findById(propertyId);
        if (optEntity.isPresent()) {
            PropertyEntity pe = optEntity.get();
            pe.setTitle(pd.getTitle());
            pe.setDescription(pd.getDescription());
            pe.setAddress(pd.getAddress());
            pe.setPrice(pd.getPrice());

            return propertyConverter.convertEntityToDTO(propertyRepository.save(pe));
        }
        return null;
    }

    @Override
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }
}

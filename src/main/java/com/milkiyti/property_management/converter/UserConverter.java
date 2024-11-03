package com.milkiyti.property_management.converter;

import com.milkiyti.property_management.dto.UserDTO;
import com.milkiyti.property_management.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity convertDTOToEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFname(userDTO.getFname());
        userEntity.setLname(userDTO.getLname());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPhone(userDTO.getPhone());
        userEntity.setPassword(userDTO.getPassword());

        return userEntity;
    }

    public UserDTO convertEntityToDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setFname(userEntity.getFname());
        userDTO.setLname(userEntity.getLname());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setPhone(userEntity.getPhone());

        return userDTO;
    }
}

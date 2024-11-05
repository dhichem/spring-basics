package com.milkiyti.property_management.service.impl;

import com.milkiyti.property_management.converter.UserConverter;
import com.milkiyti.property_management.dto.UserDTO;
import com.milkiyti.property_management.entity.UserEntity;
import com.milkiyti.property_management.exception.BusinessException;
import com.milkiyti.property_management.exception.ErrorModel;
import com.milkiyti.property_management.repository.UserRepository;
import com.milkiyti.property_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        Optional<UserEntity> optUe = userRepository.findByEmail(userDTO.getEmail());
        if(optUe.isPresent()) {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel error = new ErrorModel();
            error.setCode("EMAIL_EXISTS");
            error.setMessage("Email already exists. Try another one");
            errorModelList.add(error);
            throw new BusinessException(errorModelList, HttpStatusCode.valueOf(400));
        }
        UserEntity userEntity = userRepository.save(userConverter.convertDTOToEntity(userDTO));
        return userConverter.convertEntityToDTO(userEntity);
    }

    @Override
    public UserDTO login(String email, String password) {
        Optional<UserEntity> optEntity = userRepository.findByEmailAndPassword(email, password);
        if (optEntity.isPresent()) {
            return userConverter.convertEntityToDTO(optEntity.get());
        } else {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel error = new ErrorModel();
            error.setCode("INVALID_CREDENTIALS");
            error.setMessage("Email or Password incorrect");
            errorModelList.add(error);
            throw new BusinessException(errorModelList, HttpStatusCode.valueOf(400));
        }
    }
}

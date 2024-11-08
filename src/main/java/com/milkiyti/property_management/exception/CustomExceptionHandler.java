package com.milkiyti.property_management.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException notValidExc) {
        List<ErrorModel> errorModelList = new ArrayList<>();
        ErrorModel errorModel = null;
        List<FieldError> fieldErrors = notValidExc.getBindingResult().getFieldErrors();

        for (FieldError fe: fieldErrors) {
            logger.info("field validation: {} {}", fe.getCode(), fe.getDefaultMessage());
            logger.warn("field validation: {} {}", fe.getCode(), fe.getDefaultMessage());
            logger.error("field validation: {} {}", fe.getCode(), fe.getDefaultMessage());
            errorModel = new ErrorModel();
            errorModel.setCode(fe.getCode());
            errorModel.setMessage(fe.getDefaultMessage());
            errorModelList.add(errorModel);
        }

        return new ResponseEntity<>(errorModelList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException bex) {
        return new ResponseEntity<>(bex.getErrors(), bex.getStatusCode());
    }
}

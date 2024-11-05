package com.milkiyti.property_management.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BusinessException extends RuntimeException{

    private List<ErrorModel> errors;
    private HttpStatusCode statusCode;

    public BusinessException(List<ErrorModel> errors, HttpStatusCode statusCode) {
        this.errors = errors;
        this.statusCode = statusCode;
    }
}

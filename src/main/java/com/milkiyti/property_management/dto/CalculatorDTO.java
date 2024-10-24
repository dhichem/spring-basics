package com.milkiyti.property_management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculatorDTO {
    private Double num1;
    private Double num2;
    @JsonProperty("num3A")
    private Double num3;
}

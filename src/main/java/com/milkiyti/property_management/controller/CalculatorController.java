package com.milkiyti.property_management.controller;

import com.milkiyti.property_management.dto.CalculatorDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator") // class level mapping of a url to a controller class
public class CalculatorController {

    @GetMapping("/add") // method level mapping of a url to a controller function
    public Double add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2) {
        return num1 + num2;
    }

    @GetMapping("sub/{num1}/{num2}")
    public Double substract(@PathVariable("num1") Double num1,@PathVariable("num2") Double num2) {
        if(num1<num2)
            return num2 - num1;
        else
            return num1 - num2;
    }

    @PostMapping("/multiply")
    public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO cl) {
        Double result = cl.getNum1() * cl.getNum2() * cl.getNum3();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatusCode.valueOf(201));
        return responseEntity;
    }
}

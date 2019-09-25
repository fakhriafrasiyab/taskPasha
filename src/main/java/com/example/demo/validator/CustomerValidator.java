package com.example.demo.validator;

import com.example.demo.model.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

@ControllerAdvice
public class CustomerValidator extends ResponseEntityExceptionHandler {

    /*protected ResponseEntity<Object> handleMethod(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus httpStatus, WebRequest request) {
        Map<String, Object> exceptionMapBody = new LinkedHashMap<>();
        exceptionMapBody.put("timestamp", new Date());
        exceptionMapBody.put("HTTP status", httpStatus.value());

        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.toList());
        exceptionMapBody.put("errors",errors);
        return new ResponseEntity<>(exceptionMapBody,headers,httpStatus);
    }*/

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> details = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        ErrorResponse error = new ErrorResponse("Validation Failed", details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
}

package com.example.demo.validator;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomerValidator extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Object> handleMethod(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus httpStatus, WebRequest request) {
        Map<String, Object> exceptionMapBody = new LinkedHashMap<>();
        exceptionMapBody.put("timestamp", new Date());
        exceptionMapBody.put("HTTP status", httpStatus.value());

        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.toList());
        exceptionMapBody.put("errors",errors);
        return new ResponseEntity<>(exceptionMapBody,headers,httpStatus);
    }
}

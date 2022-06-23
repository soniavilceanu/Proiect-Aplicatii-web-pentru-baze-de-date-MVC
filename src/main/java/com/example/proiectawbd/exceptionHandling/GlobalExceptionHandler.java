package com.example.proiectawbd.exceptionHandling;
import com.example.proiectawbd.exceptions.*;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {



    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NoLibrarianFoundException.class, NoLibraryFoundException.class, NoBookFoundException.class, NoAuthorFoundException.class, NoBookDetailsFoundException.class, NoPublisherFoundException.class})
    public ModelAndView handleException(Exception exception){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModel().put("exception",exception);
        modelAndView.getModel().put("exception",exception);
        modelAndView.setViewName("notfound");
        return modelAndView;



        //responseParameters.put("Reason: ", exception.getMessage());
        //responseParameters.put("DateTime: ", LocalDateTime.now().toString());
        //return ResponseEntity.badRequest().body(responseParameters);
    }




    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ModelAndView handleApiValidationForClasses(MethodArgumentNotValidException exception){
        Map<String, Object> responseParameters = new HashMap<>();
        List<String> errors = exception.getBindingResult().getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

//        responseParameters.put("Reason: ", errors);
//        responseParameters.put("DateTime: ", LocalDateTime.now().toString());
//
//        return ResponseEntity.badRequest().body(responseParameters);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModel().put("exception",errors);
        modelAndView.setViewName("notfound");
        return modelAndView;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ModelAndView handleApiValidationForParameters(ConstraintViolationException exception){
        Map<String, Object> responseParameters = new HashMap<>();
        List<String> errors = exception.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());

//        responseParameters.put("Reason: ", errors);
//        responseParameters.put("DateTime: ", LocalDateTime.now().toString());
//
//        return ResponseEntity.badRequest().body(responseParameters);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModel().put("exception",errors);
        modelAndView.setViewName("notfound");
        return modelAndView;
    }


}


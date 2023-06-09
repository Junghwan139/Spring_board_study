package com.example.spring_board_study.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler (EntityNotFoundException.class)
    public ResponseEntity<String> notFound(Exception e){
        String context = "<header><h1>존재하지 않는 화면입니다.</h1></header>";
        return new ResponseEntity<String>(context, HttpStatus.NOT_FOUND);

    }



}

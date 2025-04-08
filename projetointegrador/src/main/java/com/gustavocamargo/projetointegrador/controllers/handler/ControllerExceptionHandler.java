package com.gustavocamargo.projetointegrador.controllers.handler;

import com.gustavocamargo.projetointegrador.dtos.CustomError;
import com.gustavocamargo.projetointegrador.services.exception.DataBaseConnectionException;
import com.gustavocamargo.projetointegrador.services.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methosArgumentNotValidException (MethodArgumentNotValidException e){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        CustomError customError = new CustomError("Dados invalidos");
        return ResponseEntity.status(status).body(customError);
    }

    @ExceptionHandler(DataBaseConnectionException.class)
    public ResponseEntity<CustomError> dataBaseConnectionException (DataBaseConnectionException e){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        CustomError customError = new CustomError("Erro ao conectar com banco de dados");
        return ResponseEntity.status(status).body(customError);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError>  resourceNotFoundException (ResourceNotFoundException e){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError customError = new CustomError("Recurso nao encotrado");
        return ResponseEntity.status(status).body(customError);
    }


}

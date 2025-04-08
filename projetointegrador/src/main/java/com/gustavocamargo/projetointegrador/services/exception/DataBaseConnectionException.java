package com.gustavocamargo.projetointegrador.services.exception;

public class DataBaseConnectionException extends RuntimeException{

    public DataBaseConnectionException(String message){
        super(message);
    }

    public DataBaseConnectionException() {
        super();
    }
}

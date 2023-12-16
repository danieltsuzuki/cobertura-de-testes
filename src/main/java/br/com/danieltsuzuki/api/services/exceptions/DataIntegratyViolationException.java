package br.com.danieltsuzuki.api.services.exceptions;

public class DataIntegratyViolationException extends RuntimeException{

    public DataIntegratyViolationException(String messasge){
        super(messasge);
    }

}

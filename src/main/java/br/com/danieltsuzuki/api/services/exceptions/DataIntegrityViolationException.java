package br.com.danieltsuzuki.api.services.exceptions;

public class DataIntegrityViolationException extends RuntimeException{

    public DataIntegrityViolationException(String messasge){
        super(messasge);
    }

}

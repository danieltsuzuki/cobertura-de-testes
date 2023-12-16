package br.com.danieltsuzuki.api.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(String messasge){
        super(messasge);
    }

}

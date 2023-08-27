package tech.ada.bootcamp.arquitetura.cafeservice.exceptions;


import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException{
    private String entityNotFound;
    public NotFoundException(String entityNotFound){
        this.entityNotFound = entityNotFound;
    }

}

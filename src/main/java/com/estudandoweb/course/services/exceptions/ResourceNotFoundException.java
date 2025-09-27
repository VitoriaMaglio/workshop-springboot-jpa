package com.estudandoweb.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id " + id);//construtor q recebe o id do obj que vc tentou encontrar e não encontrou
    }
}

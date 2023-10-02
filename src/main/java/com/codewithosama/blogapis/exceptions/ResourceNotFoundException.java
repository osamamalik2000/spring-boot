package com.codewithosama.blogapis.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
    String resourceName;   
    String filedName;
    int filedValue;

    public ResourceNotFoundException(String resourceName, String filedName, int filedValue) {
        super(String.format("%s not found with %s : %d", resourceName, filedName, filedValue));
        this.resourceName = resourceName;
        this.filedName = filedName;
        this.filedValue = filedValue;
    }
}

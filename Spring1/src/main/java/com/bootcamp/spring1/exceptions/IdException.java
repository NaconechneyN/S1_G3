package com.bootcamp.spring1.exceptions;

public class IdException extends RuntimeException{
    public IdException() {
    }

    public IdException(String message) {
        super(message);
    }
}
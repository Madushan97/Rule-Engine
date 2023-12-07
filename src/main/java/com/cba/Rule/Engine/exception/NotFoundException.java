package com.cba.Rule.Engine.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String msg) {
        super(msg);
    }

    public NotFoundException(String msg, Throwable ex) {
        super(msg, ex);
    }
}

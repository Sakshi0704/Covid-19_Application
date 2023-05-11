package com.covid.exception;

import org.aspectj.bridge.Message;

public class ResourceNotFoundException extends Exception{

    public ResourceNotFoundException(String message){
        super(message);
    }
    
}
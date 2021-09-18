package com.example.demo.exceptions;

import com.example.demo.utils.ApiMessage;

public class CarAlreadyInUseException extends APIException{

    private static final long serialVersionUID = 1L;

    public CarAlreadyInUseException(ApiMessage messageUtil) {
        super(messageUtil);
    }

    public CarAlreadyInUseException(String message) {
        super(message);
    }
}

package com.example.demo.exceptions;

import com.example.demo.utils.ApiMessage;

public class ValidationException extends APIException{

    private static final long serialVersionUID = 1L;

    public ValidationException(ApiMessage messageUtil) {
        super(messageUtil);
    }

}

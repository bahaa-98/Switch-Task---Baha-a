package com.example.demo.exceptions;

import com.example.demo.utils.ApiMessage;

public class AuthenticationException extends APIException{

    private static final long serialVersionUID = 1L;

    public AuthenticationException(ApiMessage messageUtil) {
        super(messageUtil);
    }
}

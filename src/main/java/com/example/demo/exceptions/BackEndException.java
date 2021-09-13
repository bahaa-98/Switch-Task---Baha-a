package com.example.demo.exceptions;

import com.example.demo.utils.ApiMessage;

public class BackEndException extends APIException{

    private static final long serialVersionUID = 1L;

    public BackEndException(ApiMessage messageUtil) {
        super(messageUtil);
    }
}

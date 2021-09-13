package com.example.demo.exceptions;

import com.example.demo.utils.ApiMessage;

public class APIException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private ApiMessage messageUtil;
    private String message;

    public APIException(ApiMessage messageUtil)
    {
        this.messageUtil = messageUtil;
    }

    public APIException(String message){
        super(message);
        this.message = message;
    }

    public ApiMessage getMessageUtil() {
        return messageUtil;
    }

    public void setMessageUtil(ApiMessage messageUtil) {
        this.messageUtil = messageUtil;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.example.demo.utils;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseUtil {

    private int code;
    private String status;
    private ApiMessage message;
    private Object data;
    private Long size;

    public ResponseUtil(int code, String status, ApiMessage message, Object data, Long size) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.data = data;
        this.size = size;
    }
}

package com.example.demo.model.request;

import com.example.demo.model.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DriverReqLoginModel {
    private String email;
    private String password;
}

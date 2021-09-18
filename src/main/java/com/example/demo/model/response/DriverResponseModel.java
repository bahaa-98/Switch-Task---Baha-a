package com.example.demo.model.response;

import com.example.demo.model.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DriverResponseModel extends BaseModel {

    private String email;
    private String token;

    public DriverResponseModel(Long id,String email, String token) {
        super(id);
        this.email = email;
        this.token = token;
    }
}

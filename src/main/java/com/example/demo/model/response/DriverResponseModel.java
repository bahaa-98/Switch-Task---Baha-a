package com.example.demo.model.response;

import com.example.demo.model.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DriverResponseModel extends BaseModel {
    public DriverResponseModel(Long id) {
        super(id);
    }
}

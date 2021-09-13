package com.example.demo.model.response;

import com.example.demo.model.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CarResponseModel extends BaseModel {
    public CarResponseModel(Long id) {
        super(id);
    }
}

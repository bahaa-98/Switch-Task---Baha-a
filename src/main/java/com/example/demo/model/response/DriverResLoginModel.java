package com.example.demo.model.response;

import com.example.demo.model.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DriverResLoginModel extends BaseModel {
    public DriverResLoginModel(Long id) {
        super(id);
    }
}

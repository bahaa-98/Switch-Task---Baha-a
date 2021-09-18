package com.example.demo.model.request;

import com.example.demo.model.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ManufacturerRequestModel extends BaseModel {

    private String name;

    public ManufacturerRequestModel(Long id) {
        super(id);
    }
}

package com.example.demo.model.response;

import com.example.demo.model.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ManufacturerResponseModel extends BaseModel {

    private String name;

    public ManufacturerResponseModel(Long id,String name){
        super(id);
        this.name = name;
    }

}

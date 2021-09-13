package com.example.demo.model.base;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Setter
@Getter
public class BaseModel {

    private Long id;

    public BaseModel(Long id){this.id = id;}

}

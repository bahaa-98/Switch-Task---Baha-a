package com.example.demo.model.response;

import com.example.demo.domain.base.IEntity;
import com.example.demo.model.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Setter
@Getter
public class ManufacturerResponseModel extends BaseModel implements IEntity {

    private String name;

    public ManufacturerResponseModel(Long id,String name){
        super(id);
        this.name = name;
    }

    @Override
    public ZonedDateTime getDateCreated() {
        return null;
    }

    @Override
    public void setDateCreated(ZonedDateTime dateCreated) {

    }

    @Override
    public Boolean getActive() {
        return null;
    }

    @Override
    public void setActive(Boolean active) {

    }
}

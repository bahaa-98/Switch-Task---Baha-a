package com.example.demo.model.response;

import com.example.demo.domain.Driver;
import com.example.demo.domain.Manufacturer;
import com.example.demo.model.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CarResponseModel extends BaseModel {

    private String licensePlate;

    private int seatCount;

    private Boolean convertible;

    private int rating;

    private String engineType;

    private Manufacturer manufacturer;

    private Driver driver;

    public CarResponseModel(Long id, String licensePlate, int seatCount, Boolean convertible, int rating, String engineType, Manufacturer manufacturer, Driver driver) {
        super(id);
        this.licensePlate = licensePlate;
        this.seatCount = seatCount;
        this.convertible = convertible;
        this.rating = rating;
        this.engineType = engineType;
        this.manufacturer = manufacturer;
        this.driver = driver;
    }
}

package com.example.demo.model.request;

import com.example.demo.domain.Driver;
import com.example.demo.domain.EngineType;
import com.example.demo.domain.Manufacturer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Setter
@Getter
public class CarRequestModel{

    private String licensePlate;

    private int seatCount;

    private Boolean convertible;

    private int rating;

    private EngineType engineType;

    private Manufacturer manufacturer;

    private Driver driver;


}

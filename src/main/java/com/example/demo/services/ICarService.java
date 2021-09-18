package com.example.demo.services;

import com.example.demo.domain.Car;
import com.example.demo.services.base.IService;

import java.util.List;

public interface ICarService extends IService<Car> {

    List<Car> getAll();
    List<Car> findByManufacturer(Long manufacturerId);
    void selectCar(Long carId, Long driverId);
    void deSelectCar(Long carId, Long driverId);
}

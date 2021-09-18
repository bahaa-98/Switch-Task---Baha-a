package com.example.demo.repository;

import com.example.demo.domain.Car;
import com.example.demo.repository.base.BaseRepo;

import java.util.List;

public interface CarRepo extends BaseRepo<Car, Long> {

    List<Car> findByManufacturer(Long manufacturerId);

    Car findByDriver(Long driverId);

}

package com.example.demo.services;

import com.example.demo.domain.Car;
import com.example.demo.services.base.IService;

import java.util.List;

public interface ICarService extends IService<Car> {

    List<Car> getAll();
}

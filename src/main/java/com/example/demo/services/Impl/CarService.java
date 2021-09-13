package com.example.demo.services.Impl;

import com.example.demo.domain.Car;
import com.example.demo.repository.CarRepo;
import com.example.demo.services.ICarService;
import com.example.demo.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService extends BaseService<Car> implements ICarService {

    @Autowired
    private CarRepo carRepo;

    @Override
    protected JpaRepository<Car, Long> getRepository() {
        return carRepo;
    }
}

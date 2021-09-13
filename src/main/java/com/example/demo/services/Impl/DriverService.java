package com.example.demo.services.Impl;

import com.example.demo.domain.Car;
import com.example.demo.domain.Driver;
import com.example.demo.repository.DriverRepo;
import com.example.demo.services.ICarService;
import com.example.demo.services.IDriver;
import com.example.demo.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DriverService extends BaseService<Driver> implements IDriver {

    @Autowired
    private DriverRepo driverRepo;

    @Override
    protected JpaRepository<Driver, Long> getRepository() {
        return driverRepo;
    }
}

package com.example.demo.services.Impl;

import com.example.demo.domain.Car;
import com.example.demo.repository.CarRepo;
import com.example.demo.repository.DriverRepo;
import com.example.demo.repository.ManufacturerRepo;
import com.example.demo.services.ICarService;
import com.example.demo.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService extends BaseService<Car> implements ICarService {

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ManufacturerRepo manufacturerRepo;

    @Override
    protected JpaRepository<Car, Long> getRepository() {
        return carRepo;
    }



    @Override
    public List<Car> getAll() {
        return carRepo.findAll();
    }

    @Override
    public List<Car> findByManufacturer(Long manufacturerId) {
        return carRepo.findByManufacturer(manufacturerId);
    }

    @Override
    public void selectCar(Long carId, Long driverId) {
        Car car = carRepo.getById(carId);
        car.setDriver(driverRepo.getById(driverId));
        carRepo.save(car);
    }

    @Override
    public void deSelectCar(Long carId, Long driverId) {
        Car car = carRepo.getById(carId);
        car.setDriver(null);
        carRepo.save(car);
    }
}

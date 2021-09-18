package com.example.demo.services.Impl;

import com.example.demo.domain.Car;
import com.example.demo.domain.Driver;
import com.example.demo.repository.DriverRepo;
import com.example.demo.services.ICarService;
import com.example.demo.services.IDriver;
import com.example.demo.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;

@Service
public class DriverService extends BaseService<Driver> implements IDriver {

    @Autowired
    private DriverRepo driverRepo;

    @Override
    protected JpaRepository<Driver, Long> getRepository() {
        return driverRepo;
    }

    @Override
    public void preAdd(Driver entity) {

        int strength = 10;
        BCryptPasswordEncoder bCryptPasswordEncoder =
                new BCryptPasswordEncoder(strength, new SecureRandom());
        String encodedPassword = bCryptPasswordEncoder.encode(entity.getPassword());

        entity.setPassword(encodedPassword);
        super.preAdd(entity);
    }

    @Override
    public List<Driver> getAll() {
        return driverRepo.findAll();
    }

    @Override
    public Driver findByEmail(String email) {
        return driverRepo.findByEmail(email);
    }
}

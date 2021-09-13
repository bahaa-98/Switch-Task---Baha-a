package com.example.demo.services.Impl;

import com.example.demo.domain.Manufacturer;
import com.example.demo.repository.ManufacturerRepo;
import com.example.demo.services.IManufacturer;
import com.example.demo.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService extends BaseService<Manufacturer> implements IManufacturer {

    @Autowired
    private ManufacturerRepo manufacturerRepo;

    @Override
    protected JpaRepository<Manufacturer, Long> getRepository() {
        return manufacturerRepo;
    }

    @Override
    public List<Manufacturer> getAll(){
        return manufacturerRepo.findAll();
    }
}

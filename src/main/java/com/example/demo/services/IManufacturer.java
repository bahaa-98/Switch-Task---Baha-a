package com.example.demo.services;

import com.example.demo.domain.Manufacturer;
import com.example.demo.model.response.ManufacturerResponseModel;
import com.example.demo.repository.ManufacturerRepo;
import com.example.demo.services.base.IService;

import java.util.List;

public interface IManufacturer extends IService<Manufacturer> {

    List<Manufacturer> getAll();
}

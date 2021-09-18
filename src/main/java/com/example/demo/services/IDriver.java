package com.example.demo.services;

import com.example.demo.domain.Driver;
import com.example.demo.services.base.IService;

import java.util.List;

public interface IDriver extends IService<Driver> {

    List<Driver> getAll();

    Driver findByEmail(String email);
}

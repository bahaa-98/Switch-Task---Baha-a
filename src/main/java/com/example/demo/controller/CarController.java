package com.example.demo.controller;

import com.example.demo.domain.Car;
import com.example.demo.domain.Manufacturer;
import com.example.demo.model.request.CarRequestModel;
import com.example.demo.model.response.CarResponseModel;
import com.example.demo.services.ICarService;
import com.example.demo.utils.Constants;
import com.example.demo.utils.Helper;
import com.example.demo.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private ICarService carService;

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ResponseUtil> add(@RequestBody CarRequestModel carRequestModel){

        Car entity = new Car();
        entity.setRating(carRequestModel.getRating());
        entity.setConvertible(carRequestModel.getConvertible());
        entity.setDriver(carRequestModel.getDriver());
        entity.setEngineType(carRequestModel.getEngineType());
        entity.setManufacturer(carRequestModel.getManufacturer());
        entity.setLicensePlate(carRequestModel.getLicensePlate());
        entity.setSeatCount(carRequestModel.getSeatCount());

        carService.add(entity);

        CarResponseModel carResponseModel = new CarResponseModel(entity.getId(),carRequestModel.getLicensePlate(),carRequestModel.getSeatCount(),carRequestModel.getConvertible(),carRequestModel.getRating(),carRequestModel.getEngineType());

        return new ResponseEntity<ResponseUtil>(new ResponseUtil(201, Constants.SUCCESS_STATUS, Helper.getLocaleMessage("created.success",messageSource),carResponseModel,1L), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ResponseUtil> get(){
        List<Car> cars = carService.getAll();

        return new ResponseEntity<ResponseUtil>(new ResponseUtil(200, Constants.SUCCESS_STATUS,Helper.getLocaleMessage("retrieved.success",messageSource),cars,(long)cars.size()),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{carId}")
    public ResponseEntity<ResponseUtil> getById(@PathVariable("carId") Long carId){
        Car car = carService.findOne(carId);

        return new ResponseEntity<ResponseUtil>(new ResponseUtil(200, Constants.SUCCESS_STATUS,Helper.getLocaleMessage("retrieved.success",messageSource),car,1L),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/{id}")
    public ResponseEntity<ResponseUtil> edit(@RequestBody CarRequestModel carRequestModel, @PathVariable("id") Long id){
        Car entity = new Car();
        entity.setId(id);
        entity.setRating(carRequestModel.getRating());
        entity.setConvertible(carRequestModel.getConvertible());
        entity.setDriver(carRequestModel.getDriver());
        entity.setEngineType(carRequestModel.getEngineType());
        entity.setManufacturer(carRequestModel.getManufacturer());
        entity.setLicensePlate(carRequestModel.getLicensePlate());
        entity.setSeatCount(carRequestModel.getSeatCount());

        carService.update(entity,id);
        return new ResponseEntity<ResponseUtil>(new ResponseUtil(200,Constants.SUCCESS_STATUS,Helper.getLocaleMessage("updated.success",messageSource),entity,1L),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") Long id){
        carService.softDelete(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/selectCar")
    public void selectCar(@RequestParam Long carId, @RequestParam Long driverId){
        carService.selectCar(carId,driverId);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/deSelectCar")
    public void deSelectCar(@RequestParam Long carId, @RequestParam Long driverId){
        carService.deSelectCar(carId,driverId);
    }
}

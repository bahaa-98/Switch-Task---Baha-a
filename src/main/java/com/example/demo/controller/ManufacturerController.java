package com.example.demo.controller;

import com.example.demo.controller.base.IBaseController;
import com.example.demo.domain.Manufacturer;
import com.example.demo.model.request.ManufacturerRequestModel;
import com.example.demo.model.response.ManufacturerResponseModel;
import com.example.demo.services.IManufacturer;
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
@RequestMapping("/manufacturers")
public class ManufacturerController implements IBaseController<ManufacturerResponseModel,Manufacturer> {

    @Autowired
    private IManufacturer manufacturerService;

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ResponseUtil> addManufacturer(@RequestBody Manufacturer entity){

        manufacturerService.add(entity);
        return new ResponseEntity<ResponseUtil>(new ResponseUtil(201, Constants.SUCCESS_STATUS, Helper.getLocaleMessage("created.success",messageSource),entity,1L), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ResponseUtil> getManufacturer(){
        List<Manufacturer> models =  manufacturerService.getAll();
       return new ResponseEntity<ResponseUtil>(new ResponseUtil(200, Constants.SUCCESS_STATUS, Helper.getLocaleMessage("retrieved.success",messageSource),models,(long)models.size()),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{manufacturerId}")
    public ResponseEntity<ResponseUtil> getById(@PathVariable("manufacturerId") Long manufacturerId){
        Manufacturer manufacturer = manufacturerService.findOne(manufacturerId);

        return new ResponseEntity<ResponseUtil>(new ResponseUtil(200,Constants.SUCCESS_STATUS,Helper.getLocaleMessage("retrieved.success",messageSource),manufacturer,1L),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/{id}")
    public ResponseEntity<ResponseUtil> editManufacturer(@RequestBody ManufacturerRequestModel manufacturerRequestModel,@PathVariable("id") Long id){
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(id);
        manufacturer.setName(manufacturer.getName());

        manufacturerService.update(manufacturer,id);
        return new ResponseEntity<ResponseUtil>(new ResponseUtil(200,Constants.SUCCESS_STATUS,Helper.getLocaleMessage("updated.success",messageSource),manufacturer,1L),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value ="/{id}")
    public void delete(@PathVariable("id") Long id){
        //manufacturerService.findOne(id);
        manufacturerService.softDelete(id);
    }


    @Override
    public ManufacturerResponseModel modelizeEntity(Manufacturer entity) {
        return null;
    }

    @Override
    public List<ManufacturerResponseModel> modelizeList(List<Manufacturer> entities) {
        return null;
    }
}


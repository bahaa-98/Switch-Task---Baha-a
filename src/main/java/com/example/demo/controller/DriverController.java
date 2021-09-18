package com.example.demo.controller;

import com.example.demo.domain.Car;
import com.example.demo.domain.Driver;
import com.example.demo.exceptions.CarAlreadyInUseException;
import com.example.demo.model.request.DriverReqLoginModel;
import com.example.demo.model.request.DriverReqSignUpModel;
import com.example.demo.model.response.DriverResSignUpModel;
import com.example.demo.security.JwtUtils;
import com.example.demo.security.UserDetailsImpl;
import com.example.demo.services.ICarService;
import com.example.demo.services.IDriver;
import com.example.demo.utils.Constants;
import com.example.demo.utils.Helper;
import com.example.demo.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private IDriver driverService;

    @Autowired
    private ICarService carService;

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ResponseUtil> signUp(@RequestBody DriverReqSignUpModel driverRequestSignUpModel){

        Driver entity = new Driver();

        entity.setFirstName(driverRequestSignUpModel.getFirstName());
        entity.setLastName(driverRequestSignUpModel.getLastName());
        entity.setEmail(driverRequestSignUpModel.getEmail());
        entity.setPhoneNumber(driverRequestSignUpModel.getPhoneNumber());
        entity.setPassword(driverRequestSignUpModel.getPassword());

        driverService.add(entity);

        DriverResSignUpModel model = new DriverResSignUpModel(entity.getId(),driverRequestSignUpModel.getFirstName(),driverRequestSignUpModel.getLastName(),driverRequestSignUpModel.getEmail(),driverRequestSignUpModel.getPhoneNumber(),driverRequestSignUpModel.getPassword());

        return new ResponseEntity<ResponseUtil>(new ResponseUtil(201, Constants.SUCCESS_STATUS, Helper.getLocaleMessage("created.success",messageSource),model,1L), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public ResponseEntity<ResponseUtil> login(@RequestBody DriverReqLoginModel model){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(model.getEmail(),model.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtUtils.generateToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return new ResponseEntity<ResponseUtil>(new ResponseUtil(200,Constants.SUCCESS_STATUS,Helper.getLocaleMessage("login.success",messageSource),token,1L),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ResponseUtil> getAll(){

        List<Driver> drivers = driverService.getAll();

        return new ResponseEntity<ResponseUtil>(new ResponseUtil(200,Constants.SUCCESS_STATUS,Helper.getLocaleMessage("retrieved.success",messageSource),drivers,(long)drivers.size()),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{driverId}")
    public ResponseEntity<ResponseUtil> getById(@PathVariable("driverId")Long driverId){
        Driver driver = driverService.findOne(driverId);

        return new ResponseEntity<ResponseUtil>(new ResponseUtil(200, Constants.SUCCESS_STATUS,Helper.getLocaleMessage("retrieved.success",messageSource),driver,1L),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{driverId}/{carId}")
    public ResponseEntity<ResponseUtil> getByDriverCar(@PathVariable("driverId") Long driverId,@PathVariable("carId") Long carId){

        List<Car> cars = carService.getAll();

        return new ResponseEntity<ResponseUtil>(new ResponseUtil(200,Constants.SUCCESS_STATUS,Helper.getLocaleMessage("retrieved.success",messageSource),cars,(long)cars.size()),HttpStatus.OK);
    }

    /*@RequestMapping(method = RequestMethod.POST, value = "/{carId}/{driverId}")
    public ResponseEntity<ResponseUtil> selectCar(@PathVariable("carId") Long carId, @PathVariable("driverId") Long driverId){
        Car car = carService.findOne(carId);

        try {
            car.setDriver(driverService.findOne(driverId));
        }catch (CarAlreadyInUseException ex){
            throw new CarAlreadyInUseException("Car Already In Use");
        }

        return new ResponseEntity<ResponseUtil>(new ResponseUtil(200,Constants.SUCCESS_STATUS,Helper.getLocaleMessage("retrieved.success",messageSource),car,1L),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{carId}")
    public ResponseEntity<ResponseUtil> deSelectCar(@PathVariable("carId") Long carId){
        Car car = carService.findOne(carId);

        car.setDriver(null);

        return new ResponseEntity<ResponseUtil>(new ResponseUtil(200,Constants.SUCCESS_STATUS,Helper.getLocaleMessage("retrieved.success",messageSource),car,1L),HttpStatus.OK);
    }*/

}

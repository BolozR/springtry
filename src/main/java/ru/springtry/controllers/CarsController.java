package ru.springtry.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.springtry.models.Car;
import ru.springtry.repositories.CarsRepository;

import java.util.List;

@Controller
public class CarsController {
    @Autowired
    private CarsRepository carsRepository;

    @RequestMapping(path = "/cars", method = RequestMethod.GET)
    @ResponseBody
    public String getCarsByOwnerFirstName(@RequestParam(name = "first_name") String firstName){
        List<Car> cars = carsRepository.findAllByOwner_FirstName(firstName);
        return cars.toString();
    }

    @RequestMapping(path = "/models", method = RequestMethod.GET)
    @ResponseBody
    public String getCarsByModel(@RequestParam(name = "model") String model){
        List<Car> cars = carsRepository.findAllByModel(model);
        return cars.toString();
    }
}

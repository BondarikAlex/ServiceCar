package org.cars.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.cars.model.Car;
import org.cars.service.CarService;
import org.cars.service.ServiceCar;
import org.cars.service.WriteReadJackson;
import org.cars.util.JDBCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Реализовать CRUD операции для создания автомобилей в БД постгрес
 */
@Slf4j
@RestController
@Tag(name = "Staff API")
public class CarsController {

    // CRUD


    @Autowired
    private ServiceCar serviceCar;
    @Autowired
    private JDBCService jdbcService;
    @Autowired
    private CarService carService;
    @Autowired
    private WriteReadJackson writeReadJackson;
    ArrayList<Car> list;
    Car car;


    @GetMapping("/cars")
    private ArrayList<Car> getCars() {
        try {// вернуть список всех машин которые лежат в бд
            list = carService.getAllCars();
            log.debug("Получаем список всех авто {} ", list.toString());
            log.info("Получаем список всех авто {} ", list.toString());
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/cars")
    public Car createCar(@RequestBody Car car) {
        carService.create(car);
        log.info("Create Car = {}", car);
        // логика создания машины в БД и возвращение ее в ответе
        return car;
    }

    @PutMapping("/cars/{id}")  // логика обнволения машины по id в БД и возвращение ее в ответе
    public Car updateCar(@RequestBody Car car, @PathVariable Long id) {
        carService.update(car, id);
        log.info("Update Car for Id =" + id + " {}", car);
        return car;

    }

    @GetMapping("/cars/{id}")  // вернуть машину по id
    @ApiResponse(responseCode = "400",description = "Bad request")
    @Operation(summary = "Return an Car",description ="Return an Car by DB!" )
    public Car getCarById(@PathVariable Long id) throws SQLException, NullPointerException {
        log.debug("Error - {}",id);
        car = carService.getCarById(id);
        log.debug("Error methods - {}",car);
         log.info("Get Car for Id ="+id+" {}");
        return car;
    }


    @DeleteMapping("/cars/{id}")
    public void deleteCarById(@PathVariable Long id) {
        // удалить машину по id
        jdbcService.jdbcQuery("delete from cars where id=" + id + "");
        log.info("Удален Car = " + id);
    }
}


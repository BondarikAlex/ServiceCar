package org.cars.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.cars.model.Car;
import org.cars.service.CarService;
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
    private CarService carService;


    @GetMapping("/cars")// вернуть список всех машин которые лежат в бд
    @ApiResponse(responseCode = "200", description = "Good request")
    @Operation(summary = "GetAllCar to list", description = "GetAllCar to list an DB!")
    public ArrayList<Car> getCars(@RequestParam("sortBy") String sortBy,
                                  @RequestParam("sortDirection") String sortDirection,
                                  @RequestParam("filter") String filter) throws SQLException {
        log.info("Run method GetMapping");
        return carService.getAllCars(sortBy, sortDirection, filter);
    }


    @PostMapping("/cars") // логика создания машины в БД и возвращение ее в ответе
    @ApiResponse(responseCode = "200", description = "Good request")
    @ApiResponse(responseCode = "400", description = "Bad request : Error in value")
    @Operation(summary = "Create an Car", description = "Create Car in DB!")
    public Car createCar(@RequestBody Car car) throws SQLException {
        log.info("Run method PostMapping");
        log.info("Create Car = {}", car);
        return carService.create(car);
    }

    @PutMapping("/cars/{id}")// логика обнволения машины по id в БД и возвращение ее в ответе
    @ApiResponse(responseCode = "200", description = "Good request")
    @ApiResponse(responseCode = "400", description = "Bad request : Error in value")
    @Operation(summary = "UPDATE an Car", description = "Update Car in DB!")
    public Car updateCar(@RequestBody Car car, @PathVariable Long id) throws SQLException {
        log.info("Run method PutMapping");
        log.info("Update Car for Id =" + id + " {}", car);
        return carService.update(car, id);

    }

    @GetMapping("/cars/{id}")  // вернуть машину по id
    @ApiResponse(responseCode = "400", description = "Bad request : Error in value")
    @ApiResponse(responseCode = "200", description = "Good request !")
    @Operation(summary = "Return Car", description = "Return Car by DB!")
    public Car getCarById(@PathVariable Long id) throws SQLException, NullPointerException {
        log.info("Run method GetMapping");
        return carService.getCarById(id);
    }


    @DeleteMapping("/cars/{id}")  // удалить машину по id
    @ApiResponse(responseCode = "400", description = "Bad request: Not found ID")
    @ApiResponse(responseCode = "200", description = "Good request !")
    @Operation(summary = "Delete Car", description = "Delete Car by DB!")
    public void deleteCarById(@PathVariable Long id) throws SQLException {
        log.info("Run method DeleteMapping");
        carService.delete(id);

    }
}


package org.cars.controller;

import lombok.extern.slf4j.Slf4j;
import org.cars.model.Car;
import org.cars.service.ServiceCar;
import org.cars.service.WriteReadJackson;
import org.cars.util.JDBCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * Реализовать CRUD операции для создания автомобилей в БД постгрес
 */
@Slf4j
@RestController
public class CarsController {

    // CRUD


    @Autowired
    private ServiceCar serviceCar;
    @Autowired
   private JDBCService jdbcService;

    @Autowired
    private WriteReadJackson writeReadJackson;


    @GetMapping("/cars")
    public String getCars() {
            try {// вернуть список всех машин которые лежат в бд

                log.info( jdbcService.jdbcQuery("select * from cars"));
                return  jdbcService.getCarList().toString();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }
    @PostMapping("/cars")
    public String createCar(@RequestBody Car car) {
        jdbcService.jdbcQuery("insert into cars( brand, model, year, price) Values ('"+car.getBrand()+"','"+car.getModel()+"',"+car.getYear()+","+car.getPrice()+")");
        log.info("Create Car = {}",car);
        // логика создания машины в БД и возвращение ее в ответе
        return car.toString();
    }

    @PutMapping("/cars/{id}")  // логика обнволения машины по id в БД и возвращение ее в ответе
    public String updateCar(@RequestBody Car car, @PathVariable Long id) {
        jdbcService.jdbcQuery("UPDATE cars set  brand='"+car.getBrand()+"',model='"+car.getModel()+"', id="+id+" where id="+id+"");
        log.info("Update Car for Id ="+id+" {}",car);
            return  car.toString();

    }

    @GetMapping("/cars/{id}")  // вернуть машину по id
    public String getCarById(@PathVariable Long id) {
        log.info("Get Car for Id ="+id+" {}");
       return jdbcService.jdbcQuery("select * from cars where id="+id+"");
    }

    @DeleteMapping("/cars/{id}")
    public void deleteCarById(@PathVariable Long id) {
        // удалить машину по id
         jdbcService.jdbcQuery("delete from cars where id="+id+"");
    }
}


package org.cars.service;

import lombok.Getter;
import org.cars.model.Car;
import org.cars.model.Collection;
import org.cars.util.JDBCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

@Service
@Getter
public class CarService {
    @Autowired
    JDBCService jdbcService;
    @Autowired
    Collection list;



    public Car create(Car car) {
        jdbcService.jdbcQuery("insert into cars( brand, model, year, price,id) Values ('" + car.getBrand() + "','" + car.getModel() + "'," + car.getYear() + "," + car.getPrice() + ","+car.getId()+")");
        return car;
    }

    public Car update(Car car,long id) {
        jdbcService.jdbcQuery("UPDATE cars set  brand='" + car.getBrand() + "',model='" + car.getModel() + "', id=" + id + " where id=" + id + "");
        return car;
    }
    public Car getCarById(long id) throws SQLException,NullPointerException  {
        Car car;
        jdbcService.jdbcQuery("SELECT * FROM cars WHERE id ="+id+";");
        car=jdbcService.getCar(id);
        return car;
    }






    public ArrayList<Car> getAllCars() throws SQLException {
        jdbcService.jdbcQuery("select * from cars");
        return jdbcService.getCarList();


}

}
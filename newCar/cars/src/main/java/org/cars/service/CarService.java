package org.cars.service;

import lombok.Getter;
import org.cars.model.Car;
import org.cars.util.JDBCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Service
@Getter
public class CarService {
    @Autowired
    JDBCService jdbcService;


    public Car create(Car car) throws SQLException {
        return createCar(jdbcService.jdbcQuery("insert into cars( brand, model, year, price,id) Values ('" + car.getBrand() + "','" + car.getModel() + "'," + car.getYear() + "," + car.getPrice() + "," + car.getId() + ")"));
    }

    public Car createCar(ResultSet resultSet) throws SQLException {
        Car car = new Car();
        while (resultSet.next()) {
            car.setId(resultSet.getLong("id"));
            car.setBrand(resultSet.getString("brand"));
            car.setModel(resultSet.getString("model"));
            car.setYear(resultSet.getInt("year"));
            car.setPrice(resultSet.getDouble("price"));
        }
        return car;
    }
    //SELECT * FROM entities WHERE value = __VALUE__ ORDER BY date ASC NULLS LAST
    public ArrayList<Car> getAllCars(String sortBy,String sortDirection,String filter) throws SQLException {
        return jdbcService.getCarList(jdbcService.jdbcQuery("SELECT * FROM cars WHERE "+filter+" ORDER BY "+sortBy+" "+sortDirection+" "));
    }

    public Car update(Car car, long id) throws SQLException {
        return updateCar(id, jdbcService.jdbcQuery("UPDATE cars set  brand='" + car.getBrand() + "',model='" + car.getModel() + "',year=" + car.getYear() + ",price= " + car.getPrice() + " where id=" + id + " "));
    }

    public Car updateCar(long id, ResultSet resultSet) throws SQLException {
        Car car = new Car();
        while (resultSet.next()) {
            car.setBrand(resultSet.getString("brand"));
            car.setModel(resultSet.getString("model"));
            car.setYear(resultSet.getInt("year"));
            car.setPrice(resultSet.getDouble("price"));
            car.setId(id);
        }
        return car;
    }

    public Car getCarById(long id) throws SQLException, NullPointerException {
        return getCar(id, jdbcService.jdbcQuery("SELECT * FROM cars WHERE id =" + id + ";"));
    }

    public Car getCar(long id, ResultSet resultSet) throws SQLException, NullPointerException {
        Car car = new Car();
        while (resultSet.next()) {
            car.setBrand(resultSet.getString("brand"));
            car.setModel(resultSet.getString("model"));
            car.setYear(resultSet.getInt("year"));
            car.setPrice(resultSet.getInt("price"));
            car.setId(resultSet.getInt("id"));
        }
        return car;
    }


    public void delete(long id) throws SQLException {
        jdbcService.jdbcQuery("delete from cars where id=" + id + " ");
    }

}
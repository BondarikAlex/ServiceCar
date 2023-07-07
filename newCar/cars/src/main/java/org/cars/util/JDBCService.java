package org.cars.util;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.cars.model.Car;
import org.cars.service.PostgresService;
import org.postgresql.ds.PGPoolingDataSource;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Service
public class JDBCService {
    private PGPoolingDataSource ds;
    private Connection connection;
    private PostgresService postgresService;

    private Statement statement;
    private ResultSet resultSet;


    /**
     * Метод : авто коннект
     */
    @PostConstruct
    public void init() {
        ds = new PGPoolingDataSource();
        ds.setServerName("localhost");
        ds.setDatabaseName("postgres");
        ds.setUser("postgres");
        ds.setPassword("password");
        ds.setMaxConnections(100);
        ds.setInitialConnections(20);
        setConnection();
    }

    public void setConnection() {
        try {
            connection = ds.getConnection();
            statement = connection.createStatement();
            System.out.println("Database connected\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

public Car getCar(){
    try {
        Car car;

        return

        car= (Car) resultSet.getObject(String.valueOf(Car.class));
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
    public ArrayList<Car> getCarList() throws SQLException ,NullPointerException{
        ArrayList<Car> list = new ArrayList<>();
        while (resultSet.next()) {
            Car car = new Car();
            car.setId(resultSet.getLong("id"));
            car.setBrand(resultSet.getString("brand"));
            car.setModel(resultSet.getString("model"));
            car.setYear(resultSet.getInt("year"));
            car.setPrice(resultSet.getInt("price"));
            list.add(car);
        }
        return list;
    }

    public String jdbcQuery(String query) {
        try {
            resultSet = statement.executeQuery(query);
            System.out.println("Запрос : " + query);
            System.out.println("Запрос выполнен!");
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("Запрос не выполнен либо нет результата отправки запроса!");
        }
        return query;
    }

    @PreDestroy
    public void conClose() {
        try {
            if (!ds.getConnection().isClosed()) {
                ds.getConnection().close();
                System.out.println("Подключение приостановлено!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


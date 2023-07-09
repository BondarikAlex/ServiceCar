package org.cars.util;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Getter;
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
@Getter
public class JDBCService {

    PGPoolingDataSource ds;
    Connection connection;
    PostgresService postgresService;
    Statement statement;
   private ResultSet resultSet;


    /**
     * Метод : авто коннект
     */
    @PostConstruct
    void init() {
        ds = new PGPoolingDataSource();
        ds.setServerName("localhost");
        ds.setDatabaseName("postgres");
        ds.setUser("postgres");
        ds.setPassword("password");
        ds.setMaxConnections(100);
        ds.setInitialConnections(20);
        try {
            connection = ds.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        try {
            statement = connection.createStatement();
            System.out.println("Database connected\n");
            ;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }




    public ArrayList<Car> getCarList() throws SQLException, NullPointerException {
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



    public Car getCar(long id) throws SQLException,NullPointerException {
        Car car=new Car();
        while (resultSet.next()){
        System.out.println(resultSet.getString("brand"));
        car.setBrand(resultSet.getString("brand"));
        car.setModel(resultSet.getString("model"));
        car.setYear(resultSet.getInt("year"));
        car.setPrice(resultSet.getInt("price"));
        car.setId(resultSet.getInt("id"));}
        return car;
        }





    public String jdbcQuery(String query) {
        try {System.out.println("jdbcQuery method     :  query - " + query);
            resultSet = statement.executeQuery(query);
           // System.out.println(resultSet.getString("brand"));
            System.out.println("Запрос выполнен!");
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("Запрос не выполнен либо нет результата отправки запроса!");
        }
        return query;
    }


    public void setStatement(String query) {
        try {
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readDB(String query) {
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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


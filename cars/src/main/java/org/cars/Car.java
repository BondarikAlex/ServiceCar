package org.cars;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private String brand;
    private String model;
    private int year;
    private double price;
    private long id;
    @PostConstruct
    public void run(){
        System.out.println("Создал Bean!");
    }


}

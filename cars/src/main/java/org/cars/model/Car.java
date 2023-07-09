package org.cars.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private String brand;
    private String model;
    private int year;
    private double price;
    private long id;

    private Car() {
    }

    public Car(String brand, String model, int year, double price, long id) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}

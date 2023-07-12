package org.cars.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@Schema

public class Car {

    @Schema(description = "Brand of the Car.", type = "String", name = "brand", example = "BMW")
    private String brand;
    @Schema(description = "Model of the Car.", example = "E34")
    private String model;
    @Schema(description = "Year of the Car.", example = "1990")
    private int year;
    @Schema(description = "Brand of the Car.", example = "2500")
    private double price;
    @Schema(description = "ID of the Car.", example = "7")
    private long id;

    public Car() {

    }

    public Car(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public Car(String brand, String model, int year, double price, long id) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.id = id;
    }


    public String getBrand() {
        return brand;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

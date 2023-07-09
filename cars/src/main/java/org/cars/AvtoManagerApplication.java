package org.cars;

import org.cars.model.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AvtoManagerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context;
        context = SpringApplication.run(AvtoManagerApplication.class, args);
        Car component = context.getBean(Car.class);
        System.out.println(component);
    }

}

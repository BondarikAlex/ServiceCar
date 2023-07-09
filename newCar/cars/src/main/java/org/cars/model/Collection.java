package org.cars.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
@Scope("prototype")
public class Collection {

    ArrayList<Car> list=new ArrayList<>();


    @Override
    public String toString() {
        for (int i = 0; i < list.size(); i++) {
            return list.get(i).toString();
        }
        return "Working List.toString!";
    }

    public void add(Car car) {
        list.add(car);
    }
}

package org.cars.service;
import java.util.Scanner;

import jakarta.annotation.PreDestroy;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
public class ServiceScanner {


    private final Scanner scanner;
    public  ServiceScanner(){
        scanner = new Scanner(System.in);
    }
    @PreDestroy
    public void closeScanner(){
        scanner.close();
        System.out.println("Scanner closed");
    }
}

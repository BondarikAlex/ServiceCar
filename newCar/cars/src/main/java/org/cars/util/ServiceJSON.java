package org.cars.util;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.io.File;
@Service
@Getter
public class ServiceJSON {

    private  File fileJSON;
    public void ServiceJson(){
        fileJSON =new File("Cars.json");
    }




}

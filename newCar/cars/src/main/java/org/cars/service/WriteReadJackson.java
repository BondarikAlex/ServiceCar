package org.cars.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.cars.model.Car;
import org.cars.util.ServiceJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
@Service

public class WriteReadJackson implements InterfaceWriteRead {
    @Autowired
    ServiceJSON fileJSON;
    @Override//запись в джейсон
    public ArrayList<Car> write(ArrayList<Car> list) {
        ObjectMapper objectMapper = new ObjectMapper();
        list.stream().forEach(i -> {
            try {
                objectMapper.writeValue(fileJSON.getFileJSON(), list);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return list;
    }
    @Override
    //чтение из джейсон
    public ArrayList<Car> read() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(fileJSON.getFileJSON(), new TypeReference<>() {

        });
    }


public  void deleteFile(){
    if(fileJSON.getFileJSON().exists()){if(fileJSON.getFileJSON().delete()){
        System.out.println("Файл удален");}
    }else
        System.out.println("По неизвестной причине файл не удалился! Возможно его там нет!");}

public static void writeJson(ArrayList<Car> list){
     new WriteReadJackson().write(list);
}
public static ArrayList<Car> readJson() throws IOException {
   return new WriteReadJackson().read();

}
}




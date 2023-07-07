package org.cars.util;

import org.cars.model.ListCars;
import org.cars.service.ServiceCar;
import org.cars.service.ServiceScanner;
import org.cars.service.WriteReadJackson;
import org.cars.service.WriteReadTxt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;


@Service
public class AvtoManager {

@Autowired
    private WriteReadJackson writeReadJackson;
@Autowired
    private ServiceScanner scanner;
@Autowired
    private ServiceCar serviceCar;

    static int num;
    static boolean button = true;
    static boolean menu = true;



    private void destroyMethod() {
        System.out.println("Завершение жизненного цикла Beans!");
    }

//@PostConstruct
    public  void avtoManager() throws InputMismatchException, SQLException {
        while (menu) {
            mainMenu();
            try {
                num = scanner.getScanner().nextInt();
            } catch (InputMismatchException mismatchException) {
                System.out.println("Вводите возможные значения из меню!");
                System.exit(0);
            } catch (IllegalStateException exception) {
                System.out.println(exception.getMessage());
                new Scanner(System.in);
            }
            switch (num) {
                case 1 -> menuJSON();
                case 2 -> menuTXT();
                case 3 -> menuPostgrase();
            }
        }
    }

    public void mainMenu() {
        System.out.println("*************************************************");
        System.out.println("Прога для просмотра функционала нашего проекта!" +
                "Меню:\n" +
                "1 - Json.\n" +
                "2 - Txt.\n" +
                "3 - Postgres.\n" +
                "Ваш выбор!");
    }


    ////////////////////////////////////////////////////
    public void menuJSON() {

        System.out.println("***** Меню JSON *****\n" +
                "1 - Generated Objects Cars & Write Json File(convert in Json)\n" +
                "2 - Read Json File(return in Object Cars)\n" +
                "3 - Remove Json File!");
        // scanner.nextLine();
        num = scanner.getScanner().nextInt();
        if (num < 1 | num > 3) {
            System.out.println("Невозможный выбор! Ошибка!");
        } else {
            switch (num) {
                case 1 -> {
                    System.out.println("Генерация листа Cars" + ListCars.getListCars());
                    System.out.println("Произошла запись, в файл Json");
                    WriteReadJackson.writeJson(ListCars.getList());
                }
                case 2 -> {
                    try {
                        System.out.println("Читаю Json и возвращаю лист Car");
                        WriteReadJackson.readJson();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 3 -> {
                    writeReadJackson.deleteFile();
                }
            }
        }
    }

    ////////////////////////////////////////////////////////
    public void menuTXT() throws SQLException {
        System.out.println("***** Меню TXT *****\n" +
                "1 - Write Txt File!\n" +
                "2 - Read Txt File!\n" +
                "3 - Remove Txt File!\n");
        num = scanner.getScanner().nextInt();
        if (num < 1 | num > 3) {
            avtoManager();
            System.out.println("Невозможный выбор! Ошибка!");
        } else {
            switch (num) {
                case 1 -> {
                    WriteReadTxt.writeTXT();
                }
                case 2 -> {
                    try {
                        WriteReadTxt.readTXT();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 3 -> {
                    WriteReadTxt.deleteFile();
                }

            }
        }
    }

    ///////////////////////////////////////////////////////2
    public void menuPostgrase() throws SQLException {
        System.out.println("***** Меню POSTGRES *****\n" +
                "0 - Проверить подтянут ли образ\n" +
                "1 - Подтянуть образ в контейнер\n" +
                "2 - Вытолкнуть  образ из контейнера\n" +
                "3 - Запустить запрос по созданию (либо замене) БД с добавлением таблицы а также ее заполнением! \n" +
                "4 - Запустить запросы по получению разных обьектов таблицы, с информацией о каждом запросе и его результе!\n" +
                "5 - Запустить запрос по фильтрации БД, с информацией о каждом запросе и его результе!\n" +
                "6 - Запустить запрос по сортировки БД, с информацией о каждом запросе и его результе! ");
        num = scanner.getScanner().nextInt();
        switch (num) {
            case 0 -> {
                try {
                    ProcessDocker.dockerPS();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            case 1 -> {
                try {
                    ProcessDocker.dockerCompose_f();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            case 2 -> {
                try {
                    ProcessDocker.dockerDown();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            case 3 -> {


            }
            case 4 -> {
                JDBCService jdbcService = new JDBCService();



            }
        }

    }

}
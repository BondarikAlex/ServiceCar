package Employee_accounting_system.Function_Manager;

import Employee_accounting_system.Data_Emploees.Emploee;
import Employee_accounting_system.Data_Emploees.Id;
import Employee_accounting_system.Data_Emploees.Register_of_employees;
import Employee_accounting_system.Read_Write_File.Read;
import Employee_accounting_system.Read_Write_File.Write;

import java.util.Map;
import java.util.Scanner;

/**
 *  class ResizeEmploee представляет собой функционал редактирования полей сотркдника в существующей записи!
 *  changeEmploee()- метод расширенного диапазона действий редактирования полей Сотрудника:
 *  Поля для изменения:ФИО,Дата рождения,Пол,Контактный телефон,Должность,Название отдела,ФИО начальника отдела,Зарплата!
 */
public class ResizeEmploee {
    static Scanner scanner = new Scanner(System.in);

    private static void changeEmploee() {
        Read.getReadFile();
        System.out.println("Введите Фамилию сотрудника, запись которого хотите отредактировать!!");
        String name = scanner.nextLine();
        boolean lock = false;
        for (Map.Entry<Id, Emploee> list : Register_of_employees.listEmploees.entrySet()) {
            if (list.getValue().getFIO().equals(name)) {
                lock = true;
                System.out.println(list.getKey().getCount() + "  " + list.getValue().toString());
            }
        }
        if (lock) {
            System.out.println("Введите ID сотрудника, запись которого хотите отредактировать!");
            Integer id = scanner.nextInt();
            for (Map.Entry<Id, Emploee> list : Register_of_employees.listEmploees.entrySet()) {
                if (list.getKey().getCount().equals(id)) {
                    System.out.println("""
                            ВВедите на ваш выбор то поле которое хотите отредактировать?
                             1 - ФИО!
                             2 - Дата рождения!
                             3 - Пол!
                             4 - Контактный телефон!
                             5 - Должность!
                             6 - Название отдела!
                             7 - ФИО начальника отдела!
                             8 - Зарплата!
                             """);
                    Integer number = scanner.nextInt();
                    scanner.nextLine();// уберет из буфера перенос строки
                    switch (number) {
                        case 1 -> {
                            System.out.println("Введите новое ФИО!");
                            String temp = scanner.nextLine();
                            list.getValue().setFIO(temp);
                        }
                        case 2 -> {
                            System.out.println("Введите новую Дату рождения!");
                            String temp = scanner.nextLine();
                            list.getValue().setDate_of_birth(temp);
                        }
                        case 3 -> {
                            System.out.println("Введите новый пол!");
                            String temp = scanner.nextLine();
                            list.getValue().setSex(temp);
                        }
                        case 4 -> {
                            System.out.println("Введите новый контактный телефон!");
                            String temp = scanner.nextLine();
                            list.getValue().setContact_phone_number(temp);
                        }
                        case 5 -> {
                            System.out.println("Введите новую Должность!");
                            String temp = scanner.nextLine();
                            list.getValue().setPost(temp);
                        }
                        case 6 -> {
                            System.out.println("Введите новое название отдела!");
                            String temp = scanner.nextLine();
                            list.getValue().setDepartment(temp);
                        }
                        case 7 -> {
                            System.out.println("Введите новую ФИО начальника отдела!");
                            String temp = scanner.nextLine();
                            list.getValue().setInformation_about_the_boss(temp);
                        }
                        case 8 -> {
                            System.out.println("Введите новую Зарплату");
                            int sal = scanner.nextInt();
                            list.getValue().setSalary(sal);
                        }
                    }
                }
            }
            Write.getWriteFile();
        }else {
            System.out.println("Совподений не найдено!");
        }
    }
    public static void getchangeE(){
        changeEmploee();
    }
}

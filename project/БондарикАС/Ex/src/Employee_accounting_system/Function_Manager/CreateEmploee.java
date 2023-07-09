package Employee_accounting_system.Function_Manager;

import Employee_accounting_system.Data_Emploees.*;
import Employee_accounting_system.Read_Write_File.Read;
import Employee_accounting_system.Read_Write_File.Write;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

import java.util.Scanner;
  /** Класс менеджер представляет собой функционал отдела кадров!
   В нем присутствуют методы:

   createEmploee() - метод который принимает в себя данные о будущем сотруднике, и записывает их в реестр сотрудников!
   Реестр сотрудников - HashMap<Id,Emploee> listEmploees, предназначен для временного хранения . Файл - место хранения
   самого listEmploees, предназначен для физического хранения!...
*/


public class CreateEmploee {
    static Scanner scanner = new Scanner(System.in);

    private static void createEmploee() {
        Read.getReadFile();
        Emploee e = new Emploee();

        for (int i = 0; i < 10; i++) {
            switch (i) {
                case 0 -> {
                    System.out.println("Enter name!");
                    e.setFIO(scanner.nextLine());
                }
                case 1 -> {
                    System.out.println("Enter дату рождения!");
                    e.setDate_of_birth(scanner.nextLine());
                }
                case 2 -> {
                    System.out.println("Выберете свой пол(муж или жен)!");
                    e.setSex(scanner.nextLine());
                }
                case 3 -> {
                    System.out.println("Enter номер телефона!");
                    e.setContact_phone_number(scanner.nextLine());
                }
                case 4 -> {
                    System.out.println("""
                            ВВедите вашу должность?
                            Выберете из списка вакансий?
                             1 - Художник!
                             2 - Скульптор!
                             3 - Бухгалтер!
                             4 - Экономист!
                             5 - Электрик!
                             6 - Монтажник!
                             """);
                    int postName = scanner.nextInt();
                    switch (postName) {
                        case 1 -> {
                            e.setSalary(PostSelected.ХУДОЖНИК.getSalary());
                            e.setPost(PostSelected.ХУДОЖНИК.getPostName());
                            e.setDepartment(PostSelected.ХУДОЖНИК.getDepartment());
                            e.setInformation_about_the_boss(PostSelected.ХУДОЖНИК.getInformation_about_the_boss());
                        }
                        case 2 -> {
                            e.setSalary(PostSelected.СКУЛЬПТОР.getSalary());
                            e.setPost(PostSelected.СКУЛЬПТОР.getPostName());
                            e.setDepartment(PostSelected.СКУЛЬПТОР.getDepartment());
                            e.setInformation_about_the_boss(PostSelected.СКУЛЬПТОР.getInformation_about_the_boss());
                        }
                        case 3 -> {
                            e.setSalary(PostSelected.БУХГАЛТЕР.getSalary());
                            e.setPost(PostSelected.БУХГАЛТЕР.getPostName());
                            e.setDepartment(PostSelected.БУХГАЛТЕР.getDepartment());
                            e.setInformation_about_the_boss(PostSelected.БУХГАЛТЕР.getInformation_about_the_boss());
                        }
                        case 4 -> {
                            e.setSalary(PostSelected.ЭКОНОМИСТ.getSalary());
                            e.setDepartment(PostSelected.ЭКОНОМИСТ.getDepartment());
                            e.setPost(PostSelected.ЭКОНОМИСТ.getPostName());
                            e.setInformation_about_the_boss(PostSelected.ЭКОНОМИСТ.getInformation_about_the_boss());
                        }

                        case 5 -> {
                            e.setSalary(PostSelected.ЭЛЕКТРИК.getSalary());
                            e.setPost(PostSelected.ЭЛЕКТРИК.getPostName());
                            e.setDepartment(PostSelected.ЭЛЕКТРИК.getDepartment());
                            e.setInformation_about_the_boss(PostSelected.ЭЛЕКТРИК.getInformation_about_the_boss());
                        }
                        case 6 -> {
                            e.setSalary(PostSelected.МОНТАЖНИК.getSalary());
                            e.setDepartment(PostSelected.МОНТАЖНИК.getDepartment());
                            e.setPost(PostSelected.МОНТАЖНИК.getPostName());
                            e.setInformation_about_the_boss(PostSelected.МОНТАЖНИК.getInformation_about_the_boss());
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Регистрация сотрудника завершена!");

                    e.setDate_of_employment(LocalDate.from(LocalDate.now().atTime(LocalTime.now())));
                }
            }
        }

        Register_of_employees.listEmploees.put(new Id(), e);

        for (HashMap.Entry<Id, Emploee> set : Register_of_employees.listEmploees.entrySet()) {
            System.out.println(set.getKey().getCount() + " - " + set.getValue());
        }
        Write.getWriteFile();
    }

public static void getCreateEmploee(){
        createEmploee();
}

}




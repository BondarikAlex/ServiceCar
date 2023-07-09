package Employee_accounting_system.Reports;

import Employee_accounting_system.Data_Emploees.Emploee;
import Employee_accounting_system.Data_Emploees.Id;
import Employee_accounting_system.Data_Emploees.Register_of_employees;
import Employee_accounting_system.Read_Write_File.Read;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;
import java.util.Scanner;

/**
 * class AverageSalary представляет собой хранилище 2 методов представляющую результат средней зарплаты!
 * 1 метод averageSalaryOrganization(int key) - выводит среднюю зарплату по организации!
 * Ключ==0 - вывод в терминал, ключ==1 - вывод в файл Report Of Average Salary Organization.txt!
 * 2 метод averageSalaryOfDepartments(int key) - выводит среднюю зарплату по выбранному отделу
 *  Ключ==0 - вывод в терминал, ключ==1 - вывод в файл Report Of Average Salary Of Departments.txt!
 */
public class AverageSalary {//Средняя зарплата
    static Scanner sc = new Scanner(System.in);
    static Integer summa = 0;
    static Integer count = 0;
    static int tempSalary;
    static int tempSalary1;
    static File file = new File("Report Of Average Salary Organization.txt");
    static File file1 = new File("Report Of Average Salary Of Departments.txt");

    private static void averageSalaryOrganization(int key) {
        Read.getReadFile();
            for (Map.Entry<Id, Emploee> list : Register_of_employees.listEmploees.entrySet()) {
                summa = list.getValue().getSalary() + summa;
                count = count + 1;
            }
            tempSalary = summa / count;
        if (key == 0) {
            System.out.println("Cредняя зарплата по организации - " + tempSalary);
            summa = 0;
            count = 0;
        } else if (key == 1) {
            try {
                if (file.exists()) {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                    bw.write(String.valueOf(LocalDate.now().atTime(LocalTime.now())) + " - Дата создания отчета");
                    bw.newLine();
                    bw.write("Отчет по средней зарплате во всей организации!");
                    bw.newLine();
                    bw.write("Cредняя зарплата по организации - " + tempSalary);
                    bw.close();
                    System.out.println("Отчет создан и записан в файл Report Of Average Salary Organization.txt ");
                } else {
                    file.createNewFile();
                    averageSalaryOrganization(1);
                }
            } catch (ClassCastException exception) {
                exception.getMessage();
            } catch (NullPointerException exception) {
                exception.getMessage();
            } catch (
                    IOException e) {
                e.printStackTrace();
            }

        }

    }

    private static void averageSalaryOfDepartments(int key) {
        Read.getReadFile();
        System.out.println("""
                     Выберете по какому отделу, вывести отчет средней зарплаты!
                      1 - Отдел Культуры!
                      2 - Отдел Образования!
                      3 - Отдел Электроснабжения!
                """);
        int num = sc.nextInt();
        String nameDepartment = "";

        switch (num) {
            case 1 -> {
                nameDepartment = "Отдел Культуры";
            }
            case 2 -> {
                nameDepartment = "Отдел Образования";
            }
            case 3 -> {
                nameDepartment = "Отдел Электроснабжения";
            }
        }
        sc.nextLine();

        for (Map.Entry<Id, Emploee> list : Register_of_employees.getListEmploees().entrySet()) {
            if (list.getValue().getDepartment().equals(nameDepartment)) {
                summa = summa + list.getValue().getSalary();
                count = count + 1;
            }
        }
        tempSalary1 = summa / count;
        if (key == 0) {
            System.out.println("Cредняя зарплата по отделу - " + nameDepartment + " = " + tempSalary1);
            summa = 0;
            count = 0;
        } else if (key == 1) {
            try {
                if (file1.exists()) {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file1));
                    bw.write(String.valueOf(LocalDate.now().atTime(LocalTime.now())) + " - Дата создания отчета");
                    bw.newLine();
                    bw.write("Отчет по средней зарплате по отделу!");
                    bw.newLine();
                    bw.write("Cредняя зарплата по отделу - " + nameDepartment + " = " + tempSalary1);
                    bw.close();
                    System.out.println("Отчет создан и записан в файл Report Of Average Salary Of Departments.txt ");

                } else {
                    file1.createNewFile();
                    averageSalaryOfDepartments(1);
                }
            } catch (ClassCastException exception) {
                exception.getMessage();
            } catch (NullPointerException exception) {
                exception.getMessage();
            } catch (
                    IOException e) {
                e.printStackTrace();
            }

        } else System.out.println("Введите правильный ключ, читайте документацию класса!");
    }
    public static void getAverageSalaryOfDepartments(int key){
        averageSalaryOfDepartments(key);
    }
    public static void getAverageSalaryOrganization(int key){
        averageSalaryOrganization(key);
    }

}

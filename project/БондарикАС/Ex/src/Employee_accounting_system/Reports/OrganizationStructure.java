package Employee_accounting_system.Reports;

import Employee_accounting_system.Data_Emploees.Department;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * class OrganizationStructure представляет собой хранилище 2 методов!
 * 1 метод - infoByDepartments(int key) выводит информацию по отделам!
 * Ключ==0 - вывод в терминал, ключ==1 - вывод в файл Report Info By Department.txt!
 * 2 метод - FIOBossDepartments(int key) выводит информацию по  ФИО начальников отделов
 * Ключ==0 - вывод в терминал, ключ==1 - вывод в файл Report Info Boss Department.txt!
 */
public class OrganizationStructure {
    static File file = new File("Report Info By Department.txt");
    static File file1 = new File("Report Info Boss Department.txt");

    private static void infoByDepartments(int key) {//информация по отделам
        if (key == 0) {
            System.out.println("Информация по отделам!");
            System.out.println(Department.ОТДЕЛКУЛЬТУРЫ.string());
            System.out.println(Department.ОТДЕЛОБРАЗОВАНИЯ.string());
            System.out.println(Department.ОТДЕЛЭЛЕКТРОСНАБЖЕНИЯ.string());
        } else if (key == 1) {
            try {
                if (file.exists()) {
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(String.valueOf(LocalDate.now().atTime(LocalTime.now())) + " - Дата создания отчета");
                    bw.newLine();
                    bw.write("Отчет предоставляющий Информацию по отделам!");
                    bw.newLine();
                    ArrayList<String> departments = new ArrayList<>();
                    departments.add(Department.ОТДЕЛКУЛЬТУРЫ.string());
                    departments.add(Department.ОТДЕЛОБРАЗОВАНИЯ.string());
                    departments.add(Department.ОТДЕЛЭЛЕКТРОСНАБЖЕНИЯ.string());
                    for (String s : departments) {
                        bw.write(s);
                        bw.newLine();
                    }
                    bw.close();
                    fw.close();
                    System.out.println("Отчет создан и записан в файл Report Info By Department.txt");
                } else {
                    file.createNewFile();
                    infoByDepartments(1);
                }
            } catch (ClassCastException exception) {
                exception.getMessage();
            } catch (NullPointerException exception) {
                exception.getMessage();
            } catch (IOException e) {
                e.printStackTrace();

            }
        } else {
            System.out.println("Введите правильный ключ, читайте документацию класса!");
        }
    }

    private static void FIOBossDepartments(int key) {//информация ФИО начальников отделов
        if (key == 0) {
            System.out.println("Информация ФИО начальников отделов");
            System.out.println(Department.ОТДЕЛКУЛЬТУРЫ.String2());
            System.out.println(Department.ОТДЕЛОБРАЗОВАНИЯ.String2());
            System.out.println(Department.ОТДЕЛЭЛЕКТРОСНАБЖЕНИЯ.String2());
        } else if (key == 1) {
            try {
                if (file.exists()) {
                    FileWriter fw = new FileWriter(file1);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(String.valueOf(LocalDate.now().atTime(LocalTime.now())) + " - Дата создания отчета");
                    bw.newLine();
                    bw.write("Отчет предоставляющий Информацию о Фамилиях Начальников отделов!");
                    bw.newLine();
                    ArrayList<String> departments = new ArrayList<>();
                    departments.add(Department.ОТДЕЛКУЛЬТУРЫ.String2());
                    departments.add(Department.ОТДЕЛОБРАЗОВАНИЯ.String2());
                    departments.add(Department.ОТДЕЛЭЛЕКТРОСНАБЖЕНИЯ.String2());
                    for (String s : departments) {
                        bw.write(s);
                        bw.newLine();
                    }
                    bw.close();
                    fw.close();
                    System.out.println("Отчет создан и записан в файл Report Info Boss Department.txt");
                } else {
                    file.createNewFile();
                    FIOBossDepartments(1);
                }
            } catch (ClassCastException exception) {
                exception.getMessage();
            } catch (NullPointerException exception) {
                exception.getMessage();
            } catch (IOException e) {
                e.printStackTrace();

            }
        } else {
            System.out.println("Введите правильный ключ, читайте документацию класса!");
        }
    }

    public static void getFIOBossDepartments(int key) {
        FIOBossDepartments(key);
    }

    public static void getInfoByDepartments(int key) {
        infoByDepartments(key);
    }
}




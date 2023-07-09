package Employee_accounting_system.Reports;

import Employee_accounting_system.Data_Emploees.Emploee;
import Employee_accounting_system.Data_Emploees.Id;
import Employee_accounting_system.Data_Emploees.Register_of_employees;
import Employee_accounting_system.Read_Write_File.Read;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 * class Top10LoyalEmploee имеет в себе 1 метод Top10LoyalEmp(int key)!
 * Метод Top10LoyalEmp(int key) - выводит 10 самых долгоработающих сотрудников!
 * Ключ==0 - вывод в терминал, ключ==1 - вывод в файл Report Of Loyal Emploee.txt!
 */
public class Top10LoyalEmploee {

    static File file=new File("Report Of Loyal Emploee.txt");

    private static void Top10LoyalEmp(int key) {// Топ 10 самых долгоработающих сотрудников!
        Read.getReadFile();
        try {
            if (key == 0) {
                Register_of_employees.getListEmploees().entrySet().stream().sorted(new CompareEmploeeDateLoyal()).limit(10).forEach(s -> System.out.println(s));
            } else if (key == 1) {
                if (file.exists()) {
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(String.valueOf(LocalDate.now().atTime(LocalTime.now()))+" - Дата создания отчета");
                    bw.newLine();
                    bw.write("Отчет по 10 самых долгоработающих сотрудников!");
                    bw.newLine();
                    List<Map.Entry<Id, Emploee>> toSort = new ArrayList<>();
                    for (Map.Entry<Id, Emploee> s : Register_of_employees.getListEmploees().entrySet()) {
                        toSort.add(s);
                    }
                    toSort.sort(new CompareEmploeeDateLoyal());
                    long limit = 10;
                    for (Map.Entry<Id, Emploee> s : toSort) {
                        System.out.println(s.getKey().getCount()+" "+s.toString());
                        if (limit-- == 0) break;
                        bw.write(String.valueOf(s.getKey().getCount())+" "+ String.valueOf(s));
                        bw.newLine();
                    } bw.close();
                    fw.close();
                    System.out.println("Отчет создан и записан в файл Report Of Loyal Emploee.txt");


                } else {
                    file.createNewFile();
                    Top10LoyalEmp(1);
                }
            }
        } catch (ClassCastException exception) {
            exception.getMessage();
        }catch (NullPointerException exception){
            exception.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void getTop10LoyalEmp(int key){
        Top10LoyalEmp(key);
    }
}


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
import java.util.*;

/**
 * class Top10ExpensiveSalary ����� � ���� 1 ����� Top10ExpensiveSalaryEmploee(int key)!
 * ����� Top10ExpensiveSalaryEmploee(int key) - ������� 10 ����� ������������������ �����������
 * ����==0 - ����� � ��������, ����==1 - ����� � ���� Report Salary Of Emploees.txt!
 */
public class Top10ExpensiveSalary {
    static File file = new File("Report Salary Of Emploees.txt");

    private static void Top10ExpensiveSalaryEmploee(int key) {//��� 10 ����� ������� �����������
        Read.getReadFile();
        try {
            if (key == 0) {
                System.out.println("��� 10 ������������������ �����������!");
                Register_of_employees.getListEmploees().values().stream().sorted(new Comparator<Emploee>() {
                    @Override
                    public int compare(Emploee o1, Emploee o2) {
                        return o2.getSalary()- o1.getSalary();
                    }
                }).limit(10).forEach(s -> System.out.println(s.toString2()));
            } else if (key == 1) {
                if (file.exists()) {
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(String.valueOf(LocalDate.now().atTime(LocalTime.now())) + " - ���� �������� ������");
                    bw.newLine();
                    bw.write("����� �� 10 ����� ����������������� �����������!");
                    bw.newLine();
                    List<Map.Entry<Id, Emploee>> toSort = new ArrayList<>();
                    for (Map.Entry<Id, Emploee> s : Register_of_employees.getListEmploees().entrySet()) {
                        toSort.add(s);
                    }
                    toSort.sort(new CompareEmploeeSalary());
                    long limit = 10;
                    for (Map.Entry<Id, Emploee> s : toSort) {
                        System.out.println(s.getKey().getCount() + " " + s.toString());
                        if (limit-- == 0) break;
                        bw.write(String.valueOf(s.getKey().getCount()) + " " + String.valueOf(s));
                        bw.newLine();
                    }
                    bw.close();
                    fw.close();
                    System.out.println("����� ������ � ������� � ���� Report Salary Of Emploees.txt");
                } else {
                    file.createNewFile();
                     Top10ExpensiveSalaryEmploee(1);
                }
            }else  System.out.println("������� ���������� ����, ������� ������������ ������!");
        } catch (
                ClassCastException exception) {
            exception.getMessage();
        } catch (
                NullPointerException exception) {
            exception.getMessage();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
    public static void getTop10ExpensiveSalaryEmploee(int key){
        Top10ExpensiveSalaryEmploee(key);
    }
}

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
 * class OrganizationStructure ������������ ����� ��������� 2 �������!
 * 1 ����� - infoByDepartments(int key) ������� ���������� �� �������!
 * ����==0 - ����� � ��������, ����==1 - ����� � ���� Report Info By Department.txt!
 * 2 ����� - FIOBossDepartments(int key) ������� ���������� ��  ��� ����������� �������
 * ����==0 - ����� � ��������, ����==1 - ����� � ���� Report Info Boss Department.txt!
 */
public class OrganizationStructure {
    static File file = new File("Report Info By Department.txt");
    static File file1 = new File("Report Info Boss Department.txt");

    private static void infoByDepartments(int key) {//���������� �� �������
        if (key == 0) {
            System.out.println("���������� �� �������!");
            System.out.println(Department.�������������.string());
            System.out.println(Department.����������������.string());
            System.out.println(Department.���������������������.string());
        } else if (key == 1) {
            try {
                if (file.exists()) {
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(String.valueOf(LocalDate.now().atTime(LocalTime.now())) + " - ���� �������� ������");
                    bw.newLine();
                    bw.write("����� ��������������� ���������� �� �������!");
                    bw.newLine();
                    ArrayList<String> departments = new ArrayList<>();
                    departments.add(Department.�������������.string());
                    departments.add(Department.����������������.string());
                    departments.add(Department.���������������������.string());
                    for (String s : departments) {
                        bw.write(s);
                        bw.newLine();
                    }
                    bw.close();
                    fw.close();
                    System.out.println("����� ������ � ������� � ���� Report Info By Department.txt");
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
            System.out.println("������� ���������� ����, ������� ������������ ������!");
        }
    }

    private static void FIOBossDepartments(int key) {//���������� ��� ����������� �������
        if (key == 0) {
            System.out.println("���������� ��� ����������� �������");
            System.out.println(Department.�������������.String2());
            System.out.println(Department.����������������.String2());
            System.out.println(Department.���������������������.String2());
        } else if (key == 1) {
            try {
                if (file.exists()) {
                    FileWriter fw = new FileWriter(file1);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(String.valueOf(LocalDate.now().atTime(LocalTime.now())) + " - ���� �������� ������");
                    bw.newLine();
                    bw.write("����� ��������������� ���������� � �������� ����������� �������!");
                    bw.newLine();
                    ArrayList<String> departments = new ArrayList<>();
                    departments.add(Department.�������������.String2());
                    departments.add(Department.����������������.String2());
                    departments.add(Department.���������������������.String2());
                    for (String s : departments) {
                        bw.write(s);
                        bw.newLine();
                    }
                    bw.close();
                    fw.close();
                    System.out.println("����� ������ � ������� � ���� Report Info Boss Department.txt");
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
            System.out.println("������� ���������� ����, ������� ������������ ������!");
        }
    }

    public static void getFIOBossDepartments(int key) {
        FIOBossDepartments(key);
    }

    public static void getInfoByDepartments(int key) {
        infoByDepartments(key);
    }
}




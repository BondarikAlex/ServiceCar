package Employee_accounting_system.Function_Manager;

import Employee_accounting_system.Data_Emploees.*;
import Employee_accounting_system.Read_Write_File.Read;
import Employee_accounting_system.Read_Write_File.Write;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

import java.util.Scanner;
  /** ����� �������� ������������ ����� ���������� ������ ������!
   � ��� ������������ ������:

   createEmploee() - ����� ������� ��������� � ���� ������ � ������� ����������, � ���������� �� � ������ �����������!
   ������ ����������� - HashMap<Id,Emploee> listEmploees, ������������ ��� ���������� �������� . ���� - ����� ��������
   ������ listEmploees, ������������ ��� ����������� ��������!...
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
                    System.out.println("Enter ���� ��������!");
                    e.setDate_of_birth(scanner.nextLine());
                }
                case 2 -> {
                    System.out.println("�������� ���� ���(��� ��� ���)!");
                    e.setSex(scanner.nextLine());
                }
                case 3 -> {
                    System.out.println("Enter ����� ��������!");
                    e.setContact_phone_number(scanner.nextLine());
                }
                case 4 -> {
                    System.out.println("""
                            ������� ���� ���������?
                            �������� �� ������ ��������?
                             1 - ��������!
                             2 - ���������!
                             3 - ���������!
                             4 - ���������!
                             5 - ��������!
                             6 - ���������!
                             """);
                    int postName = scanner.nextInt();
                    switch (postName) {
                        case 1 -> {
                            e.setSalary(PostSelected.��������.getSalary());
                            e.setPost(PostSelected.��������.getPostName());
                            e.setDepartment(PostSelected.��������.getDepartment());
                            e.setInformation_about_the_boss(PostSelected.��������.getInformation_about_the_boss());
                        }
                        case 2 -> {
                            e.setSalary(PostSelected.���������.getSalary());
                            e.setPost(PostSelected.���������.getPostName());
                            e.setDepartment(PostSelected.���������.getDepartment());
                            e.setInformation_about_the_boss(PostSelected.���������.getInformation_about_the_boss());
                        }
                        case 3 -> {
                            e.setSalary(PostSelected.���������.getSalary());
                            e.setPost(PostSelected.���������.getPostName());
                            e.setDepartment(PostSelected.���������.getDepartment());
                            e.setInformation_about_the_boss(PostSelected.���������.getInformation_about_the_boss());
                        }
                        case 4 -> {
                            e.setSalary(PostSelected.���������.getSalary());
                            e.setDepartment(PostSelected.���������.getDepartment());
                            e.setPost(PostSelected.���������.getPostName());
                            e.setInformation_about_the_boss(PostSelected.���������.getInformation_about_the_boss());
                        }

                        case 5 -> {
                            e.setSalary(PostSelected.��������.getSalary());
                            e.setPost(PostSelected.��������.getPostName());
                            e.setDepartment(PostSelected.��������.getDepartment());
                            e.setInformation_about_the_boss(PostSelected.��������.getInformation_about_the_boss());
                        }
                        case 6 -> {
                            e.setSalary(PostSelected.���������.getSalary());
                            e.setDepartment(PostSelected.���������.getDepartment());
                            e.setPost(PostSelected.���������.getPostName());
                            e.setInformation_about_the_boss(PostSelected.���������.getInformation_about_the_boss());
                        }
                    }
                }
                case 5 -> {
                    System.out.println("����������� ���������� ���������!");

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




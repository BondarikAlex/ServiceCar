package Employee_accounting_system.Function_Manager;

import Employee_accounting_system.Data_Emploees.Emploee;
import Employee_accounting_system.Data_Emploees.Id;
import Employee_accounting_system.Data_Emploees.Register_of_employees;
import Employee_accounting_system.Read_Write_File.Read;
import Employee_accounting_system.Read_Write_File.Write;

import java.util.Map;
import java.util.Scanner;

/**
 *  class ResizeEmploee ������������ ����� ���������� �������������� ����� ���������� � ������������ ������!
 *  changeEmploee()- ����� ������������ ��������� �������� �������������� ����� ����������:
 *  ���� ��� ���������:���,���� ��������,���,���������� �������,���������,�������� ������,��� ���������� ������,��������!
 */
public class ResizeEmploee {
    static Scanner scanner = new Scanner(System.in);

    private static void changeEmploee() {
        Read.getReadFile();
        System.out.println("������� ������� ����������, ������ �������� ������ ���������������!!");
        String name = scanner.nextLine();
        boolean lock = false;
        for (Map.Entry<Id, Emploee> list : Register_of_employees.listEmploees.entrySet()) {
            if (list.getValue().getFIO().equals(name)) {
                lock = true;
                System.out.println(list.getKey().getCount() + "  " + list.getValue().toString());
            }
        }
        if (lock) {
            System.out.println("������� ID ����������, ������ �������� ������ ���������������!");
            Integer id = scanner.nextInt();
            for (Map.Entry<Id, Emploee> list : Register_of_employees.listEmploees.entrySet()) {
                if (list.getKey().getCount().equals(id)) {
                    System.out.println("""
                            ������� �� ��� ����� �� ���� ������� ������ ���������������?
                             1 - ���!
                             2 - ���� ��������!
                             3 - ���!
                             4 - ���������� �������!
                             5 - ���������!
                             6 - �������� ������!
                             7 - ��� ���������� ������!
                             8 - ��������!
                             """);
                    Integer number = scanner.nextInt();
                    scanner.nextLine();// ������ �� ������ ������� ������
                    switch (number) {
                        case 1 -> {
                            System.out.println("������� ����� ���!");
                            String temp = scanner.nextLine();
                            list.getValue().setFIO(temp);
                        }
                        case 2 -> {
                            System.out.println("������� ����� ���� ��������!");
                            String temp = scanner.nextLine();
                            list.getValue().setDate_of_birth(temp);
                        }
                        case 3 -> {
                            System.out.println("������� ����� ���!");
                            String temp = scanner.nextLine();
                            list.getValue().setSex(temp);
                        }
                        case 4 -> {
                            System.out.println("������� ����� ���������� �������!");
                            String temp = scanner.nextLine();
                            list.getValue().setContact_phone_number(temp);
                        }
                        case 5 -> {
                            System.out.println("������� ����� ���������!");
                            String temp = scanner.nextLine();
                            list.getValue().setPost(temp);
                        }
                        case 6 -> {
                            System.out.println("������� ����� �������� ������!");
                            String temp = scanner.nextLine();
                            list.getValue().setDepartment(temp);
                        }
                        case 7 -> {
                            System.out.println("������� ����� ��� ���������� ������!");
                            String temp = scanner.nextLine();
                            list.getValue().setInformation_about_the_boss(temp);
                        }
                        case 8 -> {
                            System.out.println("������� ����� ��������");
                            int sal = scanner.nextInt();
                            list.getValue().setSalary(sal);
                        }
                    }
                }
            }
            Write.getWriteFile();
        }else {
            System.out.println("���������� �� �������!");
        }
    }
    public static void getchangeE(){
        changeEmploee();
    }
}

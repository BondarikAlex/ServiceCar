package Employee_accounting_system.Function_Manager;

import Employee_accounting_system.Data_Emploees.Emploee;
import Employee_accounting_system.Data_Emploees.Id;
import Employee_accounting_system.Data_Emploees.Register_of_employees;
import Employee_accounting_system.Interface_Boot.First;
import Employee_accounting_system.Read_Write_File.Read;

import java.util.Map;
import java.util.Scanner;

/**
 * class FindEmploee ������������� ���������� ������ ����������� �� ����� ���������� ��� ���,
 * ���������, ������, ��� ���������� ������
 * findOfFio() - ����� �� ���
 *  findOfPost() - ����� �� ���������
 * findOfDepartment() - ����� �� ������
 *  findOfFioBoss() - ����� �� ��� ���������� ������
 */
public class FindEmploee {
    static Scanner scanner = new Scanner(System.in);

    private static void findOfFio() {
        boolean findFio = false;
        Read.getReadFile();
        System.out.println("������� ��� ��� ������");
        String Fio = scanner.nextLine();
        for (Map.Entry<Id, Emploee> list : Register_of_employees.getListEmploees().entrySet()) {
            if (list.getValue().getFIO().equals(Fio)) {
                findFio = true;
                System.out.println("��������� ������: ");
                System.out.println(list.getKey().getCount() + "  " + list.getValue().toString());

            }
        }
        if (!findFio) {
            System.out.println("��������� �� ������!");
           back();
        }
        back();
    }

    private static void findOfPost() {
        boolean findPost = false;
        Read.getReadFile();
        System.out.println("������� ����� �� ���������!?");
        String post = scanner.nextLine();
        for (Map.Entry<Id, Emploee> list : Register_of_employees.getListEmploees().entrySet()) {
            if (list.getValue().getPost().equals(post)) {
                findPost = true;
                System.out.println(list.getKey().getCount() + "  " + list.getValue().toString());
            }
        }
        if (!findPost) {
            System.out.println("��� ����������� � ����� ����������!");
           back();
        }
        back();
    }

    private static void findOfDepartment() {
        boolean findOfDep=false;
        Read.getReadFile();
        System.out.println("������� ����� �� ������?");
        String department = scanner.nextLine();
        for (Map.Entry<Id, Emploee> list : Register_of_employees.getListEmploees().entrySet()) {
            if (list.getValue().getDepartment().equals(department)) {
                findOfDep=true;
                System.out.println(list.getKey().getCount() + "  " + list.getValue().toString());
            }
        }
        if(!findOfDep){
            System.out.println("� ���� ������ ��� �� ������ ����������!");
            back();
        }
        back();
    }

    private static void findOfFioBoss() {
        boolean findOfFioBoss=false;
        Read.getReadFile();
        System.out.println("������� ����� �� ������� ���������� ������?");
        String FioBoss = scanner.nextLine();
        for (Map.Entry<Id, Emploee> list : Register_of_employees.getListEmploees().entrySet()) {
            if (list.getValue().getInformation_about_the_boss().equals(FioBoss)) {
                findOfFioBoss=true;
                System.out.println(list.getKey().getCount() + "  " + list.getValue().toString());
            }
        }
        if(!findOfFioBoss){
            System.out.println(" � ����� ���������� ��� ���� ����������!");
            back();
        }
        back();
    }

   private static void back() {
        First.getFind();
    }

    public static void getfindOfPost() {
        findOfPost();
    }
    public static void getfindOfFio() {
        findOfFio();
    }
    public static void getfindOfFioBoss() {
        findOfFioBoss();
    }
    public static void getfindOfDepartment() {
        findOfDepartment();
    }
}

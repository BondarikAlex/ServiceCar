package Employee_accounting_system.Function_Manager;

import Employee_accounting_system.Data_Emploees.Emploee;
import Employee_accounting_system.Data_Emploees.Id;
import Employee_accounting_system.Data_Emploees.Register_of_employees;
import Employee_accounting_system.Read_Write_File.Read;
import Employee_accounting_system.Read_Write_File.Write;

import java.util.Map;
import java.util.Scanner;
/*�������� ������//
����� DeleteEmploee - ��������� ����������!
��� ����� deleteEmploee() - ������������ ��� ��������� � ������� ����� ����������� ���� Works � ������ �� ����!
*/
public class DeleteEmploee {
    static Scanner sc = new Scanner(System.in);

    private static void deleteEmploee() {
        Read.getReadFile();
        System.out.println("������� ������� ����������, � ������� ������ ������� ��������!");
        String name = sc.nextLine();
        for (Map.Entry<Id, Emploee> list : Register_of_employees.listEmploees.entrySet()) {
            if (list.getValue().getFIO().equals(name)) {
                System.out.println(list.getKey().getCount() + "  " + list.getValue().toString());
            }
        }
        System.out.println("������� ID ����������, � ������� ������ ������� ��������!");
        Integer id = sc.nextInt();
        for (Map.Entry<Id, Emploee> list : Register_of_employees.listEmploees.entrySet()) {
            if (list.getKey().getCount().equals(id)) {
                list.getValue().setWorks(false);
                System.out.println(list.getKey().getCount() + "  " + list.getValue().getFIO() + " ������!");
            }
        }
        Write.getWriteFile();
    }
    public static void getDeleteEmploee(){
        deleteEmploee();
    }
}






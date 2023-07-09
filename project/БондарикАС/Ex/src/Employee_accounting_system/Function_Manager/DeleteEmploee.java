package Employee_accounting_system.Function_Manager;

import Employee_accounting_system.Data_Emploees.Emploee;
import Employee_accounting_system.Data_Emploees.Id;
import Employee_accounting_system.Data_Emploees.Register_of_employees;
import Employee_accounting_system.Read_Write_File.Read;
import Employee_accounting_system.Read_Write_File.Write;

import java.util.Map;
import java.util.Scanner;
/*Описание класса//
Класс DeleteEmploee - Увольняет сотрудника!
Его метод deleteEmploee() - предназначен для изменения в реестре учета сотрудников поля Works с правды на ложь!
*/
public class DeleteEmploee {
    static Scanner sc = new Scanner(System.in);

    private static void deleteEmploee() {
        Read.getReadFile();
        System.out.println("Введите Фамилию сотрудника, с которым хотите порвать контракт!");
        String name = sc.nextLine();
        for (Map.Entry<Id, Emploee> list : Register_of_employees.listEmploees.entrySet()) {
            if (list.getValue().getFIO().equals(name)) {
                System.out.println(list.getKey().getCount() + "  " + list.getValue().toString());
            }
        }
        System.out.println("Введите ID сотрудника, с которым хотите порвать контракт!");
        Integer id = sc.nextInt();
        for (Map.Entry<Id, Emploee> list : Register_of_employees.listEmploees.entrySet()) {
            if (list.getKey().getCount().equals(id)) {
                list.getValue().setWorks(false);
                System.out.println(list.getKey().getCount() + "  " + list.getValue().getFIO() + " Уволен!");
            }
        }
        Write.getWriteFile();
    }
    public static void getDeleteEmploee(){
        deleteEmploee();
    }
}






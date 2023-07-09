package Employee_accounting_system.Function_Manager;

import Employee_accounting_system.Data_Emploees.Emploee;
import Employee_accounting_system.Data_Emploees.Id;
import Employee_accounting_system.Data_Emploees.Register_of_employees;
import Employee_accounting_system.Interface_Boot.First;
import Employee_accounting_system.Read_Write_File.Read;

import java.util.Map;
import java.util.Scanner;

/**
 * class FindEmploee представляеет функционал поиска сотрудников по таким параметрам как ФИО,
 * Должности, Отдела, ФИО начальника отдела
 * findOfFio() - поиск по ФИО
 *  findOfPost() - поиск по должности
 * findOfDepartment() - поиск по отделу
 *  findOfFioBoss() - поиск по ФИО начальника отдела
 */
public class FindEmploee {
    static Scanner scanner = new Scanner(System.in);

    private static void findOfFio() {
        boolean findFio = false;
        Read.getReadFile();
        System.out.println("Введите ФИО для поиска");
        String Fio = scanner.nextLine();
        for (Map.Entry<Id, Emploee> list : Register_of_employees.getListEmploees().entrySet()) {
            if (list.getValue().getFIO().equals(Fio)) {
                findFio = true;
                System.out.println("Сотрудник найден: ");
                System.out.println(list.getKey().getCount() + "  " + list.getValue().toString());

            }
        }
        if (!findFio) {
            System.out.println("Сотрудник не найден!");
           back();
        }
        back();
    }

    private static void findOfPost() {
        boolean findPost = false;
        Read.getReadFile();
        System.out.println("Введите поиск по должности!?");
        String post = scanner.nextLine();
        for (Map.Entry<Id, Emploee> list : Register_of_employees.getListEmploees().entrySet()) {
            if (list.getValue().getPost().equals(post)) {
                findPost = true;
                System.out.println(list.getKey().getCount() + "  " + list.getValue().toString());
            }
        }
        if (!findPost) {
            System.out.println("Нет сотрудников с такой должностью!");
           back();
        }
        back();
    }

    private static void findOfDepartment() {
        boolean findOfDep=false;
        Read.getReadFile();
        System.out.println("Введите поиск по отделу?");
        String department = scanner.nextLine();
        for (Map.Entry<Id, Emploee> list : Register_of_employees.getListEmploees().entrySet()) {
            if (list.getValue().getDepartment().equals(department)) {
                findOfDep=true;
                System.out.println(list.getKey().getCount() + "  " + list.getValue().toString());
            }
        }
        if(!findOfDep){
            System.out.println("В этом отделе нет ни одного сотрудника!");
            back();
        }
        back();
    }

    private static void findOfFioBoss() {
        boolean findOfFioBoss=false;
        Read.getReadFile();
        System.out.println("Введите поиск по фамилии Начальника отдела?");
        String FioBoss = scanner.nextLine();
        for (Map.Entry<Id, Emploee> list : Register_of_employees.getListEmploees().entrySet()) {
            if (list.getValue().getInformation_about_the_boss().equals(FioBoss)) {
                findOfFioBoss=true;
                System.out.println(list.getKey().getCount() + "  " + list.getValue().toString());
            }
        }
        if(!findOfFioBoss){
            System.out.println(" У этого начальника нет пока подчиненых!");
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

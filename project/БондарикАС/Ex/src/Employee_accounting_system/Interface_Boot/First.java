package Employee_accounting_system.Interface_Boot;

import Employee_accounting_system.Function_Manager.CreateEmploee;
import Employee_accounting_system.Function_Manager.DeleteEmploee;
import Employee_accounting_system.Function_Manager.FindEmploee;
import Employee_accounting_system.Function_Manager.ResizeEmploee;
import Employee_accounting_system.Reports.AverageSalary;
import Employee_accounting_system.Reports.OrganizationStructure;
import Employee_accounting_system.Reports.Top10ExpensiveSalary;
import Employee_accounting_system.Reports.Top10LoyalEmploee;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class First ������������ ����� ������� ����������� ���������. ����������� ���������� ������ �������� � ���������
 * ����� ���������� ����� ���������!
 */
public class First {
    static Boolean menu = true;
    static int num;
    static Scanner scanner = new Scanner(System.in);

    /**
     * Method menu-���������� ������� ���� ����� ���������!
     * ��� ��������� ������ ������������ ���������� ������ ������ menu!
     */

    public static void menu() {
        while (menu) {
            infoProgramm();
            selectedMenu();
            infoMenu();
            try {
                num = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("������������ ����, ��������� ������ ���������!");
                System.exit(0);
            }
            switch (num) {
                case 1 -> {
                    createE();
                }
                case 2 -> {
                    deleteE();
                }
                case 3 -> {
                    resizeE();
                }
                case 4 -> {
                    find();
                }
                case 5 -> {
                    createReports();
                }
                case 6 -> {
                    System.exit(0);
                }
            }
        }
    }

    static void infoProgramm() {
        System.out.println("""
                 ************************************************
                 *          ������� ����� �����������!          *
                 *                                              *
                 *                                              *
                 *             ********************             *
                 *             *** ������� ���� ***             *
                 *             ********************             *
                 *                                              *
                 ************************************************
                """);
    }

    static void selectedMenu() {
        System.out.println("          �������� ��������?");

    }

    static void infoMenu() {
        System.out.println("""
                 1 - ������� �� ������ ������ ����������!
                 2 - ��������� ����������
                 3 - �������� ���������� � ����������
                 4 - ����� ����������� ������ �����������
                 5 - ������� �����
                 6 - ��������� ������������� ���������
                """);
    }

    private static void createE() {
        infoCreate();
        CreateEmploee.getCreateEmploee();
    }

    private static void deleteE() {
        infoDelete();
        DeleteEmploee.getDeleteEmploee();
    }

    private static void resizeE() {
        infoChange();
        ResizeEmploee.getchangeE();
    }

    private static void find() {
        System.out.println("""
                      *************************************************
                      *                                               * 
                      *                                               *
                      *              *********************            *
                      *              *** ������� ����� ***            *
                      *              *********************            *
                      *                                               *
                      *                                               *
                      *************************************************     
                                       
                               
                                         
                     1 - ����� �� ���
                     2 - ����� �� ���������
                     3 - ����� �� �������� ������
                     4 - ����� �� ��� ���������� ������
                     5 - ����� � ���������� ����
                """);
        selectedMenu();
        num = scanner.nextInt();
        while (true) {
            scanner.nextLine();
            switch (num) {
                case 1 -> {
                    FindEmploee.getfindOfFio();
                }
                case 2 -> {
                    infoSelectPost();
                    FindEmploee.getfindOfPost();
                }
                case 3 -> {
                    infoSelectedDepartment();
                    FindEmploee.getfindOfDepartment();
                }
                case 4 -> {
                    infoSelectedFioBoss();
                    FindEmploee.getfindOfFioBoss();
                }
                case 5 -> {
                    menu();
                }
            }
        }
    }

    private static void createReports() {
        selectedMenu();
        System.out.println("""
                       *************************************************
                       *                                               * 
                       *                                               *
                       *              *********************            *
                       *              *** ������� ����� ***            *
                       *              *********************            *
                       *                                               *
                       *                                               *
                       *************************************************     
                      ������� �����:
                         �� ��������� �����������:
                      1 - ���������� �� �������
                      2 - ��� ����������� �������
                         �� ������� ��������:
                      3 - ����������� 
                      4 - ������
                      5 - ���-10 ����� ������� ����������� �� ��������
                      6 - ���-10 ����� ��������� ����������� �� ���-�� ��� ������ � �����������
                """);
        num = scanner.nextInt();
        switch (num) {
            case 1 -> {
                choice();
                OrganizationStructure.getInfoByDepartments(num);
            }
            case 2 -> {
                choice();
                OrganizationStructure.getFIOBossDepartments(num);
            }
            case 3 -> {
                choice();
                AverageSalary.getAverageSalaryOrganization(num);
            }
            case 4 -> {
                choice();
                AverageSalary.getAverageSalaryOfDepartments(num);
            }
            case 5 -> {
                choice();
                Top10ExpensiveSalary.getTop10ExpensiveSalaryEmploee(num);
            }
            case 6 -> {
                choice();
                Top10LoyalEmploee.getTop10LoyalEmp(num);
            }
        }
    }

    private static void choice() {
        scanner.nextLine();
        System.out.println("""
                0 - ������� ����� � ��������
                1 - ������� ����� � ����
                """);
        num = scanner.nextInt();

    }


    private static void infoCreate() {
        System.out.println("""
                             *******************************
                             *** ������� ����� ��������� ***
                             *******************************
                """);
    }


    private static void infoDelete() {
        System.out.println("""
                      
                                      **********************************   
                                      *** ������� ������� ���������� ***  
                                      **********************************
                                      
                      
                """);
    }

   private static void infoChange() {
        System.out.println("""
                      
                          
                                     ************************************************
                                     *** ������� �������������� ������ ���������� ***
                                     ************************************************
                           
                             
                          
                               
                 """);
    }

    private static void infoSelectPost() {
        System.out.println("""
                     �������� ������:
                     ��������
                     ���������
                     ���������
                     ���������
                     ��������
                     ���������
                """);
    }

    private static void infoSelectedDepartment() {

        System.out.println("""
                      �������� ������:
                      ����� ��������
                      ����� �����������
                      ����� ����������������
                """);
    }

    private static void infoSelectedFioBoss() {
        System.out.println("""
                     �������� ��� ����������� �������
                     ������ �������� ���������
                     ��������� �������� ��������������
                     ������� ����� �������������
                """);


    }

    public static void getFind() {
        find();
    }
}

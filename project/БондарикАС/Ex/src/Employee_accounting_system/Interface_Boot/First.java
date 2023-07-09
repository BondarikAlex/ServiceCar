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
 * Class First представляет собой лицевым интерфейсом программы. Обеспечивая функционал выбора действий в терминале
 * среды разработки самой программы!
 */
public class First {
    static Boolean menu = true;
    static int num;
    static Scanner scanner = new Scanner(System.in);

    /**
     * Method menu-отображает Главное меню самой программы!
     * Все остальные методы представляют функционал самого метода menu!
     */

    public static void menu() {
        while (menu) {
            infoProgramm();
            selectedMenu();
            infoMenu();
            try {
                num = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Неправильный ввод, повторите запуск программы!");
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
                 *          Система учета сотрудников!          *
                 *                                              *
                 *                                              *
                 *             ********************             *
                 *             *** Главное Меню ***             *
                 *             ********************             *
                 *                                              *
                 ************************************************
                """);
    }

    static void selectedMenu() {
        System.out.println("          Выберете действие?");

    }

    static void infoMenu() {
        System.out.println("""
                 1 - Принять на работу нового сотрудника!
                 2 - Увольнять сотрудника
                 3 - Изменить информацию о сотруднике
                 4 - Поиск сотрудников внутри организации
                 5 - Создать отчет
                 6 - Завершить использование программы
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
                      *              *** Подменю Поиск ***            *
                      *              *********************            *
                      *                                               *
                      *                                               *
                      *************************************************     
                                       
                               
                                         
                     1 - Поиск по ФИО
                     2 - Поиск по должности
                     3 - Поиск по названию отдела
                     4 - Поиск по ФИО начальника отдела
                     5 - Выйти в предыдущее меню
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
                       *              *** Подменю Отчет ***            *
                       *              *********************            *
                       *                                               *
                       *                                               *
                       *************************************************     
                      Создать отчет:
                         По структуре организации:
                      1 - Информация об отделах
                      2 - ФИО начальников отделов
                         По средней зарплате:
                      3 - Организации 
                      4 - Отдела
                      5 - Топ-10 самых дорогих сотрудников по зарплате
                      6 - Топ-10 самых преданных сотрудников по кол-ву лет работы в организации
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
                0 - Вывести отчет в терминал
                1 - Вывести отчет в файл
                """);
        num = scanner.nextInt();

    }


    private static void infoCreate() {
        System.out.println("""
                             *******************************
                             *** Подменю Новый Сотрудник ***
                             *******************************
                """);
    }


    private static void infoDelete() {
        System.out.println("""
                      
                                      **********************************   
                                      *** Подменю Уволить Сотрудника ***  
                                      **********************************
                                      
                      
                """);
    }

   private static void infoChange() {
        System.out.println("""
                      
                          
                                     ************************************************
                                     *** Подменю Редактирование Записи Сотрудника ***
                                     ************************************************
                           
                             
                          
                               
                 """);
    }

    private static void infoSelectPost() {
        System.out.println("""
                     Варианты поиска:
                     Художник
                     Скульптор
                     Бухгалтер
                     Экономист
                     Электрик
                     Монтажник
                """);
    }

    private static void infoSelectedDepartment() {

        System.out.println("""
                      Варианты поиска:
                      Отдел Культуры
                      Отдел Образования
                      Отдел Электроснабжения
                """);
    }

    private static void infoSelectedFioBoss() {
        System.out.println("""
                     Варианты ФИО начальников отделов
                     Пупкин Вячеслав Иосифович
                     Морковкин Мирослав Апполеонарович
                     Силович Артем Александрович
                """);


    }

    public static void getFind() {
        find();
    }
}

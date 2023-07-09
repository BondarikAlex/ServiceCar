package Employee_accounting_system.Data_Emploees;
import java.util.HashMap;

/*Класс <<<Register_of_employees>>> предназначен для временного хранения сотрудников в HashMap<Id,Emploees>listEmploees!
 При работе программы listEmploees загружается в оперативную память , и используется функционалом программы!
*/
                                           // Методы класса:

/**
 * getListEmploees() - возвращает listEmploees;
 *  setListEmploees(HashMap<Id, Emploee> listEmploees) - заменяет listEmploees на другой лист такого же типа!
 */



public class Register_of_employees extends Emploee{

     public static HashMap<Id, Emploee> listEmploees = new HashMap<>();//хранилище сотрудников по ID

     public static HashMap<Id, Emploee> getListEmploees() {
          return listEmploees;
     }
     public static void setListEmploees(HashMap<Id,Emploee> listEmploees) {
          Register_of_employees.listEmploees = listEmploees;
     }

     @Override
     public String toString() {
          return "Register_of_employees{" +
                  "FIO='" + getFIO() + '\'' +
                  ", date_of_birth='" + getDate_of_birth() + '\'' +
                  ", sex='" + getSex() + '\'' +
                  ", contact_phone_number='" + getContact_phone_number() + '\'' +
                  ", post='" + getPost() + '\'' +
                  ", department='" + getDepartment() + '\'' +
                  ", information_about_the_boss='" + getInformation_about_the_boss() + '\'' +
                  ", date_of_employment='" + getDate_of_employment() + '\'' +
                  ", salary=" + getSalary() +
                  ", works=" + getWorks() +
                  '}';
     }
}



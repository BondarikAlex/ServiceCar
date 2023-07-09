package Employee_accounting_system.Data_Emploees;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * class Emploee - представляет себе шаблон Сотрудника
 */
public class Emploee implements  Serializable {

       private String FIO;//фио
       private String date_of_birth;//дата рождения
       private String sex;//ПОЛ
       private String contact_phone_number;//телефон
       private String post;//должность
       private String department;//отдел
       private String information_about_the_boss;//информация о начальнике
       private LocalDate date_of_employment;//дата приема на работу
       private int salary;// зарплата
       private Boolean works=true;



       public String getFIO() {
           return FIO;
       }

       public void setFIO(String FIO) {
           this.FIO = FIO;
       }

       public String getDate_of_birth() {
           return date_of_birth;
       }

       public void setDate_of_birth(String date_of_birth) {
           this.date_of_birth = date_of_birth;
       }

       public String getSex() {
           return sex;
       }

       public void setSex(String sex) {
           this.sex = sex;
       }

       public String getContact_phone_number() {
           return contact_phone_number;
       }

       public void setContact_phone_number(String contact_phone_number) {
           this.contact_phone_number = contact_phone_number;
       }

       public String getPost() {
           return post;
       }

       public void setPost(String post) {
           this.post = post;
       }

       public String getDepartment() {
           return department;
       }

       public void setDepartment(String department) {
           this.department = department;
       }

       public String getInformation_about_the_boss() {
           return information_about_the_boss;
       }

       public void setInformation_about_the_boss(String information_about_the_boss) {
           this.information_about_the_boss = information_about_the_boss;
       }

    public LocalDate getDate_of_employment() {
        return date_of_employment;
    }

    public void setDate_of_employment(LocalDate date_of_employment) {
        this.date_of_employment = date_of_employment;
    }

    public  int getSalary() {
           return salary;
       }

       public void setSalary(int salary) {
           this.salary = salary;
       }

       public Boolean getWorks() {
           return works;
       }

       public void setWorks(Boolean works) {
           this.works = works;
       }


    @Override
    public String toString() {
        return
                "FIO='" + FIO + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                ", sex='" + sex + '\'' +
                ", contact_phone_number='" + contact_phone_number + '\'' +
                ", post='" + post + '\'' +
                ", department='" + department + '\'' +
                ", information_about_the_boss='" + information_about_the_boss + '\'' +
                ", date_of_employment='" + date_of_employment + '\'' +
                ", salary=" + salary +
                ", works=" + works ;
    }

    public String toString2() {

        return
                "FIO='" + FIO + '\'' +
                        ", salary=" + salary
                ;

    }





}

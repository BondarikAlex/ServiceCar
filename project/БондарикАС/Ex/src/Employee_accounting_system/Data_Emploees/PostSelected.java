package Employee_accounting_system.Data_Emploees;

 /**Описание Enam
  enum PostSelected - предназначен для хранения константных значений по должностям!
  Содержит поля по Зарплате, Должности, Отделе и информации о начальнике отдела!
  Содержит геттеры по всем полям  !
*/



public enum PostSelected {
    ХУДОЖНИК(1000, "Художник", "Отдел Культуры", "Пупкин Вячеслав Иосифович"),
    СКУЛЬПТОР(1000, "Скульптор", "Отдел Культуры","Пупкин Вячеслав Иосифович"),
    БУХГАЛТЕР(700, "Бухгалтер", "Отдел Образования","Морковкин Мирослав Апполеонарович"),
    ЭКОНОМИСТ(750, "Экономист", "Отдел Образования","Морковкин Мирослав Апполеонарович"),
    ЭЛЕКТРИК(850, "Электрик", "Отдел Электроснабжения","Силович Артем Александрович"),
    МОНТАЖНИК(2000, "Монтажник", "Отдел Электроснабжения","Силович Артем Александрович");


    private final Integer salary;
    private final String postName;
    private final String department;
    private final String Information_about_the_boss;


    PostSelected(Integer salary, String postName, String department, String information_about_the_boss){
        this.salary = salary;
        this.postName = postName;
        this.department = department;
        Information_about_the_boss = information_about_the_boss;
    }

    public String getPostName() {
        return postName;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getInformation_about_the_boss() {
        return Information_about_the_boss;
    }
}

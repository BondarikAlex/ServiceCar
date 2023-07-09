package Employee_accounting_system.Data_Emploees;


/**
 *  Enam Department содержит в себе константные значения типа отдел (Department)
 */

public enum Department {
    ОТДЕЛКУЛЬТУРЫ("Отдел Культуры", "Художник", "Скульптор", "Пупкин Вячеслав Иосифович"),
    ОТДЕЛОБРАЗОВАНИЯ("Отдел Образования", "Бухгалтер", "Экономист", "Морковкин Мирослав Апполеонарович"),
    ОТДЕЛЭЛЕКТРОСНАБЖЕНИЯ("Отдел Электроснабжения", "Электрик", "Монтажник", "Силович Артем Александрович");

    private final String nameDepartment;
    private final String postName;
    private final String postName1;
    private final String Information_about_the_boss;


    Department(String nameDepartment, String postName, String postName1, String information_about_the_boss) {
        this.nameDepartment = nameDepartment;
        this.postName = postName;
        this.postName1 = postName1;
        Information_about_the_boss = information_about_the_boss;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public String getPostName() {
        return postName;
    }

    public String getPostName1() {
        return postName1;
    }

    public String getInformation_about_the_boss() {
        return Information_about_the_boss;
    }


    public String String2() {
        return "ФИО начальника отдела = " + Information_about_the_boss + "\n" +
                "1 Должность =" + postName + '\n' +
                "2 Должность = " + postName1 + '\n' +
                " Отдел = " + nameDepartment + "\n" +
                "___________________________________________________________________";
    }

    public String string() {
        return
                " Отдел = " + nameDepartment + "\n" +
                        "1 Должность =" + postName + '\n' +
                        "2 Должность = " + postName1 + '\n' +
                        "ФИО начальника отдела = " + Information_about_the_boss + "\n" +
                        "___________________________________________________________________";

    }

    @Override
    public String toString() {
        return super.toString();
    }
};
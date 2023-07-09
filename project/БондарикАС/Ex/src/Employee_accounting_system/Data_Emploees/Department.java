package Employee_accounting_system.Data_Emploees;


/**
 *  Enam Department �������� � ���� ����������� �������� ���� ����� (Department)
 */

public enum Department {
    �������������("����� ��������", "��������", "���������", "������ �������� ���������"),
    ����������������("����� �����������", "���������", "���������", "��������� �������� ��������������"),
    ���������������������("����� ����������������", "��������", "���������", "������� ����� �������������");

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
        return "��� ���������� ������ = " + Information_about_the_boss + "\n" +
                "1 ��������� =" + postName + '\n' +
                "2 ��������� = " + postName1 + '\n' +
                " ����� = " + nameDepartment + "\n" +
                "___________________________________________________________________";
    }

    public String string() {
        return
                " ����� = " + nameDepartment + "\n" +
                        "1 ��������� =" + postName + '\n' +
                        "2 ��������� = " + postName1 + '\n' +
                        "��� ���������� ������ = " + Information_about_the_boss + "\n" +
                        "___________________________________________________________________";

    }

    @Override
    public String toString() {
        return super.toString();
    }
};
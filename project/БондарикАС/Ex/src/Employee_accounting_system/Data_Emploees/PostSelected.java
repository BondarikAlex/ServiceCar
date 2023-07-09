package Employee_accounting_system.Data_Emploees;

 /**�������� Enam
  enum PostSelected - ������������ ��� �������� ����������� �������� �� ����������!
  �������� ���� �� ��������, ���������, ������ � ���������� � ���������� ������!
  �������� ������� �� ���� �����  !
*/



public enum PostSelected {
    ��������(1000, "��������", "����� ��������", "������ �������� ���������"),
    ���������(1000, "���������", "����� ��������","������ �������� ���������"),
    ���������(700, "���������", "����� �����������","��������� �������� ��������������"),
    ���������(750, "���������", "����� �����������","��������� �������� ��������������"),
    ��������(850, "��������", "����� ����������������","������� ����� �������������"),
    ���������(2000, "���������", "����� ����������������","������� ����� �������������");


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

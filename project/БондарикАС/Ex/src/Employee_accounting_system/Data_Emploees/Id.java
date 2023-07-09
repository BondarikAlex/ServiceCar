package Employee_accounting_system.Data_Emploees;


import java.io.Serializable;
/**Описание класса
 class Id - представляет себя Обьектом в виде числового указателя для каждой позиции (записи) сотрудника в реестре сотрудника!
*/

public class Id implements Serializable {

    Integer count;

    public Id() {
        this.count = Register_of_employees.getListEmploees().size() + 1;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Id{" +
                "count=" + count +
                '}';
    }
}


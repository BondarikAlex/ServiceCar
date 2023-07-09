package Employee_accounting_system.Reports;

import Employee_accounting_system.Data_Emploees.Emploee;
import Employee_accounting_system.Data_Emploees.Id;

import java.util.Comparator;
import java.util.Map;

/**
 * Сортитровка для Map.Entry<Id, Emploee>
 *     Метод compare сравнивает 2 параметризованных обьека по значению getSalary()!
 */
public class CompareEmploeeSalary implements Comparator<Map.Entry<Id, Emploee>> {


    @Override
    public int compare(Map.Entry<Id, Emploee> o1, Map.Entry<Id, Emploee> o2) {
        return o2.getValue().getSalary()-o1.getValue().getSalary();
    }
}

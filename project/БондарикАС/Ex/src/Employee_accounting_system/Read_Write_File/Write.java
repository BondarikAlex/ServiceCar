package Employee_accounting_system.Read_Write_File;

import Employee_accounting_system.Data_Emploees.Register_of_employees;

import java.io.*;

/**�������� ������
 * ����� Write - ���������� ���������� ������ ���������� ����� HashMap<Id,Emploee> listEmploees � ���� DataEmploee.bin;
 *  ������ ������: writeFile() - ���������� Map ���� � ����!
 */


public class Write {
    static File file = new File("DataEmploee.bin");


    private static void writeFile() {
        if (file.exists()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, false))) {
                oos.writeObject(Register_of_employees.getListEmploees());
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {

            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
            writeFile();
        }
        System.out.println("�������� � ����!");

    }
public static void getWriteFile(){
        writeFile();
}

}

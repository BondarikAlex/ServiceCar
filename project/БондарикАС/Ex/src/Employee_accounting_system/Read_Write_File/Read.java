package Employee_accounting_system.Read_Write_File;

import Employee_accounting_system.Data_Emploees.Emploee;
import Employee_accounting_system.Data_Emploees.Id;
import Employee_accounting_system.Data_Emploees.Register_of_employees;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static Employee_accounting_system.Read_Write_File.Write.file;
/**
 * Описание класса
 * Класс Read - предлагает функционал чтения физического файла DataEmploee.bin и сохранения в вовременный
 * лист HashMap<Id,Emploee> listEmploees
 *  Методы класса: readFile() - читает файл и сохраняет его в Map лист!
 */

public class Read {


    public boolean isFileEmpty(File file) {
        return file.length() < 10;
    }

    private static void readFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Register_of_employees.listEmploees = (HashMap<Id, Emploee>) ois.readObject();
        }catch (FileNotFoundException e){e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.getMessage();
        } catch (NullPointerException e) {
            System.out.println("Пустой файл, создайте запись о сотруднике!");
            e.getMessage();
        }
        System.out.println("Ввывожу список сотрудников для наглядности:(Можно отключить в классе Read )");//закоментить
        for (Map.Entry<Id, Emploee> list : Register_of_employees.listEmploees.entrySet()) {
            System.out.println(list.getKey().getCount()+"  "+list.getValue().toString());
        }                                                                                               //
        System.out.println();
        System.out.println();
    }
    public static void getReadFile(){
        readFile();
    }
}
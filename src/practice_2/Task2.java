package practice_2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/*
 * Запишите в файл следующие строки:
 * <p>
 * Анна=4
 * Елена=5
 * Марина=6
 * Владимир=?
 * Константин=?
 * Иван=4
 * <p>
 * Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив (либо HashMap, если
 * студенты с ним знакомы). В отдельном методе нужно будет пройти по структуре данных, если сохранено
 * значение ?, заменить его на соответствующее число. Если на каком-то месте встречается символ, отличный от
 * числа или ?, бросить подходящее исключение.
 */
public class Task2 {
    private static Random random = new Random();

    public static void main(String[] args) {
        prepareFile();
    }

    static void prepareFile() {
        //FileWriter fileWriter = null;
        try (FileWriter fileWriter = new FileWriter("name.txt", false)){ // closeable класс имплементирует
            //fileWriter = new FileWriter("name.txt", false); //false - не перезаписывать в файл
        fileWriter.write("Анна=4\n");
        fileWriter.write("Елена=5\n");
        fileWriter.write("Марина=6\n");

        if (random.nextInt(2) == 0) {
            throw new Exception("Error.");
        }

        fileWriter.write("Денис=9\n");
        fileWriter.write("Костя=7\n");
        fileWriter.write("Иван=?\n");
        fileWriter.flush(); //синхронизирует буфер
        //fileWriter.close(); // завершение метода
    }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
//        finally {
//            try {
//                if (fileWriter != null)
//                    fileWriter.close();
//            } catch (IOException ex) {
//
//            }
//        }
    }
}

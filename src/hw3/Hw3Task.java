package hw3;

import jdk.jshell.spi.SPIResolutionException;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
 * Фамилия Имя Отчество дата рождения номер телефона пол
 * Форматы данных:
 * фамилия, имя, отчество - строки
 * датарождения - строка формата dd.mm.yyyy
 * номертелефона - целое беззнаковое число без форматирования
 * пол - символ латиницей f или m.
 * 1 Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение,
 *  что он ввел меньше и больше данных, чем требуется.
 * 2 Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных не совпадают, нужно бросить исключение,
 *  соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией,
 *  что именно неверно.
 * 3 Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
 * 4 <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
 * 5 Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
 * 6 Не забудьте закрыть соединение с файлом.
 * 7 При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
 * */
public class Hw3Task { // Fadeev Anton Viktorovich 25.08.1990 89546231475 f / Andreeva Katya Viktorovna 25.08.1990 89546231475 f / Fadeev Igor Egorovich 05.12.1998 89546234589 m

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        enterYourData();
    }

    public static void enterYourData() {

        System.out.print("Введите данные через пробел: Фамилия Имя Отчество Дату рождения(dd.mm.yyyy) Номер телефона(8XXXXXXXXXX) пол(m/f): ");
        String requestedValues = scanner.nextLine();
        String [] person = requestedValues.split(" ");

        try {
            stringLengthComparing(person.length);
            SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
            sdf.parse(person[3]);
            long telNumber = Long.parseLong(person[4]);
            genderFormatComparing(person[5]);
        }
        catch (NotFullDataException e){
            throw new NotFullDataException(e.getMessage());
        }
        catch (ParseException e) {
            throw new RuntimeException("Неверный формат даты!");
        }
        catch (NumberFormatException e) {
            System.out.println("Неверный формат номера телефона!");
        }
        catch (InvalidGenderFormat e) {
            throw new InvalidGenderFormat(e.getMessage());
        }

        try (FileWriter fileWriter = new FileWriter(person[0] + ".txt", true)) {
            fileWriter.write("\n");
            for (String data : person) {
                fileWriter.write("<" + data + ">");
            }
            fileWriter.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.getStackTrace();
        }
//        for (String data : person) {
//            System.out.printf(data + " ");
    }

    private static void stringLengthComparing(int length) {
        if (length < 6) throw new NotFullDataException("Вы ввели не полные данные!");
        if (length > 6) throw new NotFullDataException("Вы ввели лишние данные!");
    }
    private static void genderFormatComparing (String s) {
        if (!(s.equals("m") || s.equals("f")))
            throw new InvalidGenderFormat("Не верный формал пола!");
    }
}

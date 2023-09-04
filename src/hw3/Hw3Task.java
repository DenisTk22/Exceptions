package hw3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
 * Фамилия Имя Отчество датарождения номертелефона пол
 * Форматы данных:
 * фамилия, имя, отчество - строки
 * датарождения - строка формата dd.mm.yyyy
 * номертелефона - целое беззнаковое число без форматирования
 * пол - символ латиницей f или m.
 * */
public class Hw3Task { // Fadeev Anton Viktorovich 25.08.1990 89546231475 m

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        enterYourData();
    }

    //запрос данных у пользователя через пробел (Фамилия Имя Отчество датарождения номертелефона пол)
    public static void enterYourData() {
        System.out.print("Введите данные через пробел: Фамилия Имя Отчество Дату_рождения(dd.mm.yyyy) Номер_телефона(8XXXXXXXXXX) пол(m/f): ");
        String requestedValues = scanner.nextLine();
        String [] person = requestedValues.split(" ");
//        System.out.println(person.length);
        if (requestedValues.equals(""))
            throw new RuntimeException("Пустой строку оставлять нельзя!");

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
            System.out.println("Не верный формат номера телефона!");
        }
        catch (InvalidGenderFormat e) {
            throw new InvalidGenderFormat(e.getMessage());
        }

        for (String data : person) {
            System.out.printf(data + " ");
        }
    }

    private static void stringLengthComparing(int length) {
        if (length < 6) throw new NotFullDataException("Вы ввели не полные данные!");
    }
    private static void genderFormatComparing (String s) {
        if (!(s.equals("m") || s.equals("f")))
            throw new InvalidGenderFormat("Не верный формал пола!");
    }
}

package hw2;

import java.util.Scanner;

/**
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
 * Ввод текста вместо числа не должно приводить к падению приложения,
 * вместо этого, необходимо повторно запросить у пользователя ввод данных.
 * */

public class Hw2Task1 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        floatRequest();
    }


    public static void floatRequest() {

        try {
            System.out.print("Введите дробное число: ");
            float requestedValue = Float.parseFloat(scanner.nextLine());
            System.out.printf("Вы ввели число: %f\n", requestedValue);
        } catch (NumberFormatException e) {
            System.out.println("Введите число цифрами.");
            floatRequest();
        }
    }
}

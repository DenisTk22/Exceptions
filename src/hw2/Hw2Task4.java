package hw2;

import java.util.Scanner;
/**Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
 * Пользователю должно показаться сообщение, что пустые строки вводить нельзя.*/
public class Hw2Task4 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        enterName();
    }
    public static void enterName() {
        System.out.print("Введите свое имя: ");
        String requestedValue = scanner.nextLine();
        if (requestedValue.equals(""))
            throw new RuntimeException("Пустой строку оставлять нельзя!");
        else
            System.out.printf("Тебя чё зовут: %s?, ха-ха! ", requestedValue);
    }
}

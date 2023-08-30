package hw2;

/**
 * Найти ошибки
 * */
public class Hw2Task2 {
    public static void main(String[] args) { // должен запускаться в методе
        try {
            int d = 0;
            int[] intArray = new int[10]; // не проинициализирован массив
            intArray[8] = 4; // не задан элемент под индексом 8
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e.getMessage()); // добавил метод getMessage
        }
    }
}

package hw1;

/**
 * Дописать методы
 * */
public class hw1Task1 {
    class Answer {
        public static void arrayOutOfBoundsException() {
            int[] ints = new int[10];
            System.out.println(ints[11]);

        }

        public static void divisionByZero() {
            int a = 5;
            int b = 0;
            System.out.println(a/b);
        }

        public static void numberFormatException() {
            int a = 5;
            String b = "пять";
            int c = Integer.parseInt(b);
            System.out.println(a/c);

        }
    }
    public class Printer {
        public void main(String[] args) {
            Answer ans = new Answer();
            try {
                ans.arrayOutOfBoundsException();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Выход за пределы массива");
            }

            try {
                ans.divisionByZero();
            } catch (ArithmeticException e) {
                System.out.println("Деление на ноль");
            }

            try {
                ans.numberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Ошибка преобразования строки в число");
            }
        }
    }
}

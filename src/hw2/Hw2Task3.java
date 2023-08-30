package hw2;

/**
 * Найти ошибки
 * */
public class Hw2Task3 {
    public static void main(String[] args) throws Exception { //
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        }
//        catch (Throwable ex) {
//            System.out.println("Что-то пошло не так...");
//        }
        catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }catch ( Exception ex) { // Throwable - не нужен, достаточно уровня Exception
            System.out.println("Что-то пошло не так..."); // переместил исключение более высокого уровня вниз, чтобы низкоуровневые исключения могли реализоваться
        }
    }
    public static void printSum(Integer a, Integer b)  { //throws FileNotFoundException - не нужен
        System.out.println(a + b);
    }
}

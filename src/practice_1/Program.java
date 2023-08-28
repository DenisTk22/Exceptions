package practice_1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Program {

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    public static void main(String[] args) {
//        System.out.printf("Длина массива: %d\n", task1(new int[] {1, 2, 3}));
//        task2();
        //task3();
//        task4();
        task5();
    }

    /**
     Реализовать метод, принимающий в качестве аргумента целочисленный массив.
     Если длина массива меньше некоторого заданного минимума, метод возвращает
     -1, в качестве кода ошибки, иначе - длину массива.
     * @param array массив
     * @return
     * */
    static int task1(int[] array){
        if (array == null) {
            return -2;
        }
        if (array.length == 0) {
            return -1;
        }
        return array.length;
    }

    /**
     * Реализуйте метод, принимающий массив и некоторое значение
     * */
    static void task2() {
        while (true) {
            System.out.print("Введите значение для поиска: ");
            int searchValue = Integer.parseInt(scanner.nextLine());
            int[] array = new int[random.nextInt(5) + 1];
            if (random.nextInt(3) == 0)
                array = null;
            if (array != null) {
                for (int i = 0; i < array.length; i++) {
                    array[i] = random.nextInt(10);
                    System.out.printf("%d\t", array[i]);
                }
                System.out.println();
            }
            int codeResult = processArray(array, searchValue);
            switch (codeResult) {
                case -1 -> System.out.println("Длина массива менее трех символов");
                case -2 -> System.out.println("Элемент не найден");
                case -3 -> System.out.println("Массив некорректно проиницаилизирован");
                default -> {
                    System.out.println("Массив успешно обработан");
                    System.out.printf("Элемент найден по индексу %d\n", codeResult);
                    return;
                }
            }

        }
    }

    static int processArray(int[] array, int searchValue) {
        if (array == null) {
            return -3; // массив некорректно проиницаилизирован
        }
        if (array.length < 3) {
            return -1; // длина массива менее трех символов
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
            System.out.printf("%d\t", array[i]);
        }
        System.out.println();
        int searchResult =  Arrays.binarySearch(array, searchValue);
        if (searchResult < 0)
            return -2; // элемент не найден
        return searchResult;
    }

    /**
     * Реализуйте метод, принимающий в качестве аргумента целочисленный двемерный массив.
     *      Необходимо посчитать и вернуть сумму элементов этого массива.
     *      При этом накладываем на метод 2 ограничение: метод межет работать только с квадратными массивами
     *      (кол-во строк = кол-ву столбцов), и в каждой ячейке лежать только значение 0 или 1.
     *      Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибке.
     */

    static void task3() {
        for (int i = 0; i < 5; i++)
            processArray(generateArray());
    }
    static void processArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != array.length)  // проверка что массив квадратный
                throw new RuntimeException("Некорректная размерность массива");
            }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++){
                if (array[i][j] !=0 && array[i][j] != 1)
                    throw new RuntimeException(String.format("Некорректное значение элемента массива по индексу [%d][%d]\n", i,j));
                else
                    sum += array[i][j];
            }
        }
        System.out.printf("Сумма элементов массива: %d\n", sum);
    }

    /**
     * Метод генерации двумерного массива
     * @return двумерный массив
     */
    static int[][] generateArray() {
        int[][] array = new int[random.nextInt(4,6)][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++){
                array[i][j] = random.nextInt(2);
            }
        }
        if (random.nextInt(2) == 0) {
            array[0][0] = 2;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++){
                System.out.printf("%d\t", array[i][j]);
            }
            System.out.println();
        }
        return array;
    }
/***
 * Метод должен вернуть код ошибки
 */

    static  void task4() {
        for (int i = 0; i < 5; i++) {
            int errCode = processArrayV2(generateArray());
            switch (errCode) {
                case -1 -> System.out.println("Некорректная размерность массива");
                case -2 -> System.out.println("Некорректное значение элемента массива");
                default -> {
                    System.out.printf("Сумма элементов массива: %d\n", errCode);
                }
            }
        }
    }

    static int processArrayV2(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != array.length)  // проверка что массив квадратный
                return -1;
                //throw new RuntimeException("Некорректная размерность массива");
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++){
                if (array[i][j] !=0 && array[i][j] != 1)
                    return -2;
                    //throw new RuntimeException(String.format("Некорректное значение элемента массива по индексу [%d][%d]\n", i,j));
                else
                    sum += array[i][j];
            }
        }
        //System.out.printf("Сумма элементов массива: %d\n", sum);
        return sum;
    }

    /**
     * Реализуйте метод, принимающий в качестве аргумента два целочисленных массива,
     * и возвращающий новый массив, каждый элемент которого равен сумме элементов двух
     * входящих массивов в той же ячейке.
     * Если длины массивов не равны, необходимо оповестить пользователя
     */

    static void task5() {

        try { // содержит блок где может возникнуть исключение
            int[] arr = getSumArray(new int[]{1, 0, -1, 9, 8}, new int[]{4, 3, 2, 0, 8});
            for (int e: arr) {
                System.out.printf("%d\t", e);
            }
            System.out.println();
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        catch (CustomArraySizeException e) { // в блоке catch нужно указать каким типом исключения нужно пользоваться
            System.out.println(e.getMessage());
            System.out.printf("Длина первого массива: %d\nДлина второго массива: %d\n",
                    e.getLength1(), e.getLength2());
        }
    }
    static int[] getSumArray(int[] array1, int[] array2) {
        if (array1 == null || array2 == null)
            throw new NullPointerException("Оба массива должны существовать");
        if (array1.length != array2.length) {
            throw new CustomArraySizeException("Кол-во элементов массива должно быть одинаковым!", array1.length, array2.length);
        }
        int[] res = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            res[i] = array1[i] + array2[i];
        }
        return res;
    }
}


package practice_2;

import java.util.Random;

public class Task1 {
    /***
     *
     */
    private static Random random = new Random();
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.printf("*** Итерация #%d ***\n", i + 1);
            processArray();
        }
    }
    private static void processArray() {
        try {
            System.out.printf("Сумма всех элементов массива %d\n", processArrayInternal(generateArray()));
        } catch (MyArrayDataException e) {
            System.out.printf("%s по индексу [%d][%d]\n", e.getMessage(), e.getX(), e.getY());
        }
        catch (MyArraySizeException e) {
            System.out.printf("%s Требовалось 4*4, получили [%d][%d]\n", e.getMessage(), e.getX(), e.getY());
        }
        catch (Exception e) {
            //e.getStackTrace();
            e.printStackTrace();
        }
        //processArrayInternal(generateArray());
    }

    public static String[][] generateArray() {
        int add = random.nextInt(2);
        String[][] array = new String[4 + add][4 + add];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = Integer.toString(random.nextInt(10, 100));
            }
        }
        if (random.nextInt(3) == 0) {
            array[random.nextInt(array.length)][random.nextInt(array.length)] = "abc";
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%s\t", array[i][j]);

                }
            System.out.println();
            }
        return array;
        }

    /**
     *
     * @param array
     * @return
     * @throws MyArraySizeException
     * @throws MyArrayDataException
     */
    private static int processArrayInternal (String[][] array) throws MyArraySizeException, MyArrayDataException{
            if (array.length != 4 || array[0].length != 4) {
                throw new MyArraySizeException("Некорректный размер массива.", array.length, array[0].length);
            }
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    sum += parseElement(array[i][j], i, j);
                }
            }
            return sum;
        }

    /**
     * Вспомогательный метод, преобразует значение элемента к числу
     * @param s значение элемента
     * @param x индекс элемента в массиве
     * @param y индекс элемента в массиве
     * @return число
     * @throws MyArrayDataException Некорректный формат массива
     */

        private static int parseElement(String s, int x, int y) throws MyArrayDataException{
        try {
            return Integer.parseInt(s);
        }
        catch (NullPointerException e) {
            throw new MyArrayDataException("Некорректный формат массива", x, y);
            }
        }
    }


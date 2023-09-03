package practice_3;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * */
public class Task1 {
    public static void main(String[] args) {

//        try {
//            test1();
//        } catch (ArithmeticException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            test2(new String[] {"AA", "dd", null, "gg"}, 3);
//        } catch (NullElementArrayException e) {
//            System.out.println(e.getMessage());
//        }

        try {
            test3("ekrmfer.txt");
        } catch (MyFileNotFoundException e) {
            System.out.printf("Файл не существет: %s\n", e.getMessage(), e.fileName);
        }


    }

//    static void test1() {
//        try {
//            int a = 10 /0;
//        } catch (ArithmeticException e) {
//            throw new DivisionByZeroException("Ошибка деления на ноль");
//        }
//    }

//    static void test2(String[] array, int index) {
//        try {
//            if (array[index] == null)
//                throw new NullElementArrayException("элемент на проиниализирован", index);
//            System.out.printf("Значение элемента массива: %s\n", array[index]);
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println(e.getMessage());
//        }
//    }

    static void test3(String fileName) throws MyFileNotFoundException{
        try {
        FileReader fileReader = new FileReader(fileName);
    } catch (FileNotFoundException e) {
            throw new MyFileNotFoundException("Файл не найден", fileName);
        }

}

class NullElementArrayException extends NullPointerException {

    private final int index;

    public int getIndex() {
        return index;
    }

    public NullElementArrayException(String s, int index) {
        super(s);
        this.index = index;
    }
}

class DivisionByZeroException extends ArithmeticException {

    public DivisionByZeroException(String s) {
        super(s);
    }
}

static class MyFileNotFoundException extends Exception {

    private String fileName;

    public MyFileNotFoundException(String message, String fileName) {
        super(message);
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }}}



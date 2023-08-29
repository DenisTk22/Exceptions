package lecture_2;

import com.sun.source.util.SourcePositions;

import java.sql.SQLOutput;

public class TryCatch {
    public static void main(String[] args) {
        int number = 1;
        try {
            number = 10 / 0;
            String test = null;
            System.out.println(test.length());
        }
        catch (ArithmeticException e) { //будут отлавливаться только ArithmeticException, если нужно чтобы отлавливались все исключения, то нужно поднять на уровень выше до RuntimeExceprion
            System.out.println("На ноль делить нельзя!");
        }
        catch (NullPointerException e) {
            System.out.println("Строки не существет!");
        }
        System.out.println(number);
    }
}

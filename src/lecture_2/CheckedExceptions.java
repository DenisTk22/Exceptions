package lecture_2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// Checked Exceptions требуют обязательной обработки, иначе код не запустится. Контролируется самой программой
public class CheckedExceptions {
    public static void main(String[] args) {
//        FileReader test = new FileReader("test"); // данный код проверяется программой и не запустится без обработки
        FileReader test = null;
        try {
            test = new FileReader("C:/Users/Denis/Desktop/Обучение GB/2_programmer/workshop/web/hjhj.jpeg"); //если навести на ошибку Java сама подскажет нужно исключение
//            test.read();
        } catch (RuntimeException | IOException e) { //можно написать верхнеуровневый тип исключения: Exception. Можно объединить несколько исключений
            System.out.println("catch exception: " + e.getClass().getSimpleName());
            throw new RuntimeException(e);
        } finally { // выполняется вне зависимости было исключение или нет
            System.out.println("finally start");
            if (test != null) {
                try {
                    test.close();
                } catch (IOException e) {
                    System.out.println("exception while close");;
                }
            }
            System.out.println("finally finished");
        }
    }
}

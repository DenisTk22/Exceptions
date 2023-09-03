package lecture_3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
// использование try-with-resources - автоматически закрывает работу с ресурсом
public class Application {
    public static void main(String[] args) {
//        FileReader test = null;
        try (FileReader reader = new FileReader("F:/WWW/CSS ссылки.txt"); // /hjhj.jpeg
            FileWriter writer = new FileWriter("test")) { //инициализация файла происходит в try(_), тогда данный ресурс будет обязательно закрыт по окончанию try
//            test.read(); // не нужен при копировании одного файла в другой
//            test = new FileReader("C:/Users/Denis/Desktop/Обучение GB/2_programmer/workshop/web/hjhj.jpeg");
            while (reader.ready()) {
               writer.write(reader.read()); // копирование содержание одного файла CSS ссылки.txt в другой файл test
            }
        }
        catch (RuntimeException | IOException e) {
            System.out.println("catch exception: " + e.getClass().getSimpleName());
        }
        System.out.println("Copy successfully");
//        finally {
//            System.out.println("finally start");
////            if (test != null) {
////                try {
////                    test.close();
////                } catch (IOException e) {
////                    System.out.println("exception with close");
////                }
////            }
//            System.out.println("finally finished");
//        }
    }
}

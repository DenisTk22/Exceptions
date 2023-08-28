package lecture_1;

import java.io.File;

public class Application {
    public static void main(String[] args) {
        //System.out.println(getFileSize(new File ("C:/Users/Denis/Desktop/Обучение GB/2_programmer/workshop/web/hjhj.jpeg")));
        System.out.println(divide(10,0));
//        int[] ints = new int[10];
//        System.out.println(ints[1000]);
    }

    public static int divide(int a1, int a2) {
        if (a2 == 0) {
            throw new RuntimeException("Делить на ноль нельзя!");
        }
        return a1/a2;
    }
    public static long getFileSize(File file) { // long - возвращает размер файла
        if (!file.exists()) {
            return -1;
        }
        return file.length();
    }

}

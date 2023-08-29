package lecture_2;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        //NullPointer Exception
//        String name = null;
//        System.out.println(name.length());

        //ClassCastException
//        Object object = new String("123");
//        File file = (File) object;
//        System.out.println(file);

        //NumberFormatException
//        String number = "123fr";
//        int res = Integer.parseInt(number);
//        System.out.println(res);

        //UnsupportedOperationException
        List<Object> emptyList = Collections.emptyList();
        emptyList.add(new Object());


    }
}

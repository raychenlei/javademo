package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenlei
 * @version 1.0
 * @description
 * @date 2021/4/1 2:27 PM
 **/
public class BookTest {
    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();
        list.add(new MathBook());

//        List<Book> list2 = new ArrayList<>(MathBook);
//        List<MathBook> list3 = new ArrayList<>(Book);

        Book book = new MathBook();
        System.out.println(list);


        List<Book> list4 = new ArrayList<>();
        list4.add(new MathBook());
        list4.add(new MathBook());
        list4.add(new Book());
        Class aClass2 = list4.get(2).getClass();
        Class aClass0 = list4.get(0).getClass();
        System.out.println("aClass2:" + aClass2.getName());
        System.out.println("aClass0:" + aClass0.getName());

    }
}

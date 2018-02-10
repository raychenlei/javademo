package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenlei10
 * @Date 2018/1/31 11:33
 */
public class ListTest {
    public void delete(){
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);



        for (Integer element : list1) {
            list1.remove(0);
        }

        for (int i = 0; i < list1.size(); i++) {
            //

        }

    }

    public static void main(String[] args) {
        System.out.println("hello");


    }
}

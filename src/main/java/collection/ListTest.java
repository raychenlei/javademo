package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenlei10
 * @date 2018/1/31 11:33
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
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Object> collect = list1.stream().filter(t -> t.intValue() > 3).collect(Collectors.toList());
        System.out.println(collect.size());

    }
}

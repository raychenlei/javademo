package demo;

import java.util.Arrays;

/**
 * @Author chenlei10
 * @Date 2018/2/9 17:37
 */
public class MyTest {
    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1,2,3,4,5);
//
//        List<Integer> collect = list.stream().filter(t -> t > 5).collect(Collectors.toList());
//        System.out.println(collect.size());

        int[] array = {6,1 ,2 ,7,  9,  3,  4,  5, 10,  8};
        quickSort(array,0,9);
        System.out.println(Arrays.toString(array));

    }

    public static void quickSort(int[] array, int i, int j){

        int index = i;
        int p = array[i];

        while (i<j){
            while (array[j] > p) {j--;}

            while (array[i] <= p) {i ++;}

            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            System.out.println(Arrays.toString(array));
        }

        int temp = array[index];
        array[index] = array[i];
        array[i] = temp;

        quickSort(array, 0,i-1);
        quickSort(array, j+1, array.length-1);
    }
}

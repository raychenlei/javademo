package algorithm;

import java.util.Arrays;

/**
 * @Author chenlei10
 * @Date 2018/3/1 11:28
 */
public class Sort {

    public static void main(String[] args) {

        int[] array = {6, 1, 2, 7, 5, 3, 4, 9, 10, 8};
        int[] array2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] array3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        quickSort2(array, 0, 9);
        quickSort(array3, 0, 9);
        System.out.println(Arrays.toString(array3));

    }

    /**
     * 快速排序1
     * 基于分治的思想，选取一个点作为基准值（比如第一个），从最右端开始往前找第一个小于基准的数，从最左端j开始往后找到第一个大于基准的数，然后交换这两个数
     * 重复这个过程，直到i和j相遇，然后把基准数和i交换，这样基准数左边都是比他小的数，右边都是比他大的数
     * 递归的对左边和右边进行排序
     *
     * @param array
     * @param low
     * @param high
     */
    public static void quickSort(int[] array, int low, int high) {

        if (high <= low) {
            //退出机制
            return;
        }
        int i = low;
        int j = high;

        int key = array[i];
        while (i < j) {
            while (array[j] > key && i < j) {
                //需要加上i<j的条件，防止和i交叉
                j--;
            }
            while (array[i] <= key && i < j) {
                i++;
            }
            //交换i和j的值
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            System.out.println(Arrays.toString(array));
        }

        //将基准数和i交换
        array[low] = array[i];
        array[i] = key;
//        System.out.println(Arrays.toString(array));

        quickSort(array, low, i - 1);
        quickSort(array, i + 1, high);
    }


    /**
     * 快速排序2
     * 挖坑填坑的方法
     * @param array
     * @param low
     * @param high
     */
    public static void quickSort2(int[] array, int low, int high) {
        if (high <= low) {
            //退出机制
            return;
        }
        int i = low;
        int j = high;

        int key = array[i];
        int count = 0;

        while (i < j) {
            while (array[j] > key && i < j) {
                j--;
            }
            array[i] = array[j];

//            System.out.println(Arrays.toString(array));

            while (array[i] <= key && i < j) {
                i++;
            }
            array[j] = array[i];
//            System.out.println(Arrays.toString(array));

            count++;
        }

        array[i] = key;
        System.out.println(Arrays.toString(array));

        quickSort2(array, low, i - 1);
        quickSort2(array, i + 1, high);
    }

}

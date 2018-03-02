package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");

//        String[] a = new String[args.length];
//        String[] newArray = list.toArray(a);
//
//        System.out.println(a == newArray);

        int[] a = {1,3};
        int[] b = {2};
        System.out.println(findMedianSortedArrays(a,b));

    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] num = new int[ n+ m];
        for(int i=0,j=0,k=0;i<m || j<n;){

            if(nums1[i]<nums2[j]){
                num[k] = nums1[i];
                i++;
                k++;
                if (i == m) {
                    while (j<n){
                        num[k] = nums2[j];
                        j++;
                        k++;
                    }
                }
            }else{
                num[k] = nums2[j];
                j++;
                k++;
                if (j == n) {
                    while (j<n){
                        num[k] = nums1[i];
                        i++;
                        k++;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(num));

        int index = (int) (m+n)/2;

        if((m+n)%2==0){
            return (double)(num[index] + num[index-1])/2;
        }else{
            return (double)num[index];
        }
    }


}

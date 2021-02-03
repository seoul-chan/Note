package Algorithm;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {10,1,30,40,53,22,65,70,90};
        int temp, prev;
        System.out.println("Before Insertion Sort : " + Arrays.toString(arr));
        for (int i=1;i<arr.length;i++) {
            temp = arr[i];
            prev = i-1;

            while((prev>=0)&&(arr[prev]>temp)){
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1]=temp;
        }
        System.out.println("After Insertion Sort : " + Arrays.toString(arr));
    }
}

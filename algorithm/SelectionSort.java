package Algorithm;

import java.util.Arrays;

public class SelectionSort {
   public static void main(String[] args) {
       int arr[] = {10,1,30,40,53,22,65,70,90};
       int temp,indexMin;

       System.out.println("Before Selection Sort : " + Arrays.toString(arr));
       for (int i=0;i<arr.length;i++) {
           indexMin = i;
           for (int j=i+1;j<arr.length;j++) {
               if(arr[j]<arr[indexMin]){
                    indexMin = j;
               }
           }
           temp = arr[i];
           arr[i] = arr[indexMin];
           arr[indexMin] = temp;
       }
       System.out.println("After Selection Sort : " + Arrays.toString(arr));
   } 
}

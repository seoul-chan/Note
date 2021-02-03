package Algorithm;

import java.util.Arrays;

public class MergeSort {
    //1.
    private static void mergeSort(int[] arr){
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length-1);
    }
    //2.
    private static void mergeSort(int[] arr, int[] temp, int start, int end){
        if (start < end){
            int mid = (start+end)/2;    //3.
            mergeSort(arr, temp, start, mid);   //4.
            mergeSort(arr, temp, mid+1, end);   //5.
            merge(arr, temp, start, mid, end);  //6.
        }
    }
    
    private static void merge(int[] arr, int[] temp, int start, int mid, int end){
         for(int i=start; i<=end;i++){
            temp[i] = arr[i];   //7. 
         }
         int part1 = start;     //8.
         int part2 = mid+1;
         int index = start;
         while (part1<=mid && part2<=end){  //9.
             if(temp[part1]<=temp[part2]){  //10. 
                 arr[index] = temp[part1];
                 part1++;
             } else {
                 arr[index] = temp[part2];  //11.
                 part2++;
             }
             index++;
         }
         //12. 
        for(int i=0;i<=mid-part1;i++){
            arr[index+i]=temp[part1+i];
        }
    }

    public static void main(String[] args) {
        int[] arr={3,9,4,7,5,0,1,6,8,2};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
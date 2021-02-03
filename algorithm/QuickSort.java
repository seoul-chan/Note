package Algorithm;

import java.util.Arrays;

public class QuickSort {
    private static void quicksort(int[] arr){
        quicksort(arr,0,arr.length-1);    
    }

    private static void quicksort(int[] arr, int start, int end){
        int part2_start = partition(arr, start, end);

        if(start<part2_start-1){
            quicksort(arr, start, part2_start-1);
        }
        else if(part2_start<end){
            quicksort(arr, part2_start, end);
        }
    }

    private static int partition(int[] arr, int start, int end){
        int pivot = arr[(start+end)/2];

        while (start<=end){
            while(arr[start]<arr[pivot]) start++;
            while(arr[end]>arr[pivot]) end--;
    
            if(start<=end){
                sort(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void sort(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,9,4,7,5,0,1,6,8,2};

        System.out.println("Before Quick Sort : " + Arrays.toString(arr));
        quicksort(arr);
        System.out.println("After Quick Sort : " + Arrays.toString(arr));
    }
}
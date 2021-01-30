package codingTest;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        
        for(int i=0;i<arr.length;i++) {
        if(arr[i]%divisor==0) {
        	arrlist.add(arr[i]);
         }
       }
        
        if(arrlist.size()==0) {
        	int[] answer = {-1};
        	return answer;
        }
        
        int[] answer = new int[arrlist.size()];
        for(int i=0;i<arrlist.size();i++) {
        	answer[i]=arrlist.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] arr  = {3,2,6};
    	int divisor = 10;
    	System.out.println(Arrays.toString(sol.solution(arr,divisor)));
    }
}
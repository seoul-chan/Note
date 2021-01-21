package CodingTest;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int count = 0,two=0;
        for(int i=0;i<arr.length;i++) {
        	if(arr[i]%divisor==0) count++;
        }
        
        if(count==0) {
        	int[] answer = {-1};
        	return answer;
        }
        
        int[] answer = new int[count];
        for(int i=0;i<arr.length;i++) {
        	if(arr[i]%divisor==0) answer[two++]=arr[i];
        }
        Arrays.sort(answer);
        return answer;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] arr  = {2,36,1,3};
    	int divisor = 1;
    	System.out.println(Arrays.toString(sol.solution(arr,divisor)));
    }
}

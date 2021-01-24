package codingTest;

import java.util.Arrays;

//프로그래머스 Level 1 - 같은 숫자는 싫어
public class Solution {
    public int[] solution(int []arr) {
        int prev=1;
        
        for(int i=0;i<arr.length-1;i++) {
        	if(arr[i]!=arr[i+1]) prev++; 
        }
        
        int[] answer = new int[prev];
        prev=1;
        answer[0]=arr[0];
        for(int i=0;i<arr.length-1;i++) {
        	if(arr[i]!=arr[i+1]) answer[prev++]=arr[i+1];
        }
        return answer;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] arr = {5000,56222,56222,8888,8999};
    	
    	System.out.println(Arrays.toString(sol.solution(arr)));
    }
}
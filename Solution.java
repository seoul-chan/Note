package codingTest;

import java.util.ArrayList;
import java.util.Arrays;

//프로그래머스 Level 1 - 같은 숫자는 싫어
public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        int prev=10;
        
        for(int i=0;i<arr.length;i++) {
        	if(prev!=arr[i]) arrlist.add(arr[i]);
        	prev = arr[i];
        }
        
        int[] answer = new int[arrlist.size()];
        for(int i=0;i<answer.length;i++) {
        	answer[i]=arrlist.get(i);
        }
        return answer;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] arr = {1,1,3,3,0,1,1};
    	
    	System.out.println(Arrays.toString(sol.solution(arr)));
    }
}
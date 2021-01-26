package codingTest;

import java.util.Arrays;

//프로그래머스 Level 1 - 문자열 내 마음대로 정렬하기
class Solution {
    public String[] solution(String[] strings, int n) {
    	
    	for(int i=0;i<strings.length;i++) {
    		for(int j=i+1;j<strings.length;j++) {
    			if(strings[i].charAt(n)>strings[j].charAt(n)) {
	    			String temp = strings[i];
	    			strings[i] = strings[j];
	    			strings[j] = temp;
	    			
        		} else if(strings[i].charAt(n)==strings[j].charAt(n)) {
        			if(strings[i].compareTo(strings[j])>0) {
        				String temp = strings[i];
    	    			strings[i] = strings[j];
    	    			strings[j] = temp;
        			}
        		}
    		}
    	}
        return strings;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	String[] answer = {"sun","bed","car"};
    	
    	System.out.println(Arrays.toString(sol.solution(answer,1)));
    }
}
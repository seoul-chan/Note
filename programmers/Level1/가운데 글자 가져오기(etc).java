package codingTest;

class Solution {
    public String solution(String s) {

        return s.substring((s.length()-1)/2,s.length()/2+1);
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	String str = "abcde";
    	
    	System.out.println(sol.solution(str));    	
    }
}
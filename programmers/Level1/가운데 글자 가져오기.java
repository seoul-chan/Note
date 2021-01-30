package codingTest;

class Solution {
    public String solution(String s) {
        String answer = "";
        int index = s.length()/2;

        if(s.length()%2==0) {
        	answer+=s.charAt(index-1);
        	answer+=s.charAt(index);
        } else {
        	answer+=s.charAt(index);
        }
        return answer;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	String str = "abcde";
    	
    	System.out.println(sol.solution(str));    	
    }
}
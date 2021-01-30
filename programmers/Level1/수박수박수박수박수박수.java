package codingTest;

class Solution {
    public String solution(int n) {
    	String answer = "";
    	
	for(int i=0;i<n;i++) {
    		answer += (i%2==0)?"수":"박";
    	}
    	
        return answer;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int count = 10;
    	System.out.println(sol.solution(count));
    	
    	
    }
}
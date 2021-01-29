package codingTest;

//프로그래머스 Level 1 - 약수의 합
class Solution {
    public int solution(int n) {
    	int answer = 0;
    	for(int i=1;i<=n;i++) {
    		answer=(n%i==0)?answer+=i:answer;
    	}
        
        return answer;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.solution(5));
    }
}
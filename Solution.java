package CodingTest;

// 프로그래머스 Level 1 - 두 정수 사이의 합
class Solution {
    public long solution(int a, int b) {
        int max=(a>b)?a:b,
        	min=(a<b)?a:b;
        long answer=0;
        
        if(a==b) return a;
        for(int i=min;i<=max;i++) {
        	answer+=i;
        }
        return answer;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int a = 5;
    	int b = 6;
    	System.out.println(sol.solution(a, b));
    }
}

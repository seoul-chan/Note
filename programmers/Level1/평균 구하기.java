package codingTest;

class Solution {
	 public double solution(int[] arr) {
	        int sum = 0;
	        for(int i : arr) sum+=i;
	        return (double)sum/arr.length;
	    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] arr = {1,2,3,4};
		System.out.println(sol.solution(arr));
	}
}
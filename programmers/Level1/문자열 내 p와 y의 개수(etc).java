package codingTest;

class Solution {
	public boolean solution(String s) {
		s = s.toLowerCase();
		int count=0;
		
		for(int i=0;i<s.length();i++) {
			// solution 1
//			if(s.charAt(i)=='p') count++;
//			if(s.charAt(i)=='y') count--;		
			// solution 2
			switch(s.charAt(i)) {
				case 'p' : count++; break;
				case 'y' : count--; break;
			}
		}
		if(count!=0) return false;
		return true;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("Pyy"));
	}
}
package codingTest;

class Solution {
	public boolean solution(String s) {
		int pcount=0, ycount=0;
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='p' || s.charAt(i)=='P') pcount++;
			if(s.charAt(i)=='y' || s.charAt(i)=='Y') ycount++;
		}
		
		if(pcount!=ycount) return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("Pyy"));
	}
}
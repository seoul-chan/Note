package CodingTest;

class Solution {
    public int solution(String s) {
        int answer = 0, sum = 0;
        boolean plus = true;
        
        for(int i=0;i<s.length();i++) {
        	if(s.charAt(i)=='-') {
        		plus = false;
        	}
        	else {
        		int k = s.charAt(i)-48;
            	sum = k + sum * 10;
        	}
        }
        return (plus==true)?sum:-1*sum;
    }
    
    public static void main(String[] args) {
		Solution so = new Solution();
		System.out.println(so.solution("6789"));
	}
}

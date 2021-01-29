package codingTest;

import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> hash = new HashMap<String,Integer>();
        //1. 
        for (String string : participant) {
            if(hash.get(string)==null){
                hash.put(string, 1);
            } else {
                int val = hash.get(string) + 1;
                hash.put(string, val);
            }
        }
        //2. 
        for (String comp : completion) {
            hash.put(comp, hash.get(comp)-1);
        }
        //3. 
        for (String part : participant) {
            if(hash.get(part)==1){
                return part;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Solution result = new Solution();
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa","filipa", "marina","nikola"};
        
        System.out.println(result.solution(participant, completion));
    }
}

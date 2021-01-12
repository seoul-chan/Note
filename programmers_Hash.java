package CodingTest;

import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> hash = new HashMap<String,Integer>();
        
        for (int i = 0; i < participant.length; i++) {
            if(hash.get(participant[i])==null){
                hash.put(participant[i], 1);
            }
            else {
                int val = hash.get(participant[i])+1;
                hash.put(participant[i], val);
            }
        }

        for (String comp : completion) {
            hash.put(comp,hash.get(comp)-1);
        }
        
        for (String part : participant) {
            if(hash.get(part)==1){
                return part;
            }
        }
        return " ";
    }
}

public class programmers_Hash {
    public static void main(String[] args) {   
        Solution loss = new Solution();

        String[] participant={"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        System.out.println(loss.solution(participant,completion));
    }
}

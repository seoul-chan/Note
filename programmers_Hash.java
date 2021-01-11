package CodingTest;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        for(int i=0;i<participant.length;i++){
            for(int j=0;j<completion.length;j++){
                if(participant[i].equals(completion[j])){
                   participant[i]=" ";
                    completion[j]=" ";
                    continue;             
                }
            }
        }

        for(int i=0;i<participant.length;i++){
            if(!(participant[i].equals(" "))){
                return participant[i];
            }
        }
        return "";
    }
}

public class programmers_Hash {
    public static void main(String[] args) {
        Solution loss = new Solution();
        // String[] participant={"marina", "josipa", "nikola", "vinko", "filipa"};
        // String[] completion = {"josipa","filipa","marina","nikola"};

        String[] participant={"misiav","stanko","mislav","ana"};
        String[] completion = {"stanko","ana","mislav"};

        System.out.println(loss.solution(participant,completion));
    }
}

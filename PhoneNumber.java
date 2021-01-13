package CodingTest;

import java.util.Arrays;

public class PhoneNumber {
    static boolean solution(String[] phone_book){
        boolean answer = true;
        Arrays.sort(phone_book);

        for (int i=1;i<phone_book.length;i++) {     
            if(phone_book[i].indexOf(phone_book[0])==0){
                answer = false;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] phone_book = {"119","97674223","1195524421"};
        System.out.println(solution(phone_book));
    }
}

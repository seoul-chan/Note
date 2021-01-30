package codingTest;

import java.util.Arrays;

class Solutions {
    public int[] solutions(int[] array, int[][] commands){
        int[] answer = new int[commands.length];

        for(int i=0;i<commands.length;i++){
        	// 배열의 일부를 선택하여 복사
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }
        return answer;
    }
}


public class kNumber {
    public static void main(String[] args) {
        Solutions returns = new Solutions();
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};

        System.out.println(Arrays.toString(returns.solutions(array, commands)));

    }
}

package codingTest;

import java.util.ArrayList;
import java.util.Arrays;

class Solutions {
    public int[] solutions(int[] array, int[][] commands){
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i=0;i<commands.length;i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int[] temp = new int[(end-start)+1]; // 1.
            
            int k=0;
            for(int j=start-1;j<end;j++){     // 2.
                temp[k] = array[j];
                k++;
            }
            Arrays.sort(temp); // 3.
            list.add(temp[commands[i][2]-1]); // 4.
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
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
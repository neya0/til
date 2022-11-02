package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q13 {
    public static void main(String[] args) {
        Q13 go = new Q13();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println("go = " + Arrays.toString(go.solution(array, commands)));
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        // 일단 조건의 첫번째가 무엇인지 파악하고
        // 그 다음 수까지 array의 수를 다른 배열에 넣고
        // 마지막 인덱스의 수를 구하기

        List<Integer> result = new ArrayList<>();
        for(int arr = 0; arr < commands.length; arr++ ){
            for(int start = commands[arr][0]-1; start < commands[arr][1]; start++){
                result.add(array[start]);
                System.out.println("result = " + result);
            }
            Collections.sort(result);
            answer[arr] = result.get(commands[arr][2]-1);
            result = new ArrayList<>();
        }

        return answer;
    }
}

package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Q22 {
    public static void main(String[] args) {
        Q22 go = new Q22();
        System.out.println("go.solution(10, 2) = " + Arrays.toString(go.solution(10, 2)));
        System.out.println("go.solution(10, 2) = " + Arrays.toString(go.solution(8, 1)));
        System.out.println("go.solution(10, 2) = " + Arrays.toString(go.solution(24, 24)));
        System.out.println("go.solution(10, 2) = " + Arrays.toString(go.solution(12, 4)));
        System.out.println("go.solution(10, 2) = " + Arrays.toString(go.solution(36, 64)));
    }
//
//    public int[] solution(int brown, int yellow) {
//        int[] answer = new int[2];
//
//        int total = brown + yellow;
//
//        for(int i = 1; i <= yellow; i++){
//            int mok = yellow / i;
//            int sum = (mok + 2) * (i + 2);
//            if(sum == total){
//                if(sum - yellow == brown){
//                    answer[1] = mok + 2;
//                    answer[0] = i + 2;
//                }
//                break;
//            }
//        }
//
//        return answer;
//    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int total = brown + yellow;

        for(int i = 1; i < brown; i ++){
            int brownBlock = (2 * (total / i)) + (2 * i) - 4;
            if(brownBlock == brown){
                int width = total / i;
                if((width - 2) * (i - 2) == yellow){
                    answer[0] = width;
                    answer[1] = i;
                    break;
                }
            }
        }

        return answer;
    }
}

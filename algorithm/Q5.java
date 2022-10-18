package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q5 {
//    public String[] solution(int n, int[] arr1, int[] arr2) {
//        String[] answer = new String[n];
//
//        int[][] binary1 = new int[n][n];
//        int[][] binary2 = new int[n][n];
//        // 10진수를 2진수로 변경
//        for(int i = 0; i < n; i++){
//            int num = arr1[i];
//            int b = 0;
//            while ( num != 0 ){
//                if(num < 1){
//                    break;
//                }
//                binary1[i][b] = num % 2;
//                num = num/2;
//                b++;
//            }
//        }
//        for(int i = 0; i < n; i++){
//            int num = arr2[i];
//            int b = 0;
//            while ( num != 0 ){
//                if(num < 1){
//                    break;
//                }
//                binary2[i][b] = num % 2;
//                num = num/2;
//                b++;
//            }
//        }
//
//        StringBuilder str = new StringBuilder();
//        for(int x = 0; x < n; x++){
//            for(int y = 0; y < n; y++){
//                if((binary1[x][y] == 1 && binary2[x][y] == 1) || (binary1[x][y] == 0 && binary2[x][y] == 1) || (binary1[x][y] == 1 && binary2[x][y] == 0)){
//                    str.append("#");
//                }else{
//                    str.append(" ");
//                }
//            }
//            str.reverse();
//            answer[x] = String.valueOf(str);
//            str = new StringBuilder("");
//        }
//
//
//        return answer;
//    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        char[][] charArr = new char[n][n];

        List<Integer> binary = new ArrayList<>();
        for(int i = 0; i < n; i++){
            binary.add(arr1[i] | arr2[i]);
        }
        for (int num = 0; num < n; num++){
             String str = Integer.toBinaryString(binary.get(num));
             char[] chars = str.toCharArray();
             char[] chars2 = new char[n];
             if(chars.length < n){
                 chars2[0] = "0".charAt(0);
                 for(int c = 1; c <= chars.length; c++){
                     chars2[c] = chars[c-1];
                 }
                 charArr[num] = chars2;
             }else{
                 charArr[num] = chars;
             }
        }
        System.out.println("charArr.toString() = " + Arrays.deepToString(charArr));
        for(int x = 0; x < n; x++){
            for(int y = 0; y < n; y++){
                if(charArr[x][y] == "1".charAt(0)){
                    charArr[x][y] = "#".charAt(0);
                }else{
                    charArr[x][y] = " ".charAt(0);
                }
            }
            String str = new String(charArr[x]);
            System.out.println("str = " + str);
            answer[x] = str;
        }

        return answer;
    }

    public static void main(String[] args) {
        Q5 go = new Q5();
        int n = 6;
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};
        System.out.println(Arrays.toString(go.solution(n, arr1, arr2)));
    }
}

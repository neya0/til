package algorithm;

import javax.swing.*;
import java.util.*;

public class Q7 {

    // 해시를 안 쓰고 내가 짠 로직
    // 접두어 검사라서 contains()가 아닌 무엇을 시작하는지 체크하는 startsWith()가 사용되어야 맞다.
    public boolean solution(String[] phone_book) { // 효율성 - (245.89ms, 99.3MB)
        boolean answer = true;

        List<String> list = new ArrayList<>(Arrays.asList(phone_book));
        Collections.sort(list);

        for(int i = 1; i < list.size(); i++){
            if(list.get(i).startsWith(list.get(0))) {
                answer = false;
                break;
            }else if(list.get(i).startsWith(list.get(i-1))){
                answer = false;
                break;
            }
        }

        return answer;
    }

    // 해시를 쓰고 내가 짠 로직
    public boolean solution2(String[] phone_book) { //11, 14번 통과 못함
        boolean answer = true;
        List<String> list = new ArrayList<>(Arrays.asList(phone_book));
        Collections.sort(list);

        HashSet<String> hashSet = new HashSet<>();

        int first = list.get(0).length();
        for(int i = 0; i < list.size(); i++){
            if(hashSet.size() < 1 || first > list.get(i).length()){
                hashSet.add(list.get(i));
                first = list.get(i).length();
            }else{
                hashSet.add(list.get(i).substring(0,first));
            }
        }

        if(list.size() != hashSet.size()) answer = false;

        return answer;
    }

    // 다른 사람 로직
    public boolean solution3(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < phone_book.length ; i++)
            map.put(phone_book[i],i);

        for(int i = 0 ; i < phone_book.length ; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                System.out.println(phone_book[i].substring(0, j));
                if (map.containsKey(phone_book[i].substring(0, j))) return false;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Q7 go = new Q7();
        System.out.println("solution: 1 = " + go.solution3(new String[]{"119", "97674223", "1195524421"}));
//        System.out.println("solution: 2 = " + go.solution2(new String[]{"123","456","789"}));
//        System.out.println("solution: 2 = " + go.solution2(new String[]{"123","456","789","2123"}));
//        System.out.println("solution: 2 = " + go.solution2(new String[]{"1","456","789","2123", "13456"}));
//        System.out.println("solution: 3 = " + go.solution2(new String[]{"12","123","1235","567","88"}));
    }
}

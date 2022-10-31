package algorithm;

import java.util.*;

public class Q10 {
    public static void main(String[] args) {
        Q10 go = new Q10();
        System.out.println("go.solution() >> 1 = " + go.solution("3people unFollowed me"));
        System.out.println("go.solution() >> 2 = " + go.solution("aaaaa  aaa"));
        System.out.println("go.solution() >> 3 = " + go.solution("a aa "));
    }

    // 전부 소문자로 만들고
    // 자른 뒤에
    // 맨 앞은 무조건 대문자로 만들고
    // 맨 마지막이 공백이면 그냥 끝나고
    // 중간에 공백이 있으면 그 다음을 대문자로 만들어 그 자리에 대신 넣고 기존 거를 지운다.
    // 모든 문자를 StringBuilder로 합쳐준다.
    public String solution(String s) {
        s = s.toLowerCase(Locale.ROOT);

        LinkedList<String> list = new LinkedList<>(Arrays.asList(s.split("")));
        StringBuilder builder = new StringBuilder();
        String srt = list.get(0).toUpperCase(Locale.ROOT);
        builder.append(srt);
        for(int i = 1; i < list.size(); i++){
            builder.append(list.get(i));
            if(i == list.size()-1){
                break;
            }
            if(list.get(i).equals(" ")){
                srt = list.get(i+1).toUpperCase(Locale.ROOT);
                list.add(i+1,srt);
                list.remove(i+2);
            }
        }
        System.out.println("list = " + list);

        return builder.toString();
    }
}

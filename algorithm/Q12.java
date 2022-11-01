package algorithm;

import java.util.*;

public class Q12 {
    public static void main(String[] args) {
        Q12 go = new Q12();
        System.out.println("go.solution() = " + go.solution("()()"));
        System.out.println("go.solution() = " + go.solution("(())()"));
        System.out.println("go.solution() = " + go.solution(")()("));
        System.out.println("go.solution() = " + go.solution("(()("));
    }
    boolean solution(String s) {

        // stack에 하나씩 true, false로 집어넣기
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        if(stack.size() != 0){
            return false;
        }

        return true;
    }
}

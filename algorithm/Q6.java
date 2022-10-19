package algorithm;

import java.util.*;

public class Q6 {

    // 내가 생각한 로직으로 풀어보기
    public int solution(int[] nums) { // 제일 느린 것 - (15.85ms, 81.5MB)
        int answer = 1;

        List<Integer> sortList = new ArrayList<>();
        for (int num : nums) {
            sortList.add(num);
        }
        Collections.sort(sortList);

        // 앞의 놈과 뒤의 놈을 비교해서 서로 다르면 올리기
        for(int i = 1; i < sortList.size(); i++){
            if(!sortList.get(i-1).equals(sortList.get(i)) && answer < nums.length/2){
                answer++;
            }
        }
        return answer;
    }

    //해시로 풀어보기
    public int solution2(int[] nums) { // 제일 느린 것 - (11.94ms, 69.4MB)
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        HashSet<Integer> hashSet = new HashSet<>(list);

        if(hashSet.size() < nums.length/2){
            answer = hashSet.size();
        }else{
            answer = nums.length/2;
        }

        return answer;
    }

    public static void main(String[] args) {
        Q6 go = new Q6();
        System.out.println("solution: 1 = " + go.solution2(new int[]{3, 1, 2, 3}));
        System.out.println("solution: 2 = " + go.solution2(new int[]{3,3,3,2,2,4}));
        System.out.println("solution: 3 = " + go.solution2(new int[]{3,3,3,2,2,2}));
    }
}

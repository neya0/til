package algorithm;

import java.util.*;

public class Q24 {

    public static void main(String[] args) {
        Q24 go = new Q24();
        System.out.println("go.solution() = " + go.solution(new int[]{1,1}, 3));
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> spicy = new PriorityQueue<>();
        for(int num : scoville){
            spicy.add(num);
        }

        for(int i = 0; i < scoville.length; i++){
            if(spicy.peek() > K){
                break;
            }else if(spicy.size() < 2){
                return -1;
            } else if(spicy.peek() < K){
                int first = spicy.poll();
                int next = spicy.poll();
                int hope = first + (next * 2);
                spicy.add(hope);
                answer++;
            }
        }

        return answer;
    }

    public int solution2(int[] scoville, int K) {// while 문을 사용해 볼걸...
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i = 0; i < scoville.length; i++)
            q.add(scoville[i]);

        int count = 0;
        while(q.size() > 1 && q.peek() < K){
            int weakHot = q.poll();
            int secondWeakHot = q.poll();

            int mixHot = weakHot + (secondWeakHot * 2);
            q.add(mixHot);
            count++;
        }

        if(q.size() <= 1 && q.peek() < K)
            count = -1;

        return count;
    }
}

package algorithm;

import java.util.*;

//실제로 풀지 못했고 로직도 잘 생각 나지 않았다.
//로직 자체가 떠오르지 않아서 하루를 날렸는데 다른 분의 풀이를 보니 내가 너무 어렵게 생각했나 싶기도 하다.
//단순하게 전체 경우의 수를 곱해서 구한 뒤 거기서 -1를 해서 구하는 방식을 다들 다양하게 풀이했다.
// 나도 전체 경우의 수를 구해야겠다는 생각은 했지만 그걸 로직으로 녹여내지 못했고 구현도 못했다.
// 갈 길이 멀구나...

public class Q11 {
    public static void main(String[] args) {
        Q11 go = new Q11();
        String[][] ss = {{"a", "headgear"}, {"b", "headgear"}, {"c", "eyewear"}, {"d", "eyewear"}, {"e", "face"}, {"f", "face"}};
        System.out.println("go.solution() = " + go.solution2(ss));
    }

    public int solution2(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> total = new HashMap<>();
        for(int i=0; i<clothes.length; i++) {
            total.put(clothes[i][1],total.getOrDefault(clothes[i][1],1)+1);
            System.out.println("total = " + total);
        }
        Collection<Integer> test = total.values();
        answer = test.stream().reduce(1, (a, b) -> a*b) - 1;
        return answer;
    }

    public int solution(String[][] clothes) {
        int answer = 0;

        HashMap<String, List<String>> mClothers = new HashMap();
        for(int i=0; i< clothes.length; i++) {
            String[] clothesType = clothes[i];
            if(null == mClothers.getOrDefault(clothesType[1], null)) {
                List<String> arrayClother = new ArrayList<>();
                arrayClother.add(clothesType[0]);
                mClothers.put( clothesType[1], arrayClother);
            } else {
                List<String> arrayClother = mClothers.get( clothesType[1] );
                arrayClother.add(clothesType[0]);
            }
        }

        Iterator it = mClothers.keySet().iterator();
        while (it.hasNext()) {
            String sKey = (String) it.next();
            int arrayClotherSize = mClothers.get(sKey).size();
            arrayClotherSize++; //현재 옷종류 미착용상태 경우의 수 한개 추가
            if(answer == 0) {
                answer = arrayClotherSize;
            } else {
                answer *= arrayClotherSize;
            }

        }

        answer--; //모든 복장 미착용인 경우 한개 제외
        return answer;
    }

}

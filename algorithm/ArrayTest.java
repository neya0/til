package algorithm;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        ArrayTest test = new ArrayTest();
        System.out.println("test.tryTest(\"Hello World\") = " + test.tryTest("Hello World"));
    }
/*
* 넣고자 하는 데이터가 배열의 크기를 넘어가면 어떤 일이 생길까?
* 당연히 ArrayIndexOfBoundsException이 발생한다.
*
* 그렇다면 해결 방법은?
* 동적 배열인 List 나 LinkedList를 사용하여 데이터의 크기에 맞춰 자유롭게 넣을 수 있다.*/
    public String tryTest(String s){
        char[] chars = s.toCharArray();
        String[] sList = new String[s.length()-2];
        int index = 0;

        for(char word : chars){
            sList[index] = String.valueOf(word);
            System.out.println("sList = " + Arrays.toString(sList));
            index++;
        }
        return s;
    }
}

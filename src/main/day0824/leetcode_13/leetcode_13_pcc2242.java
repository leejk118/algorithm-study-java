package main.day0824.leetcode_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class leetcode_13_pcc2242 {
    /**
     * https://leetcode.com/problems/roman-to-integer/
     *
     * 13. Roman to Integer
     * Given a roman numeral, convert it to an integer.
     */


    private static HashMap<Character, Integer> map = new HashMap<>() {{ put('I', 1); put('V', 5); put('X', 10); put('L', 50); put('C', 100); put('D', 500); put('M', 1000); }};

    // 스트링 길이에 대해 반복문 사용 시 처음과 마지막 인덱스에 대한 처리가 까다로움
    // 12ms, 47.3MB
    public static int romanToInt1(String s) {
        int answer = 0;

        int prvNum = 0;
        int middle = 0;
        int crtNum;
        for (int i = 0; i < s.length(); i++) {
            crtNum = map.get(s.charAt(i));

//            6ms, 44.8MB
//            crtNum = getValue(s.charAt(i));

            if (i == s.length() - 1) {
                answer += prvNum < crtNum ? crtNum - middle : crtNum + middle;
                break;
            }

            if (i == 0) {
                middle = prvNum = crtNum;
                continue;
            }

            if (prvNum > crtNum) {
                answer += middle;
                middle = crtNum;
            } else if (prvNum == crtNum) {
                middle += crtNum;
            } else {
                answer += crtNum - middle;
                middle = 0;
            }

            prvNum = crtNum;
        }

        return answer;
    }
    //숫자가 큰 순서대로 문자열을 나눠서 계산하려 했지만 변수가 너무 많아짐
    public static int romanToInt2(String s) {
        int answer = 0;

        // split >> 지정한 regexp 뒤에 문자열이 존재하지 않으면 공백은 배열로 반환하지 않음
        // "AABA".split("A") = [, , B]
        // "AABAAAA".split("A") = [, , B]

        for (String a : new String[]{"M", "D", "C", "L", "X", "V", "I"}) {
            if (s.length() == 0) {
                break;
            }

            if (!s.contains(a)) {
                continue;
            }

            String[] arr = s.split(a);

            if (arr.length == 1) {
                answer += map.get(a.charAt(0));
                answer -= arr[0].length() > 0 ? arr[0].length() * map.get(arr[0].charAt(0)) : 0;
                break;
            }

            if (arr.length == 0) {
                answer += map.get(a.charAt(0)) * s.length();
                break;
            }

            s = arr[arr.length - 1];

            for (int i = 0; i < arr.length - 1; i++) {
                answer += map.get(a.charAt(0));
                answer -= arr[i].length() > 0 ? arr[i].length() * map.get(arr[i].charAt(0)) : 0;
            }

        }
        return answer;
    }

    //12ms 47.3Mb
    public static int romanToInt3(String s){
        int answer = 0;

        char[] charArr = s.toCharArray();

        int prvNum = map.get(charArr[0]);
        //6ms 45.2MB
//        int prvNum = getValue(charArr[0]);

        for (int i = 1; i < charArr.length ; i++) {
//            int crtNum = map.get(charArr[i]);
            int crtNum = getValue(charArr[i]);

            answer += prvNum < crtNum ? -prvNum : prvNum;

            prvNum = crtNum;
        }
        answer += prvNum;

        return answer;
    }

    public static int romanToInt4(String s) {
        int len = s.length();
        int ans = 0;
        int prv = getValue(s.charAt(0));
        int cur;

        for (int i = 1; i < len; i++) {
            cur = getValue(s.charAt(i));
            if (prv < cur) {
                ans -= prv;
            } else {
                ans += prv;
            }

            prv = cur;
        }
        ans += prv;

        return ans;
    }

    private static int getValue(char ch) {
        int ans = 0;
        switch (ch) {
            case 'I':
                ans = 1;
                break;

            case 'V':
                ans = 5;
                break;

            case 'X':
                ans = 10;
                break;

            case 'L':
                ans = 50;
                break;

            case 'C':
                ans = 100;
                break;

            case 'D':
                ans = 500;
                break;

            case 'M':
                ans = 1000;
                break;

            default:
                break;
        }

        return ans;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        System.out.println(romanToInt2(s));
    }
}


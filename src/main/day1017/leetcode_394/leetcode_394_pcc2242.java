package main.day1017.leetcode_394;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


class leetcode_394_pcc2242 {
    /**
     * https://leetcode.com/problems/decode-string/
     *
     * 394. Decode String
     *
     * Given an encoded string, return its decoded string.
     * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
     * Note that k is guaranteed to be a positive integer.
     * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.
     * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
     * For example, there will not be input like 3a or 2[4].
     * The test cases are generated so that the length of the output will never exceed 105.
     *
     */


//    Runtime 2 ms Beats 64.39%
//    Memory 41.6 MB Beats 80.17%
    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();

        boolean retry = true;
        while (retry) {
            retry = false;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isAlphabetic(s.charAt(i))) {
                    sb.append(c);
                } else {
                    int count = 0;
                    int start = 0;
                    int openCount = 0;
                    int step = 1;

                    while (true) {
                        c = s.charAt(i);
                        if (Character.isDigit(c) && step == 1) {
                            count = count * 10 + (c - '0');
                        } else if (c == '[') {
                            if (step == 1) {
                                step = 2;
                                start = i + 1;
                            } else {
                                retry = true;
                            }
                            openCount++;
                        } else if (c == ']') {
                            openCount--;
                            if (openCount == 0) {
                                sb.append(s.substring(start, i).repeat(count));
                                break;
                            }
                        }
                        i++;
                    }
                }
            }

            if (retry) {
                s = sb.toString();
                sb.setLength(0);
            }
        }

        return sb.toString();
    }

    //--------------solution

    public String decodeStr_stack(String s) {
        String str = "";
        StringBuilder temp;
        Stack<String> stack_str = new Stack<>();
        Stack<Integer> stack_num = new Stack<>();
        int num = 0;
        char c = ' ';
        //a3[b2[cd]]
        // a  |  3
        // a, b | 3 , 2
        // cd
        // cdcd  // a , b | 3
        // bcdcd
        // bcdcdbcdcdbcdcd
        // a bcdcdbcdcdbcdcd
        for(int i=0; i<s.length(); i++){
            c = s.charAt(i);
            if(c =='['){
                stack_str.push(str);
                str = "";
            }
            else if(c ==']'){
                temp = new StringBuilder(stack_str.pop());
                num = stack_num.pop();
                for(int t=0; t<num; t++)
                    temp.append(str);
                str =  temp.toString();
            }
            else if(c<='9' && c>='0'){
                num = 0;
                while(c<='9' && c>='0'){
                    num = num*10+(c-'0');
                    i++;
                    c = s.charAt(i);
                }
                stack_num.push(num);
                i--;
            }
            else { //if((c>='a'&&c<='z') || (c>='A'&&c<='Z'){
                str += c;
            }
        }
        return str;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(decodeString(br.readLine()));
    }
}


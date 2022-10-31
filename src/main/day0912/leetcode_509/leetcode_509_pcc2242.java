package main.day0912.leetcode_509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class leetcode_509_pcc2242 {
    /**
     * https://leetcode.com/problems/fibonacci-number/
     *
     * 509. Fibonacci Number
     */
//    Runtime: 0 ms, faster than 100.00%
//    Memory Usage: 41.5 MB, less than 13.04%
//    시간 복잡도: O(n)
//    공간 복잡도:O(1)
    public static int fib(int n) {
        if (n < 2) {
            return n;
        }

        int m = 0;
        int k = 1;
        int t;

        for (int i = 2; i <= n; i++) {
            t = m + k;
            m = k;
            k = t;
        }

        return k;
    }

    //---------solution
//    재귀
//    Runtime: 9 ms, faster than 36.82%
//    Memory Usage: 41.6 MB, less than 9.46%
//    시간 복잡도: O(2^n)- 이후 T(n) = T(n-1) + T(n-2)는 지수 시간
//    공간 복잡도: O(n)- 재귀 함수 호출 스택을 위한 공간
    public static int fib2(int N)
    {
        if(N <= 1)
            return N;
        else
            return fib2(N - 1) + fib2(N - 2);
    }


//    DP-상향식
//    Runtime: 0 ms, faster than 100.00%
//    Memory Usage: 41.3 MB, less than 17.21%
//    시간 복잡도: O(n)
//    공간 복잡도:O(n)
    int[] fib_cache = new int[31];
    public int fib3(int N)
    {
        if (N <= 1) {
            return N;
        } else if(fib_cache[N] != 0) {
            return fib_cache[N];
        } else {
            return fib_cache[N] = fib3(N - 1) + fib3(N - 2);
        }
    }

//    DP-하향식
//    Runtime: 0 ms, faster than 100.00%
//    Memory Usage: 41.4 MB, less than 17.21
//    시간 복잡도: O(n)
//    공간 복잡도:O(n
    public int fib4(int N)
    {
        if (N <= 1) {
            return N;
        }

        int[] fib_cache = new int[N + 1];
        fib_cache[1] = 1;

        for(int i = 2; i <= N; i++)
        {
            fib_cache[i] = fib_cache[i - 1] + fib_cache[i - 2];
        }
        return fib_cache[N];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(fib(Integer.parseInt(br.readLine())));
    }
}


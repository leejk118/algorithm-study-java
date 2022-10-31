package main.day1017.leetcode_274;

import javax.swing.tree.TreeNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class leetcode_274_pcc2242 {
    /**
     * https://leetcode.com/problems/h-index/
     *
     * 274. H-Index
     *
     * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper,
     * return compute the researcher's h-index.
     *
     * According to the definition of h-index on Wikipedia:
     * A scientist has an index h if h of their n papers have at least h citations each,
     * and the other n − h papers have no more than h citations each.
     *
     */


//    Runtime 8 ms Beats 9.61%
//    Memory 42 MB Beats 46.1%
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length;
        int h = 0;
        while ( h < n && citations[n - h - 1] > h) {
            h++;
        }
        return h;
    }

    public static int hIndex2(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length;

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(hIndex(new int[]{3,0,6,1,5}));
        System.out.println(hIndex(new int[]{1, 3, 1}));
        System.out.println(hIndex(new int[]{20, 50, 100}));
    }
}


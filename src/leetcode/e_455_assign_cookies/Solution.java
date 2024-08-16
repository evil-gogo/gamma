package leetcode.e_455_assign_cookies;

//https://leetcode.com/problems/assign-cookies/description/

import java.util.Arrays;

class Solution {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int childIndex = 0;
        int cookieIndex = 0;
        while (cookieIndex < s.length && childIndex < g.length) {
            if (g[childIndex] <= s[cookieIndex]) {
                childIndex++;
            }
            cookieIndex++;
        }

        return childIndex;
    }

    public static void main(String[] args) {
        int[] g = {1, 2, 3}, s = {1, 1};
        System.out.println(findContentChildren(g, s));
    }
}

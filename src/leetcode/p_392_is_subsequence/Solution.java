package leetcode.p_392_is_subsequence;

//https://leetcode.com/problems/is-subsequence/description/

class Solution {
    public static boolean isSubsequence(String s, String t) {
        //return isSubsequence1(s, 0, t, 0);
        return isSubsequence2(s, 0, t, 0);
    }

    public static boolean isSubsequence1(String s, int indexS, String t, int indexT) {
        if (indexS == s.length()) {
            return true;
        }
        if (indexT == t.length()) {
            return false;
        }
        if (s.charAt(indexS) == t.charAt(indexT)) {
            return isSubsequence1(s, indexS + 1, t, indexT + 1);
        }
        return isSubsequence1(s, indexS, t, indexT + 1);
    }

    public static boolean isSubsequence2(String s, int indexS, String t, int indexT) {
        while (indexS < s.length() && indexT < t.length()) {
            if (s.charAt(indexS) == t.charAt(indexT)) {
                indexS++;
                indexT++;
            } else {
                indexT++;
            }
        }
        if (indexS == s.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
}
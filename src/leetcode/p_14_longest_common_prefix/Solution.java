package leetcode.p_14_longest_common_prefix;

//https://leetcode.com/problems/longest-common-prefix/

class Solution {
    public static String longestCommonPrefix(String[] strs) {
        int numberOfStrings = strs.length;

        for (int index = 0; index < strs[0].length(); ++index) {
            for (int stringIndex = 1; stringIndex < numberOfStrings; ++stringIndex) {
                if (strs[stringIndex].length() <= index || strs[stringIndex].charAt(index) != strs[0].charAt(index)) {
                    return strs[0].substring(0, index);
                }
            }
        }

        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
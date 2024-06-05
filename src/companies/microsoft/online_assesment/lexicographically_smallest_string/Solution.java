package companies.microsoft.online_assesment.lexicographically_smallest_string;

//https://algo.monster/problems/lexicographically_smallest_string

class Solution {
    public static String smallestString(String s) {
        int i;
        for (i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                break;
            }
        }
        return s.substring(0, i) + s.substring(i + 1);
    }

    public static void main(String[] args) {
        String str = "abczd";
        System.out.println(smallestString(str));
    }
}

package companies.microsoft.online_assesment.string_without_3_identical_consecutive_letters;

//https://algo.monster/problems/string_without_3_identical_consecutive_letters

class Solution {
    public static String filterString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(s.charAt(1));
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1) || s.charAt(i) != s.charAt(i - 2)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "eedaaad";
        System.out.println(filterString(s));
    }
}


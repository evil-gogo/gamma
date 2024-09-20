package leetcode.easy.e_1957_delete_characters_to_make_fancy_string;

//https://leetcode.com/problems/delete-characters-to-make-fancy-string/description/

class Solution {
    public static String makeFancyString(String s) {
        StringBuilder fancyString = new StringBuilder();

        for (char currentChar : s.toCharArray()) {
            int currentLength = fancyString.length();

            if (currentLength > 1 && fancyString.charAt(currentLength - 1) == currentChar && fancyString.charAt(currentLength - 2) == currentChar) {
                continue;
            }
            fancyString.append(currentChar);
        }

        return fancyString.toString();
    }

    public static void main(String[] args) {
        String s = "aaabaaaa";
        System.out.println(makeFancyString(s));
    }
}

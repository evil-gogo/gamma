package leetcode.p_125_valid_palindrome;

class Solution {
    public static boolean isPalindrome(String s) {
        int leftIndex = 0, rightIndex = s.length() - 1;
        while (leftIndex < rightIndex) {
            if (!isAlphaNumeric(s.charAt(leftIndex))) {
                leftIndex++;
            }
            if (!isAlphaNumeric(s.charAt(rightIndex))) {
                rightIndex--;
            }
            if (isAlphaNumeric(s.charAt(leftIndex)) && isAlphaNumeric(s.charAt(rightIndex))) {
                if (Character.toLowerCase(s.charAt(leftIndex)) != Character.toLowerCase(s.charAt(rightIndex))) {
                    return false;
                }

                leftIndex++;
                rightIndex--;
            }
        }
        return true;
    }

    private static boolean isAlphaNumeric(Character c) {
        return (Character.toLowerCase(c) >= 'a' && Character.toLowerCase(c) <= 'z') || (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}

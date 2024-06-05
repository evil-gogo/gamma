package companies.microsoft.online_assesment.min_deletions_to_obtain_string_in_right_format;

//https://algo.monster/problems/min_deletions_to_obtain_string_in_right_format

class Solution {
    public static int minimumDeletions(String s) {
        int minDeletions = 0, countY = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'Y') {
                countY++;
            } else {
                minDeletions = Math.min(minDeletions + 1, countY);
            }
        }
        return minDeletions;
    }

    public static void main(String[] args) {
        String s = "YXXXYXY";
        System.out.println(minimumDeletions(s));
    }
}

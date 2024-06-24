package companies.microsoft.online_assesment.max_inserts_to_obtain_string_without_3_consecutive_a;

//https://algo.monster/problems/max_inserts_to_obtain_string_without_3_consecutive_a

class Solution {
    public static int maxInserts(String s) {
        int count_A = 0, count_others = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'a') {
                count_A++;
            } else {
                count_others++;
                count_A = 0;
            }
            if (count_A == 3) {
                return -1;
            }
        }
        count_A = s.length() - count_others;
        return 2 * (count_others + 1) - count_A;
    }

    public static void main(String[] args) {
        String str = "dog";
        System.out.println(maxInserts(str));
    }
}

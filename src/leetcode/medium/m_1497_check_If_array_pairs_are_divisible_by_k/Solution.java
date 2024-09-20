package leetcode.medium.m_1497_check_If_array_pairs_are_divisible_by_k;

//https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/description/
//https://www.youtube.com/watch?v=uVLp1tkT4NU&ab_channel=Fraz
//https://www.youtube.com/watch?v=toYgBIaUdfM&ab_channel=Techdose

class Solution {
    public static boolean canArrange(int[] arr, int k) {
        int[] remainderFreq = new int[k];
        for (int number : arr) {
            int remainder = number % k;
            if (remainder < 0) {
                remainder = remainder + k;
            }
            remainderFreq[remainder]++;
        }

        if (remainderFreq[0] % 2 != 0) {
            return false;
        }
        for (int i = 1; i < k; i++) {
            if (remainderFreq[i] != remainderFreq[k - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //int[] arr = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        int[] arr = {-1, 1, -2, 2, -3, 3, -4, 4};
        int k = 5;
        System.out.println(canArrange(arr, k));
    }
}

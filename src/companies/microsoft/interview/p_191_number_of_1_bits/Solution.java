package companies.microsoft.interview.p_191_number_of_1_bits;

//https://leetcode.com/problems/number-of-1-bits/description/

class Solution {
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count+= n & 1;
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 11;
        System.out.println(hammingWeight(n));
    }
}

package leetcode.easy.e_1137_n_th_tribonacci_number;

//https://leetcode.com/problems/n-th-tribonacci-number/description/

class Solution {
    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] tribonacci = new int[n + 1];
        tribonacci[0] = 0;
        tribonacci[1] = 1;
        tribonacci[2] = 1;
        for (int i = 3; i <= n; i++) {
            tribonacci[i] = tribonacci[i - 1] + tribonacci[i - 2] + tribonacci[i - 3];
        }
        return tribonacci[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(tribonacci(n));
    }
}

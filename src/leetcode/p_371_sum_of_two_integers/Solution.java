package leetcode.p_371_sum_of_two_integers;

class Solution {
    public static int getSum(int a, int b) {
        int lastBitA, lastBitB;
        int result = 0;
        while (a!=0 && b != 0) {
            lastBitA = a & 1;
            lastBitB = b & 1;
            result = result | (lastBitA | lastBitB);
            result = result << 1;
            System.out.println(result);
            a = a >> 1;
            b = b >> 1;
            System.out.println(result + " " + a + " " + b + lastBitA + " " + lastBitB + " " +(lastBitA | lastBitB));

        }
        return result;
    }

    public static void main(String[] args) {
        int a = 2, b = 3;
        System.out.println(getSum(a, b));
    }
}

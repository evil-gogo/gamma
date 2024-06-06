package companies.microsoft.online_assesment.fair_indexes;

//https://algo.monster/problems/fair_indexes

class Solution {
    public static int fairIndex(int[] a, int[] b) {
        int sumA = 0, sumB = 0;

        for (int i = 0; i < a.length; i++) {
            sumA += a[i];
            sumB += b[i];
        }

        if (sumA != sumB || sumA % 2 != 0) {
            return 0;
        }
        int count = 0, tempA = 0, tempB = 0;

        for (int i = 0; i < a.length; i++) {
            tempA += a[i];
            tempB += b[i];
            if (tempA == tempB && 2 * tempA == sumA && 2 * tempB == sumB) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {4, -1, 0, 3}, b = {-2, 5, 0, 3};
        System.out.println(fairIndex(a, b));
    }
}

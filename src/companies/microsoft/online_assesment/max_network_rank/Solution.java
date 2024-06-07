package companies.microsoft.online_assesment.max_network_rank;

//https://algo.monster/problems/max_network_rank

class Solution {
    public static int maximalNetworkRank(int[] starts, int[] ends, int n) {
        int[] edgeCount = new int[n + 1];

        for (int i = 0; i < n; i++) {
            edgeCount[starts[i]]++;
            edgeCount[ends[i]]++;
        }

        int maximalNetworkRank = 0;
        for (int i = 1; i <= n; i++) {
            maximalNetworkRank = Math.max(maximalNetworkRank, edgeCount[starts[i - 1]] + edgeCount[ends[i - 1]] - 1);
        }
        return maximalNetworkRank;
    }

    public static void main(String[] args) {
        int[] starts = {1, 2, 3, 3}, ends = {2, 3, 1, 4};
        int n = 4;
        System.out.println(maximalNetworkRank(starts, ends, n));
    }
}

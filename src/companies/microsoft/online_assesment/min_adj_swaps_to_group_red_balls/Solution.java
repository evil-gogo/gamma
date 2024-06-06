package companies.microsoft.online_assesment.min_adj_swaps_to_group_red_balls;

//https://algo.monster/problems/min_adj_swaps_to_group_red_balls

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static int minSwaps(String s) {
        List<Integer> redIndexList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                redIndexList.add(i);
            }
        }
        int minSwaps = 0, leftIndex = 0, rightIndex = redIndexList.size() - 1;
        while (leftIndex < rightIndex) {
            minSwaps += (redIndexList.get(rightIndex) - redIndexList.get(leftIndex)) - (rightIndex - leftIndex);
            leftIndex++;
            rightIndex--;
        }
        if (minSwaps > 1000000000) {
            return -1;
        } else {
            return minSwaps;
        }
    }

    public static void main(String[] args) {
        String s = "WRRWWR";
        System.out.println(minSwaps(s));
    }
}


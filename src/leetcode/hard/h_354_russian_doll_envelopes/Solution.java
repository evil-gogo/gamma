package leetcode.hard.h_354_russian_doll_envelopes;

//https://leetcode.com/problems/russian-doll-envelopes/description/

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] e1, int[] e2) {
                if (Integer.compare(e1[0], e2[0]) == 0) {
                    return Integer.compare(e2[1], e1[1]);
                }
                ;
                return Integer.compare(e1[0], e2[0]);
            }
        });

        return lengthOfLIS(envelopes);
    }

    private static int lengthOfLIS(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        int[] lis = new int[envelopes.length];
        Arrays.fill(lis, 1);
        int maxLength = 1;

        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    if (maxLength < lis[i]) {
                        maxLength = lis[i];
                    }
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println(maxEnvelopes(envelopes));
    }
}
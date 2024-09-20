package leetcode.medium.m_15_3sum;

//https://leetcode.com/problems/3sum/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;

        for (int firstIndex = 0; firstIndex < length - 2; firstIndex++) {
            if (firstIndex > 0 && nums[firstIndex] == nums[firstIndex - 1]) {
                continue;
            }

            int secondIndex = firstIndex + 1;
            int thirdIndex = length - 1;

            while (secondIndex < thirdIndex) {
                int sum = nums[firstIndex] + nums[secondIndex] + nums[thirdIndex];

                if (sum < 0) {
                    secondIndex++;
                } else if (sum > 0) {
                    thirdIndex--;
                } else {
                    triplets.add(List.of(nums[firstIndex], nums[secondIndex], nums[thirdIndex]));

                    while (secondIndex < thirdIndex && nums[secondIndex] == nums[secondIndex + 1]) {
                        secondIndex++;
                    }
                    while (secondIndex < thirdIndex && nums[thirdIndex] == nums[thirdIndex - 1]) {
                        thirdIndex--;
                    }

                    secondIndex++;
                    thirdIndex--;
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }
}

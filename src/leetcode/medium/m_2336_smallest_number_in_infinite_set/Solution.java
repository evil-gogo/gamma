package leetcode.medium.m_2336_smallest_number_in_infinite_set;

//https://leetcode.com/problems/smallest-number-in-infinite-set/description/

import java.util.*;

class SmallestInfiniteSet {
    private Set<Integer> poppedNumbersSet;
    private int minNumberInInfiniteSequence;

    public SmallestInfiniteSet() {
        poppedNumbersSet = new HashSet<>();
        minNumberInInfiniteSequence = 1;
    }

    public int popSmallest() {
        while (poppedNumbersSet.contains(minNumberInInfiniteSequence)) {
            minNumberInInfiniteSequence++;
        }
        poppedNumbersSet.add(minNumberInInfiniteSequence);
        return minNumberInInfiniteSequence++;
    }

    public void addBack(int num) {
        if (poppedNumbersSet.contains(num)) {
            poppedNumbersSet.remove(num);
            if (minNumberInInfiniteSequence > num) {
                minNumberInInfiniteSequence = num;
            }
        }
    }

    public static void main(String[] args) {
        String[] sequence = {"SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"};
        int[][] input = {{}, {2}, {}, {}, {}, {1}, {}, {}, {}};

        //String[] sequence = {"SmallestInfiniteSet", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "addBack", "popSmallest", "popSmallest"};
        //int[][] input = {{}, {}, {1}, {}, {}, {}, {2}, {3}, {}, {}};
        SmallestInfiniteSet obj = null;

        int inputIndex = 0;
        for (String s : sequence) {
            switch (s) {
                case "SmallestInfiniteSet":
                    obj = new SmallestInfiniteSet();
                    inputIndex++;
                    System.out.println("null");
                    break;
                case "addBack":
                    assert obj != null;
                    obj.addBack(input[inputIndex][0]);
                    inputIndex++;
                    System.out.println("null");
                    break;
                case "popSmallest":
                    assert obj != null;
                    int res = obj.popSmallest();
                    if (res != -1) {
                        System.out.println(res);
                    } else {
                        System.out.println("null");
                    }
                    inputIndex++;
                    break;

            }
        }
    }
}

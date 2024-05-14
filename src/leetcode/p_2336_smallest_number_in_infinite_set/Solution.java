package leetcode.p_2336_smallest_number_in_infinite_set;

import java.util.*;

class SmallestInfiniteSet {
    private TreeSet<Integer> poppedNumbersSet;
    private int minNumberInInfiniteSequence;

    public SmallestInfiniteSet() {
        poppedNumbersSet = new TreeSet<>();
        minNumberInInfiniteSequence = 1;
    }

    public int popSmallest() {
        int smallestNumber;
        if (poppedNumbersSet.isEmpty()) {
            smallestNumber = minNumberInInfiniteSequence;
            poppedNumbersSet.add(smallestNumber);
            minNumberInInfiniteSequence++;
            return smallestNumber;
        } else {
            smallestNumber = poppedNumbersSet.first();
            if (smallestNumber > 1) {
                poppedNumbersSet.add(1);
                minNumberInInfiniteSequence = 1;
                return 1;
            } else {
                Iterator<Integer> iterator = poppedNumbersSet.iterator();
                int prevNumber = smallestNumber, nextNumber;
                while (iterator.hasNext()) {
                    nextNumber = iterator.next();
                    if (nextNumber - prevNumber > 1) {
                        break;
                    }
                    prevNumber = nextNumber;
                }
                poppedNumbersSet.add(prevNumber + 1);
                return prevNumber + 1;
            }
        }
    }

    public void addBack(int num) {
        if (poppedNumbersSet.contains(num)) {
            poppedNumbersSet.remove(num);
            if (poppedNumbersSet.isEmpty()) {
                minNumberInInfiniteSequence = 1;
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

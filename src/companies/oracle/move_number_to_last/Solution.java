package companies.oracle.move_number_to_last;

import java.util.Arrays;

class Solution {
    public static int move_to_last(int[] arr, int number) {
        int countOfNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number && i < arr.length - countOfNumber) {
                countOfNumber++;
                int currentIndex = i;
                while (currentIndex < arr.length - 1) {
                    arr[currentIndex] = arr[currentIndex + 1];
                    currentIndex++;
                }
                arr[arr.length - 1] = number;
                i--;
            }
        }
        return countOfNumber;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 2, 3, 0, 3, 3, 5, 7, 3, 1, 0, 0, 3, 3, 3};
        int number = 3;
        int result = move_to_last(arr, number);

        System.out.println(Arrays.toString(arr));
        System.out.println("Count Of " + number + " = " + result);
    }
}

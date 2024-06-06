package companies.microsoft.online_assesment.minimum_adjacent_swaps_to_make_palindrome;

//https://algo.monster/liteproblems/2193

class Solution {
    public static int minMovesToMakePalindrome(String s) {
        char[] charArray = s.toCharArray();

        int minMoves = 0, leftIndex = 0, rightIndex = s.length() - 1;

        while (leftIndex < rightIndex) {
            if (charArray[leftIndex] == charArray[rightIndex]) {
                leftIndex++;
                rightIndex--;
            } else {
                int matchingCharIndex = findMatchingCharIndex(charArray, leftIndex, rightIndex);

                if (matchingCharIndex == leftIndex) {
                    swapAdjacentChar(charArray, leftIndex, leftIndex + 1);
                    minMoves++;
                } else {
                    while (matchingCharIndex < rightIndex) {
                        swapAdjacentChar(charArray, matchingCharIndex, matchingCharIndex + 1);
                        minMoves++;
                        matchingCharIndex++;
                    }
                    leftIndex++;
                    rightIndex--;
                }
            }
        }
        System.out.println("After " + String.valueOf(charArray));
        return minMoves;

    }

    public static int findMatchingCharIndex(char[] strArr, int leftIndex, int rightIndex) {
        while (rightIndex > leftIndex) {
            if (strArr[leftIndex] == strArr[rightIndex]) {
                return rightIndex;
            }
            rightIndex--;
        }
        return rightIndex;
    }

    public static void swapAdjacentChar(char[] charArray, int indexA, int indexB) {
        char temp = charArray[indexA];
        charArray[indexA] = charArray[indexB];
        charArray[indexB] = temp;
    }

    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(minMovesToMakePalindrome(s));
    }
}

package leetcode.p_374_guess_number_higher_or_lower;

//https://leetcode.com/problems/guess-number-higher-or-lower/description/

class GuessGame {
    static int pick = 3;

    public static int guess(int num) {
        return Integer.compare(num, pick);
    }
}

class Solution extends GuessGame {
    public static int guessNumber(int n) {
        int startIndex = 1, endIndex = n;
        while (startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            int guessNumberResult = guess(midIndex);
            if (guessNumberResult == 0) {
                return midIndex;
            } else if (guessNumberResult == 1) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //int n = 10;
        int n = 3;
        System.out.println(guessNumber(10));
    }
}

package companies.microsoft.interview.p_68_text_justification;

//https://leetcode.com/problems/text-justification/description/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;

        int leftIndex = 0;
        while (leftIndex < n) {
            int lettersCount = words[leftIndex].length();
            int rightIndex = leftIndex + 1;
            int spaceSlots = 0;

            while (rightIndex < n && spaceSlots + lettersCount + words[rightIndex].length() + 1 <= maxWidth) {
                lettersCount += words[rightIndex].length();
                spaceSlots++;
                rightIndex++;
            }

            int remainingSlots = maxWidth - lettersCount;

            int eachWordSpace = spaceSlots == 0 ? 0 : remainingSlots / spaceSlots;
            int extraSpace = spaceSlots == 0 ? 0 : remainingSlots % spaceSlots;

            if (rightIndex == n) {
                eachWordSpace = 1;
                extraSpace = 0;
            }

            result.add(getLine(leftIndex, rightIndex, eachWordSpace, extraSpace, words, maxWidth));
            leftIndex = rightIndex;
        }

        return result;
    }

    private static String getLine(int leftIndex, int rightIndex, int eachWordSpace, int extraSpace, String[] words, int maxWidth) {
        StringBuilder line = new StringBuilder();

        for (int wordIndex = leftIndex; wordIndex < rightIndex; wordIndex++) {
            line.append(words[wordIndex]);

            if (wordIndex == rightIndex - 1) {
                continue;
            }

            for (int space = 1; space <= eachWordSpace; space++) {
                line.append(" ");
            }

            if (extraSpace > 0) {
                line.append(" ");
                extraSpace--;
            }
        }

        while (line.length() < maxWidth) {
            line.append(" ");
        }

        return line.toString();
    }

    public static void main(String[] args) {
        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth = 16;
        List<String> result = fullJustify(words, maxWidth);
        System.out.println(result);
    }
}

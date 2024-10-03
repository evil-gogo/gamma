package companies.salesforce.min_number_of_substitution;

import java.util.ArrayList;
import java.util.List;

class Result {

    /*
     * Complete the 'minimalOperations' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY words as parameter.
     */

    public static List<Integer> minimalOperations(List<String> words) {
        // Write your code here
        List<Integer> result = new ArrayList<>();

        for (String word : words) {
            char[] wordChar = word.toCharArray();
            int count = 0;
            if (wordChar.length > 1) {
                for (int i = 1; i < wordChar.length; i++) {
                    if (wordChar[i] == wordChar[i - 1]) {
                        count++;
                        i++;
                    }
                }
            }
            result.add(count);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] wordArray = {"ab", "aab", "abb", "abab", "abaaaba"};

        System.out.println(minimalOperations(List.of(wordArray)));
    }
}
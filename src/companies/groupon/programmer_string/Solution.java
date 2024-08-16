package companies.groupon.programmer_string;

class Result {
    public static int programmerStrings(String s) {
        char[] target = "programmer".toCharArray();

        int[] targetCharFrequency = new int[26];
        for (char c : target) {
            targetCharFrequency[c - 'a']++;
        }

        int[] currentCharFrequency = new int[26];
        int startIndex = 0, endIndex = s.length() - 1, matchedLettersCount = 0;

        while (startIndex < s.length()) {
            char c = s.charAt(startIndex);
            if (targetCharFrequency[c - 'a'] > 0) {
                currentCharFrequency[c - 'a']++;
                if (currentCharFrequency[c - 'a'] <= targetCharFrequency[c - 'a']) {
                    matchedLettersCount++;
                }
                if (matchedLettersCount == target.length) {
                    break;
                }
            }
            startIndex++;
        }

        currentCharFrequency = new int[26];
        matchedLettersCount = 0;

        while (endIndex >= 0) {
            char c = s.charAt(endIndex);
            if (targetCharFrequency[c - 'a'] > 0) {
                currentCharFrequency[c - 'a']++;
                if (currentCharFrequency[c - 'a'] <= targetCharFrequency[c - 'a']) {
                    matchedLettersCount++;
                }
                if (matchedLettersCount == target.length) {
                    break;
                }
            }
            endIndex--;
        }

        return endIndex - startIndex - 1;
    }

    public static int programmerStrings2(String str) {
        String programmer = "programmer";

        String head = programmer;

        int i = 0;
        // programmer
        for (; i < str.length(); i++) {
            int pIndex = head.indexOf(str.charAt(i));
            if (pIndex != -1) {
                head = head.substring(0, pIndex).concat(head.substring(pIndex + 1));
                //System.out.println(head);
            }

            if (head.length() == 0) {
                i++;
                break;
            }
        }

        String tail = programmer;

        int j = str.length() - 1;
        // programmer
        for (; j >= 0; j--) {
            int pIndex = tail.indexOf(str.charAt(j));
            if (pIndex != -1) {
                tail = tail.substring(0, pIndex).concat(tail.substring(pIndex + 1));
                //System.out.println(tail);
            }

            if (tail.length() == 0) {
                j--;
                break;
            }
        }

        // System.out.println(head);
        // System.out.println(tail);

        //System.out.println(j);
        //System.out.println(i);

        return j - i + 1;
    }

    public static void main(String[] args) {
        String s = "progxrammerrxproxgrammer";
        //String s = "xprogxrmaxemrppprmmograeiruu";
        //String s = "programmerprogrammer";
        System.out.println(programmerStrings(s));
        System.out.println(programmerStrings2(s));
    }
}

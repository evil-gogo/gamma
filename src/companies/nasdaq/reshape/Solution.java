package companies.nasdaq.reshape;

class Solution {
    public static String reshape(int n, String str) {
        str = str.replace(" ", "");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i += n) {
            int endIndex = Math.min(i + n, str.length());
            sb.append(str, i, endIndex).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reshape(3, "abc de fghij"));
        System.out.println(reshape(2, "1 23 456"));
    }
}

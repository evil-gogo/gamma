package companies.microsoft.online_assesment.binary_string_reduce_to_zero;

public class Solution {
    public static int reduceBinaryStringToZero(String s) {
        if (s.indexOf('0') == -1) {
            return s.length() * 2 - 1;
        }
        int number = Integer.parseInt(s, 2);
        int count = 0;
        while (number != 0) {
            if (number % 2 == 0) {
                number /= 2;
            } else {
                number -= 1;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        //String s= "111010101111";
        String s = "111111111111111111111111";
        System.out.println(reduceBinaryStringToZero(s));
    }
}

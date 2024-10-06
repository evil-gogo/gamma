package companies.oracle.product_of_array_ones_transformation;

class Solution {
    public static void main(String[] args) {
        //int[] arr = {0, -2, 1, 2, 3};
        int[] arr = {-1, -2, -3, 0, 1, 2};

        int noOfIterations = 0;
        int negativeOnesCount = 0;
        int zerosCount = 0;
        for (int element : arr) {
            if (element == 1) {
                continue;
            }
            if (element > 1) {
                noOfIterations += element - 1;
            } else if (element < 0) {
                noOfIterations += Math.abs(element + 1);
                negativeOnesCount++;
            } else {
                zerosCount++;
            }
        }

        if (negativeOnesCount % 2 != 0) {
            if (zerosCount > 0) {
                noOfIterations = noOfIterations + 1;
                zerosCount--;
            } else {
                noOfIterations = noOfIterations + 2;
            }
        }
        System.out.println(noOfIterations + zerosCount);
    }
}

//input - array of int
//        onetransformation
//
//
//        inc / dec by 1
//
//        As many iteraction is possible
//        min no of iteration required
//        -> product of element of all element is 1
//        1, 2, 3
//
//1, 1, 3
//1, 1, 2
//1, 1, 1
//
//+ve / -ve  both
//
//min iteration  = 3
//
//        element -
//inc / dec
//<1 -> dec
//<0 -> inc
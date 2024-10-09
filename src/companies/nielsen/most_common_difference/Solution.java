package companies.nielsen.most_common_difference;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] rangesInput = {0, 100};
        int N = 10;

        List<Integer> listOfRandomNumbers = getRandomNumbers(rangesInput, N);
        //System.out.println(listOfRandomNumbers);
        Collections.sort(listOfRandomNumbers);

        int result = getMostCommonDifference(listOfRandomNumbers);
        System.out.println("Most Common Difference is " + result);
    }

    public static int getMostCommonDifference(List<Integer> listOfRandomNumbers) {
        HashMap<Integer, Integer> mapDifferenceToCount = new HashMap<>();

        int mostCommonDifferenceCount = Integer.MIN_VALUE;
        for (int i = 1; i < listOfRandomNumbers.size(); i++) {
            int difference = Math.abs(listOfRandomNumbers.get(i) - listOfRandomNumbers.get(i - 1));
            mapDifferenceToCount.put(difference, mapDifferenceToCount.getOrDefault(difference, 0) + 1);

            if (mostCommonDifferenceCount < mapDifferenceToCount.get(difference)) {
                mostCommonDifferenceCount = mapDifferenceToCount.get(difference);
            }
        }
        return mostCommonDifferenceCount;
    }

    private static List<Integer> getRandomNumbers(int[] rangesInput, int N) {
        List<Integer> listOfRandomNumbers = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int randomNumber = (int) (Math.random() * rangesInput[1]) + rangesInput[0];
            listOfRandomNumbers.add(randomNumber);
        }
        return listOfRandomNumbers;
    }
}

//Bhargav Makkena
//19:38
//https://onecompiler.com/
//For a n number of random numbers in the range of 0 to 100, find the difference between two consecutive numbers and
// find the most common difference and write a test case to validate this.
//Expectation: Readable/Clean code, latest coding standards, TDD, algorithms
//Ex:
//Random numbers:       1,   4,  8,  22,  33, 37
//Difference:                        3    4   14   11   4
//
//Most common difference: 4
//
//
//We have an employee table with columns: employee_id, name, title, salary, department, manager_ID
//Q: I want to know the managers whose direct report’s average salary > 1000
//Note: Not all employees are managers and columns to be shown: employeeID, name, direct_reports_Avg_Salary
//
//SELECT employeeID, name, DIRECT_REPORTEES.AVG_SAL
//        FROM (
//            SELECT employeeID, name, AVG(SALARY) AS AVG_SAL
//            FROM EMPLOYEE AS DIRECT_REPORTEES
//            GROUP_BY MANAGER_ID
//        )
//WHERE DIRECT_REPORTEES.AVG_SAL > 1000;

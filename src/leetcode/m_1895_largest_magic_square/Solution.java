package leetcode.m_1895_largest_magic_square;

//https://leetcode.com/problems/largest-magic-square/description/

class Solution {
    static int[][] rowSums;
    static int[][] columnSums;
    static int[][] diagonalSums;
    static int[][] antiDiagonalSums;

    public static int largestMagicSquare(int[][] grid) {
        int noOfRows = grid.length;
        int noOfColumns = grid[0].length;

        rowSums = new int[noOfRows][noOfColumns];
        columnSums = new int[noOfRows][noOfColumns];
        diagonalSums = new int[noOfRows][noOfColumns];
        antiDiagonalSums = new int[noOfRows][noOfColumns];

        for (int row = 0; row < noOfRows; row++) {
            for (int column = 0; column < noOfColumns; column++) {
                if (column == 0) {
                    rowSums[row][column] = grid[row][column];
                } else {
                    rowSums[row][column] = rowSums[row][column - 1] + grid[row][column];
                }
            }
        }
        for (int column = 0; column < noOfColumns; column++) {
            for (int row = 0; row < noOfRows; row++) {
                if (row == 0) {
                    columnSums[row][column] = grid[row][column];
                } else {
                    columnSums[row][column] = columnSums[row - 1][column] + grid[row][column];
                }
            }
        }
        for (int row = 0; row < noOfRows; row++) {
            for (int column = 0; column < noOfColumns; column++) {
                if (row == 0 || column == 0) {
                    diagonalSums[row][column] = grid[row][column];
                } else {
                    diagonalSums[row][column] = diagonalSums[row - 1][column - 1] + grid[row][column];
                }
            }
        }
        for (int row = 0; row < noOfRows; row++) {
            for (int column = noOfColumns - 1; column >= 0; column--) {
                if (row == 0 || column == noOfColumns - 1) {
                    antiDiagonalSums[row][column] = grid[row][column];
                } else {
                    antiDiagonalSums[row][column] = antiDiagonalSums[row - 1][column + 1] + grid[row][column];
                }
            }
        }

        int maxSquareSize = Math.min(noOfRows, noOfColumns);

        while (maxSquareSize > 0) {
            for (int row = 0; row + maxSquareSize - 1 < noOfRows; row++) {
                for (int column = 0; column + maxSquareSize - 1 < noOfColumns; column++) {
                    boolean isMagicSquare = checkIfMagicSquare(grid, row, column, maxSquareSize);
                    if (isMagicSquare) {
                        return maxSquareSize;
                    }
                }
            }
            maxSquareSize--;
        }
        return 1;
    }

    private static boolean checkIfMagicSquare(int[][] grid, int currentRow, int currentColumn, int maxSquareSize) {
        int currentRowSum = rowSums[currentRow][currentColumn + maxSquareSize - 1];
        if (currentColumn > 0) {
            currentRowSum = currentRowSum - rowSums[currentRow][currentColumn - 1];
        }
        int tempRowSum;
        for (int row = currentRow + 1; row < currentRow + maxSquareSize; row++) {
            tempRowSum = rowSums[row][currentColumn + maxSquareSize - 1];
            if (currentColumn > 0) {
                tempRowSum = tempRowSum - rowSums[row][currentColumn - 1];
            }
            if (tempRowSum != currentRowSum) {
                return false;
            }
        }

        int currentColumnSum = columnSums[currentRow + maxSquareSize - 1][currentColumn];
        if (currentRow > 0) {
            currentColumnSum = currentColumnSum - columnSums[currentRow - 1][currentColumn];
        }
        int tempColumnSum;
        for (int column = currentColumn + 1; column < currentColumn + maxSquareSize; column++) {
            tempColumnSum = columnSums[currentRow + maxSquareSize - 1][column];
            if (currentRow > 0) {
                tempColumnSum = tempColumnSum - columnSums[currentRow - 1][column];
            }
            if (tempColumnSum != currentColumnSum) {
                return false;
            }
        }
        if (currentRowSum != currentColumnSum) {
            return false;
        }

        int currentDiagonalSum = diagonalSums[currentRow + maxSquareSize - 1][currentColumn + maxSquareSize - 1];
        if (currentRow > 0 && currentColumn > 0) {
            currentDiagonalSum = currentDiagonalSum - diagonalSums[currentRow - 1][currentColumn - 1];
        }
        if (currentColumnSum != currentDiagonalSum) {
            return false;
        }

        int currentAntiDiagonalSum = antiDiagonalSums[currentRow + maxSquareSize - 1][currentColumn];
        if (currentRow > 0 && currentColumn + maxSquareSize < grid[0].length) {
            currentAntiDiagonalSum = currentAntiDiagonalSum - antiDiagonalSums[currentRow - 1][currentColumn + maxSquareSize - 1 + 1];
        }
        return currentDiagonalSum == currentAntiDiagonalSum;
    }

    public static void main(String[] args) {
        //int[][] grid = {{7, 1, 4, 5, 6}, {2, 5, 1, 6, 4}, {1, 5, 4, 3, 2}, {1, 2, 7, 3, 4}};
        //int[][] grid = {{5, 1, 3, 1}, {9, 3, 3, 1}, {1, 3, 3, 8}};
        int[][] grid = {{100093, 100022, 100009, 100040, 100014, 100088, 100033, 100062, 100076, 100017, 100039, 100007, 100088, 100028, 100089, 100077, 100055}, {100009, 100077, 100049, 100100, 100076, 100022, 100099, 100036, 100012, 100051, 100068, 100046, 100035, 100082, 100077, 100013, 100031}, {100021, 100009, 100024, 100020, 100018, 100018, 100049, 100100, 100063, 100058, 100034, 100054, 100004, 100070, 100080, 100075, 100090}, {32, 41, 50, 3, 12, 21, 30, 100076, 100004, 100019, 100028, 100075, 100080, 100085, 100047, 100059, 100022}, {40, 49, 9, 11, 20, 29, 31, 100098, 100075, 100002, 100100, 100008, 100083, 100008, 100026, 100067, 100090}, {48, 8, 10, 19, 28, 37, 39, 100046, 100023, 100070, 100009, 100080, 100060, 100012, 100052, 100052, 100055}, {7, 16, 18, 27, 36, 38, 47, 100056, 100009, 100027, 100001, 100091, 100097, 100081, 100009, 100064, 100017}, {15, 17, 26, 35, 44, 46, 6, 100079, 100045, 100083, 100041, 100070, 100094, 100052, 100091, 100042, 100056}, {23, 25, 34, 43, 45, 5, 14, 100087, 100021, 100080, 100019, 100034, 100087, 100049, 100022, 100005, 100036}, {24, 33, 42, 51, 4, 13, 22, 100061, 100014, 100079, 100031, 100035, 100073, 100043, 100025, 100030, 100045}, {100021, 100013, 100014, 100086, 100016, 100061, 100022, 100039, 100076, 100046, 100073, 100093, 100039, 100084, 100009, 100019, 100044}, {100007, 100060, 100044, 100000, 100020, 100079, 100039, 100027, 100005, 100013, 100087, 100093, 100043, 100063, 100037, 100022, 100005}, {100040, 100011, 100003, 100060, 100045, 100049, 100027, 100037, 100069, 100058, 100061, 100029, 100054, 100078, 100081, 100004, 100052}, {100041, 100100, 100056, 100078, 100095, 100000, 100007, 100055, 100059, 100033, 100019, 100061, 100003, 100004, 100088, 100087, 100022}, {100028, 100025, 100047, 100025, 100071, 100084, 100030, 100050, 100041, 100008, 100013, 100004, 100015, 100085, 100043, 100084, 100084}, {100052, 100072, 100087, 100025, 100044, 100066, 100036, 100053, 100057, 100039, 100077, 100091, 100045, 100097, 100051, 100006, 100075}, {100096, 100006, 100014, 100094, 100029, 100031, 100051, 100032, 100080, 100098, 100016, 100098, 100057, 100044, 100052, 100092, 100093}};

        System.out.println(largestMagicSquare(grid));
    }
}

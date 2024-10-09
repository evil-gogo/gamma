package companies.adobe;

import java.util.*;

/*
     tunnel = 5
     train = 3
     iteration = 10

     _ _ _ _ _ 0
     1 _ _ _ _ 1   1 % 5
     2 1 _ _ _ 2.  2 % 5
     3 2 1 _ _ 3
     _ 3 2 1 _ 3
     _ _ 3 2 1 3
     _ _ _ 3 2 2
     _ _ _ _ 3 1
     _ _ _ _ _ 0
     1 _ _ _ _
     2 1 _ _ _
     3 2 1 _ _
     _ 3 2 1 _
     _ _ 3 2 1
     _ _ _ 3 2
     _ _ _ _ 3

    */

class Solution {
    public static void main(String args[]) throws Exception {
        int tunnel = 3, train = 5, iteration = 10;
        printSnapshot(tunnel, train, iteration);
    }

    public static void printSnapshot(int tunnel, int train, int iteration) {
        Queue<Integer> qeque = new LinkedList<>();

        for (int i = 0; i < tunnel; i++) {
            qeque.add(0);
        }

        int trainBoggyNo = 0;

        for (int i = 0; i < iteration; i++) {
            System.out.println(qeque);
            qeque.poll();

            if (trainBoggyNo < train) {
                qeque.add((trainBoggyNo % train) + 1);
                trainBoggyNo++;
            } else {
                qeque.add(0);
            }

            if (train + tunnel - 1 == i) {
                trainBoggyNo = 0;
            }
        }
    }
}

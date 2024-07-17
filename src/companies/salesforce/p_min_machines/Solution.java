package companies.salesforce.p_min_machines;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    int i, j;

    Pair (int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair pair = (Pair) o;
        return (this.i == pair.i && this.j == pair.j);
    }

    @Override
    public int hashCode() {
        return this.i * 31 + this.j;
    }

    @Override
    public String toString() {
        return i + " " + j;
    }
}

class Result {

    /*
     * Complete the 'getMinMachines' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY start
     *  2. INTEGER_ARRAY end
     */

    public static int getMinMachines(List<Integer> start, List<Integer> end) {
        // Write your code here

        Pair[] pairs = new Pair[start.size()];
        for (int i = 0; i < start.size(); i++) {
            pairs[i] = new Pair(start.get(i), end.get(i));
        }

        for (int i = 0; i < start.size(); i++) {
            System.out.println(pairs[i]);
        }

        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.j - p2.j;
            }
        });
        System.out.println();
        for (int i = 0; i < start.size(); i++) {
            System.out.println(pairs[i]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
//        for (int i = 0; i < pairs.length; i++) {
//            if (pq.isEmpty()) {
//                pq.add(pairs[i].j);
//                count++;
//            } else {
//                if (pq.peek() <= pairs[i].i) {
//                    pq.poll();
//                    pq.add(pairs[i].j);
//                } else {
//                    pq.add(pairs[i].j);
//                    count++;
//                }
//            }
//        }

         count = 1;
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i].i >= pairs[i -1].j) {
                count++;
            }
        }

        System.out.println(pq);
        System.out.println(count);
        return 0;


    }

    public static void main(String[] args) {
        Integer[] start = {2, 1, 5, 5, 8};
        Integer[] end = {5, 3, 8, 6, 12};
        System.out.println(getMinMachines(Arrays.asList(start), Arrays.asList(end)));
    }
}

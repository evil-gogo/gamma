package companies.bp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * The Main class implements an application that reads lines from the standard input
 * and prints them to the standard output.
 */

public class Main {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        String[] lineEdgesSplitted = new String[2];
        HashSet<Character> hashSet = new HashSet<Character>();
        setArray();
//        LinkedList<Character>[] adjacencyList = new LinkedList[26];
//        for (int i = 0; i < 26; i++) {
//            adjacencyList[i] = new LinkedList<>();
//        }
//
//
//        while ((line = in.readLine()) != null) {
//
//            if (line.contains("->")) {
//                lineEdgesSplitted = line.split("->");
//
//                adjacencyList[lineEdgesSplitted[0].charAt(0) - 'a'].add(lineEdgesSplitted[1].charAt(0));
//            } else if (line.contains(",")) {
//                for (int i = 0; i < line.length(); i++) {
//                    //hashSet = new HashSet<Character>();
//                    int[] visited = new int[26];
//                    if (line.charAt(i) >= 'a' && line.charAt(i) <= 'z') {
//
//
//                        System.out.println(checkIfNodeConnected(line.charAt(i), visited, adjacencyList));
//                    }
//                }
//            }
//        }

    }

    public static boolean checkIfNodeConnected(Character c, int[] visited, LinkedList<Character>[] adjacencyList) {
        boolean result = false;
        visited[c - 'a'] = visited[c - 'a'] + 1;

        for (int i = 0; i < adjacencyList[c - 'a'].size(); i++) {
            visited[adjacencyList[c - 'a'].get(i)] =  visited[adjacencyList[c - 'a'].get(i)] + 1;
            if (visited[adjacencyList[c - 'a'].get(i)] == 2) {
                result = true;
            }
            if (visited[adjacencyList[c - 'a'].get(i)] > 2) {
                System.out.println("Error Thrown!");
            }
        }
        return result;
    }

    public static void setArray(){
        int n =5;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<ArrayList<Integer>>();
        for(int i =0;i<n;i++){
          adj.add(new ArrayList<>());
        }
        adj.get(0);
    }
}
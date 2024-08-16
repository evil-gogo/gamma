package leetcode.m_210_course_schedule_II;

//https://leetcode.com/problems/course-schedule-ii/description/

import java.util.*;

class Solution {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        buildAdjacencyListAndInDegree(adjacencyList, inDegree, prerequisites);

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] ordering = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            Integer currentNode = queue.remove();
            List<Integer> neighbors = adjacencyList.get(currentNode);
            for (int neighbour : neighbors) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
            ordering[index++] = currentNode;
        }
        if (index != numCourses) {
            return new int[]{};
        }
        return ordering;
    }

    private static void buildAdjacencyListAndInDegree(List<List<Integer>> adjacencyList, int[] inDegree, int[][] prerequisites) {
        for (int[] prerequisite : prerequisites) {
            adjacencyList.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }
}
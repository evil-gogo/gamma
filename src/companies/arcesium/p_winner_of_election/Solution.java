package companies.arcesium.p_winner_of_election;

//https://www.geeksforgeeks.org/problems/winner-of-an-election-where-votes-are-represented-as-candidate-names-1587115621/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

import java.util.*;

class Solution {
    public static String[] winner(String arr[], int n) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(hashMap.entrySet());

        list.sort(new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                int result = Integer.compare((Integer) o2.getValue(), (Integer) o1.getValue());
                if (result == 0) {
                    result = ((String) o1.getKey()).compareTo((String) o2.getKey());
                }
                return result;
            }
        });

        return new String[]{(String) list.get(0).getKey(), "" + list.get(0).getValue()};
    }


    public static void main(String[] args) {
        String[] arr = {"john", "johnny", "jackie", "johnny", "john", "jackie", "jamie", "jamie", "john", "johnny", "jamie", "johnny", "john"};
        int n = 13;

        System.out.println(Arrays.toString(winner(arr, n)));
    }
}

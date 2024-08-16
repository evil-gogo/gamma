package companies.groupon.smart_sale;

import java.util.*;

class Result {
    public static int deleteProducts(List<Integer> ids, int m) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (Integer id : ids) {
            map.put(id, map.getOrDefault(id, 0) + 1);
        }

        map = sortHashMapByValues(map);

        int count = map.size();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();

            if (frequency <= m) {
                count--;
                m = m - frequency;
            } else {
                break;
            }
        }

        return count;
    }

    private static HashMap<Integer, Integer> sortHashMapByValues(HashMap<Integer, Integer> hashMap) {
        HashMap<Integer, Integer> sortedHashMap = new LinkedHashMap<>();
        hashMap.entrySet().stream().sorted(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        }).forEach(k -> {
            sortedHashMap.put(k.getKey(), k.getValue());
        });
        return sortedHashMap;
    }

    public static void main(String[] args) {
        //Integer[] ids = {1, 1, 1, 1};
        //int m = 2;
        Integer[] ids = {1, 2, 3, 1, 2, 2};
        int m = 3;
        System.out.println(deleteProducts(List.of(ids), m));
    }
}

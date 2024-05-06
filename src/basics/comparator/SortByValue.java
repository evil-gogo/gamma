package basics.comparator;

import java.util.*;

public class SortByValue {
    private static HashMap<Integer, String> sortHashMapByValues1(
            HashMap<Integer, String> passedMap) {

        List<Integer> mapKeys = new ArrayList<>(passedMap.keySet());
        List<String> mapValues = new ArrayList<>(passedMap.values());

        Collections.sort(mapValues);

        HashMap<Integer, String> sortedHashMap = new LinkedHashMap<>();

        Iterator<String> itrValues = mapValues.iterator();

        while (itrValues.hasNext()) {
            String sortedValue = itrValues.next();

            Iterator<Integer> iteratorKeys = mapKeys.iterator();
            while (iteratorKeys.hasNext()) {
                Integer key = iteratorKeys.next();
                String passedValue = passedMap.get(key);

                if (sortedValue.equals(passedValue)) {
                    iteratorKeys.remove();
                    sortedHashMap.put(key, sortedValue);
                    break;
                }
            }
        }
        return sortedHashMap;
    }

    private static HashMap<Integer, String> sortHashMapByValues2(HashMap<Integer, String> hashMap) {
        HashMap<Integer, String> sortedHashMap = new LinkedHashMap<>();
        hashMap.entrySet().stream().sorted(new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
                //return o1.getKey().compareTo(o2.getKey());
            }
        }).forEach(k -> {
            //System.out.println(k.getKey() + ": " + k.getValue());
            sortedHashMap.put(k.getKey(), k.getValue());
        });
        return sortedHashMap;
    }

    private static HashMap<Integer, String> sortHashMapByValues3(HashMap<Integer, String> hashMap) {
        HashMap<Integer, String> sortedHashMap = new LinkedHashMap<>();

        List<Map.Entry<Integer, String>> list = new ArrayList<Map.Entry<Integer, String>>(hashMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
                //return o1.getKey().compareTo(o2.getKey());
            }
        });

        for (Map.Entry<Integer, String> entry : list) {
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }

        return sortedHashMap;
    }

    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Z");
        hashMap.put(22, "Y");
        hashMap.put(10, "W");
        hashMap.put(3, "X");

        System.out.println(hashMap);

        System.out.println(sortHashMapByValues1(hashMap));
        System.out.println(sortHashMapByValues2(hashMap));
        System.out.println(sortHashMapByValues3(hashMap));
    }
}

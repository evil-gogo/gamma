package companies.adyne.cheapest_bank_route;

import java.util.*;

interface BankRoute {
    String getSource();

    String getDestination();

    int getCost();
}

class CheapestBankRoute {
    public static int getCheapestRouteCost(String destination, List<BankRoute> routes, int max) {
        Map<String, Integer> minCostMap = new HashMap<>();
        minCostMap.put("Adyen", 0);

        for (int iteration = 0; iteration <= max; iteration++) {
            Map<String, Integer> tempMinCostMap = new HashMap<>(minCostMap);

            for (BankRoute route : routes) {
                String sourceBank = route.getSource();
                String destinationBank = route.getDestination();
                int cost = route.getCost();

                if (minCostMap.containsKey(sourceBank)) {
                    int currentCost = minCostMap.get(sourceBank);
                    int newCost = currentCost + cost;

                    if (newCost < tempMinCostMap.getOrDefault(destinationBank, Integer.MAX_VALUE)) {
                        tempMinCostMap.put(destinationBank, newCost);
                    }
                }
            }

            minCostMap = tempMinCostMap;
        }
        return minCostMap.getOrDefault(destination, -1);
    }
}

class SampleBankRouteImpl implements BankRoute {
    private final String source;
    private final String destination;
    private final int cost;

    public SampleBankRouteImpl(String source, String destination, int cost) {
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getCost() {
        return cost;
    }
}

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String destination = scanner.nextLine();
        int k = Integer.parseInt(scanner.nextLine());
        int routesCount = Integer.parseInt(scanner.nextLine());
        List<BankRoute> bankRoutes = new ArrayList<>(routesCount);
        for (int i = 0; i < routesCount; i++) {
            String[] line = scanner.nextLine().split("-");
            BankRoute route = new SampleBankRouteImpl(line[0], line[1], Integer.parseInt(line[2]));
            bankRoutes.add(route);
        }
        int cost = CheapestBankRoute.getCheapestRouteCost(destination, bankRoutes, k);
        System.out.println(cost);
    }
}

//Chase
//1
//        5
//Adyen-BoA-10
//BoA-Wells-10
//Wells-Adyen-10
//BoA-Chase-60
//Wells-Chase-20

//70
package companies.tik_tok.optimize_supplychain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Supplier {
    String name;
    int price;
    int quantity;

    public Supplier(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + " " + price + " " + quantity;
    }

}

class Result {
    String name;
    int quantity;

    Result(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + " " + quantity;
    }
}

public class Solution {
    public static void main(String[] args) {
        List<Supplier> supplierList = new ArrayList<>();

        supplierList.add(new Supplier("Supplier1", 10, 100));
        supplierList.add(new Supplier("Supplier2", 15, 200));

        int required_quantity = 150;
        List<Result> resultList = new ArrayList<>();
        boolean isSupplyFulfilled = getOptimalSuppliers(supplierList, required_quantity, resultList);

        if (isSupplyFulfilled) {
            System.out.println(resultList);
        } else {
            System.out.println("Supply can not be fulfilled");
        }
    }

    public static boolean getOptimalSuppliers(List<Supplier> supplierList, int required_quantity, List<Result> resultList) {
        Collections.sort(supplierList, new Comparator<Supplier>() {
            @Override
            public int compare(Supplier o1, Supplier o2) {
                return o1.price - o2.price;
            }
        });

        for (Supplier supplier : supplierList) {
            if (required_quantity < supplier.quantity) {
                resultList.add(new Result(supplier.name, required_quantity));
                supplier.quantity = supplier.quantity - required_quantity;
                required_quantity = 0;
            } else {
                resultList.add(new Result(supplier.name, supplier.quantity));
                required_quantity = required_quantity - supplier.quantity;
                supplier.quantity = 0;
            }
        }
        return required_quantity == 0;
    }
}

package food_delivery_system;

import java.util.List;

public class Food {
    String itemName;
    double price;
    int quantity;

    List<Rating> ratings;

    public Food(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}

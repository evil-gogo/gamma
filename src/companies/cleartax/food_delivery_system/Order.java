package companies.cleartax.food_delivery_system;

public class Order {
    Restaurant restaurant;
    int quantity;

    //Invoice

    public Order(Restaurant restaurant, int quantity) {
        this.restaurant = restaurant;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "restaurant=" + restaurant +
                ", quantity=" + quantity +
                '}';
    }
}

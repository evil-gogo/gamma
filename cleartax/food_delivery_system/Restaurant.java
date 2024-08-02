package food_delivery_system;

import java.util.List;

public class Restaurant {
    String restaurantName;
    Address servicableAddress;
    Food food; //TODO recheck

    //List<Rating>ratings;
    float overallRating;

    public Restaurant(String restaurantName, Address servicableAddress, Food food) {
        this.restaurantName = restaurantName;
        this.servicableAddress = servicableAddress;
        this.food = food;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public Address getServicableAddress() {
        return servicableAddress;
    }

    public Food getFood() {
        return food;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setServicableAddress(Address servicableAddress) {
        this.servicableAddress = servicableAddress;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return this.getRestaurantName() + " " + this.food.itemName +  this.food.quantity;
    }
}
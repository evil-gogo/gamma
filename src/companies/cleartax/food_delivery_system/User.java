package companies.cleartax.food_delivery_system;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private String gender;
    private String phoneNumber;
    private Address address;

    List<Order> orderList;

    public User(String userName, String gender, String phoneNumber, Address address) {
        this.userName = userName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orderList = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPinCode(Address address) {
        this.address = address;
    }

    public void place_order(Order order) {
        order.restaurant.food.quantity = order.restaurant.food.quantity - order.quantity;
        orderList.add(order);
    }

    public List<Order> getOrderList() {
        return orderList;
    }
}

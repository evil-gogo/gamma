package food_delivery_system;

import java.util.*;

public class FoodDeliveryService {
    private final Map<String, User> userInfoMap;
    private final List<Restaurant> restaurantList;

    //Map -  Pincode -> List<Restauran>

    public FoodDeliveryService() {
        userInfoMap = new HashMap<>();
        restaurantList = new ArrayList<>();
    }

    public void register_user(User user) {
        userInfoMap.put(user.getPhoneNumber(), user);
    }

    public User login_user(String user_id) {
        return userInfoMap.get(user_id);
    }

    public void register_restaurant(Restaurant restaurant) {
        restaurantList.add(restaurant);
    }

    public List<Restaurant> show_restaurant(String inputType) {
        return switch (inputType) {
            case "price" -> getRestaurantsByPrice();
            case "rating" -> getRestaurantsByRating();
            default -> List.of();
        };
    }

    public List<Restaurant> getRestaurantsByPrice() {
        restaurantList.sort(new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant o1, Restaurant o2) {
                return Double.compare(o2.food.price, o1.food.price);
            }
        });
        return restaurantList;
    }

    public List<Restaurant> getRestaurantsByRating() {
        restaurantList.sort(new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant o1, Restaurant o2) {
                return Float.compare(o2.overallRating, o1.overallRating);
            }
        });
        return restaurantList;
    }

    public static void main(String[] args) {
        FoodDeliveryService foodDeliveryService = new FoodDeliveryService();

        User user1 = new User("Virat", "M", "123456", new Address("HSR", "560012"));
        User user2 = new User("Rohit", "M", "345678", new Address("BTM", "560013"));
        User user3 = new User("Rishabh", "M", "456789", new Address("Sarjapur", "560014"));
        User user4 = new User("Rahul", "M", "567891", new Address("Indiranagar", "560015"));
        foodDeliveryService.register_user(user1);
        foodDeliveryService.register_user(user2);
        foodDeliveryService.register_user(user3);
        foodDeliveryService.register_user(user4);


        Restaurant restaurant1 = new Restaurant("High Street",  new Address("HSR", "560012"), new Food("Thali", 20, 3));
        Restaurant restaurant2 = new Restaurant("Chai Days",  new Address("Indiranagar", "560015"), new Food("Puff", 30, 3));
        Restaurant restaurant3 = new Restaurant("Aromas Biryani",  new Address("Sarjapur", "560014"), new Food("Biryani", 300, 10));
        Restaurant restaurant4 = new Restaurant("Vishnu Grand",  new Address("BTM", "560013"), new Food("Dosa", 100, 10));
        foodDeliveryService.register_restaurant(restaurant1);
        foodDeliveryService.register_restaurant(restaurant2);
        foodDeliveryService.register_restaurant(restaurant3);
        foodDeliveryService.register_restaurant(restaurant4);

        User loggedUser  = foodDeliveryService.login_user("123456");
        if (loggedUser == null) {
            System.out.println("Invalid Credentials !!!! No user found");
        } else {
            System.out.println("Login Success !!! User " + loggedUser.getUserName() + " logged in.");
        }

        List<Restaurant> restaurantList1 = foodDeliveryService.show_restaurant("price");
        List<Restaurant> restaurantList2 = foodDeliveryService.show_restaurant("rating");
        System.out.println(restaurantList1);

        Order order1 = new Order(restaurant1, 3);
        loggedUser.place_order(order1);


        List<Order> orderList = loggedUser.getOrderList();
        System.out.println(orderList);


    }
}

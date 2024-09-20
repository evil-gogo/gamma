//package companies.adobe;
//
//public class R2 {
//}
//Product
//
//
//API Endpoints
//
//
//GET https://www.mydomain.com/v1/products?category=furniture
//
//
//Product
//Desing a coffee vending machine.
//
//There are base drinks water, coffee and milk. Each base drink has a cost associated with it.
//
//Each drink served from the machine is a combination of the base drinks.
//
//Drink A -> 1 coffee + 1 milk.
//
//Drink B -> 1 coffee + 1 water
//
//Drink C -> 1 coffee + 2 milk
//
//
//Serve a drink, + calculate price of drink.
//
//
//
//
//
//Cofee - 10
//Milk - 20
//Water - 5
//Foam - 15
//
//
//
//User - > A -> Coffee + Milk
//B -> Coffee. + Water
//C ->
//Cost
//        Pred
//
//
//class abstract Product {
//    String productName;
//    int price;
//			public Product(String productName) {
//        this.productName = productName;
//    }
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public int getPrice() {
//        return this.price;
//    }
//}
//
//
//
//class Coffee extends Product {
//    public Coffee(String coffee) {
//        super(coffee);
//    }
//
//
//}
//
//class Milk extends Product {
//    public Milk(String milk) {
//        super(milk);
//    }
//
//}
//
//class Water extends Product {
//    public Water() {
//        super();
//    }
//    public Water(String hotwater ) {
//        super(hotwater);
//    }
//
//}
//
//
//
//class VendingMachine {
//
//	switch(inputType) {
//        Product productType1;
//        Product productType2;
//
//        List<Product> productTypes;
//
//        case "DrinkA":
//            productType.add(new Coffee());
//            productType.add(new Water());
//            break;
//        case "DrinkB":
//            break;
//        case "DrinkC":
//            break;
//    }
//
//
//
//    public int calculatePrice(List<Product> productTypes) {
//        int totalCost = 0;
//        for (Product product : products) {
//            totalCost += product.getPrice();'
//        }
//        return totalCost;
//
//
//
//        Given a sorted array arr[] and a value X, find the k closest elements to X in arr[]
//
//        1 2 3 4 5 6 7 8
//
//        1 3 6 7 9 22
//
//        k=2
//
//        X=7
//
//        1 3 6 7 12 22
//
//        elementPosition = 4;
//        leftIndex = 3;
//        rightIndex = 5;
//
//
//        public List<Integer> findKClosest(int[] arr, int X, int k) {
//            List<Integer> result = new LinkedList<>();
//
//            int leftIndex = 0; rightIndex=arr.length() - 1;
//            int elementPosition = -1;
//            while (leftIndex <= rightIndex) {
//                int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
//
//                if (arr[midIndex] == X) {
//                    elementPosition = midIndex;
//                    break;
//                } else {
//                    if (arr[midIndex] < X) {
//                        lefIndex = midIndex + 1;
//                    } else {
//                        rightIndex = midIndex - 1;
//                    }
//                }
//
//            }
//
//            leftIndex = elementPosition - 1;
//            rightIndex = elementPosition + 1;
//
//            int leftNumer = INTEGER.MAX, rightNumber = INTEGER.MAX;
//            while (k > 0) {
//                if (k > 0 & leftIndex > 0) {
//
//                    leftNumber = arr[leftIndex];
//
//                    k--;
//                } else {
//                    leftNumber = INTEGER.MAX;
//                }
//                if (k > 0 & rightIndex < arr.length() - 1) {
//                    rightNumber = arr[rightIndex];
//
//                } else {
//                    rightNumber = INTEGER.MAX;
//                }
//
//                if (Math.abs(arr[elementPosition] - leftNumber]) > Math.abs(arr[elementPosition] - rightNumber] {
//
//                    result.add(rightNumber);
//                    rightIndex--;
//                }  else {
//
//                    result.add(leftNumber);
//                    leftIndex--;
//                }
//
//            }
//            return result;
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//            while (k > 0) {
//                if (k > 0 & leftIndex > 0) {
//
//                    result.add(arr[leftIndex]);
//                    leftIndex--;
//                    k--;
//                }
//                if (k > 0 & rightIndex < arr.length() - 1) {
//                    result.add(arr[rightIndex]);
//                    rightIndex++;
//                    k--;
//                }
//            }
//            return result;
//        }
//
//
//    }
//
//
//
//
//
//
//
//
//
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
//
//
//
//
//        }
//

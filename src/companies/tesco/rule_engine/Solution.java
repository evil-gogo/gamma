package companies.tesco.rule_engine;

import java.util.LinkedList;
import java.util.List;

class Product {
    int productId;
    String category;
    int quantity;

    public Product(int productId, String category, int quantity) {
        this.productId = productId;
        this.category = category;
        this.quantity = quantity;
    }
}

abstract class Rule {
    public abstract boolean doValidation(List<Product> productList);
}

class BulkBuyLimitRule extends Rule {
    int maxQuantity;

    public BulkBuyLimitRule(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    @Override
    public boolean doValidation(List<Product> productList) {
        for (Product product : productList) {
            if (product.quantity > maxQuantity) {
                System.out.println("Breached : BulkBuyLimitRule");
                return false;
            }
        }
        return true;
    }
}

class BulkBuyLimitCategoryRule extends Rule {
    int maxQuantity;
    String category;

    public BulkBuyLimitCategoryRule(int maxQuantity, String category) {
        this.maxQuantity = maxQuantity;
        this.category = category;
    }

    @Override
    public boolean doValidation(List<Product> productList) {
        int currentQuantity = 0;
        for (Product product : productList) {
            if (product.category.equals(category)) {
                currentQuantity += product.quantity;
                if (currentQuantity > maxQuantity) {
                    System.out.println("Breached : BulkBuyLimitCategoryRule");
                    return false;
                }
            }
        }
        return true;
    }
}

class RuleEngine {
    List<Rule> ruleList;

    public RuleEngine() {
        this.ruleList = new LinkedList<>();
    }

    public void addRulesForValidation(List<Rule> ruleList) {
        if (this.ruleList != null) {
            this.ruleList = ruleList;
        }
    }

    public boolean doValidation(List<Product> productList) {
        for (Rule rule : ruleList) {
            if (!rule.doValidation(productList)) {
                return false;
            }
        }
        return true;
    }
}

class ShoppingCart {
    RuleEngine ruleEngine;
    List<Product> productList;

    public ShoppingCart() {
        this.ruleEngine = new RuleEngine();
        this.productList = new LinkedList<>();
    }

    public boolean addProductsInShoppingCart(List<Product> productList) {
        if (this.productList != null) {
            this.productList.addAll(productList);
            return true;
        }
        return false;
    }

    public void doCheckout() {
        boolean isValidationSuccess = ruleEngine.doValidation(productList);
        System.out.println("Result -> " + (isValidationSuccess ? "MET" : "BREACHED"));
    }
}

class Solution {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        List<Rule> ruleList = new LinkedList<>();
        ruleList.add(new BulkBuyLimitRule(10));
        ruleList.add(new BulkBuyLimitCategoryRule(5, "Paracetamol"));

        shoppingCart.ruleEngine.addRulesForValidation(ruleList);

        List<Product> productList = new LinkedList<>();
        productList.add(new Product(1, "Paracetamol", 2));
        productList.add(new Product(2, "Analgesic", 3));
        productList.add(new Product(3, "Chocolate", 8));
        productList.add(new Product(4, "Paracetamol", 3));

        shoppingCart.addProductsInShoppingCart(productList);
        shoppingCart.doCheckout();
    }
}

//Tesco gets millions of orders every day with an average basket size of 100 items. Tesco Business has got some regulations around selling products online and in stores. These regulations are mandatory from legal and business perspective to enforce for all order transactions.
//You are given an order with a list of products in the shopping cart/basket with productid, product Category and quantity. And also, Restriction Rules on Qty and Qty/Category.
//        Example:
//Ordered items in the shopping cart/basket
//Item-1 -> productid=1, category=Paracetamol, quantity=3
//Item-2 -> productid=2, category=analgesic, quantity=3
//Item-3 -> productid=3, category=chocolate, quantity=8
//Item-4 -> productid=4, category= Paracetamol, quantity=2
//Business Restriction rules:
//Cannot buy more than 10 Quantity of any products - BulkBuyLimit
//Cannot buy more than 5 Quantity of paracetamol products – BulkBuyLimitCategory
//
//Write a restriction rule engine to run the restriction check against the shopping cart/basket and return the status as to MET/BREACHED indicating restriction status for the given restriction rules.
//For the above given example, the restriction status returned would be MET.
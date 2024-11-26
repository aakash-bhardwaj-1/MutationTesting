package org.example;

import java.util.ArrayList;
import java.util.List;

class Restaurant {
    String name;
    String[] menu;

    public Restaurant(String name, String[] menu) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Restaurant name cannot be null or empty.");
        }
        if (menu == null || menu.length == 0) {
            throw new IllegalArgumentException("Restaurant menu cannot be null or empty.");
        }
        this.name = name;
        this.menu = menu.clone();
    }

    public String[] getMenu() {
        return menu.clone();
    }
}

class FoodDeliveryApp {
    private List<Restaurant> restaurants = new ArrayList<>();
    public List<CartItem> cart = new ArrayList<>();
    private static final double TAX_RATE = 0.08; // 8% tax

    public void addRestaurant(String name, String[] menu) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Error: Restaurant name cannot be empty.");
        }
        if (menu == null || menu.length == 0) {
            throw new IllegalArgumentException("Error: Menu cannot be empty.");
        }
        for (Restaurant restaurant : restaurants) {
            if (restaurant.name.equalsIgnoreCase(name)) {
                throw new IllegalArgumentException("Error: A restaurant with this name already exists.");
            }
        }
        restaurants.add(new Restaurant(name, menu));
        System.out.printf("Restaurant '%s' added successfully.\n", name);
    }

    public List<String> listMenu(String restaurantName) {
        if (restaurantName == null || restaurantName.isEmpty()) {
            throw new IllegalArgumentException("Error: Restaurant name cannot be empty.");
        }
        for (Restaurant restaurant : restaurants) {
            if (restaurant.name.equalsIgnoreCase(restaurantName)) {
                List<String> menuList = new ArrayList<>();
                for (String item : restaurant.getMenu()) {
                    menuList.add(item);
                }
                return menuList;
            }
        }
        throw new IllegalArgumentException("Error: Restaurant '" + restaurantName + "' not found.");
    }

    public void addToCart(String restaurantName, String itemName, double price) {
        if (restaurantName == null || restaurantName.isEmpty() || itemName == null || itemName.isEmpty()) {
            throw new IllegalArgumentException("Error: Restaurant and item name cannot be empty.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Error: Item price must be greater than zero.");
        }
        boolean restaurantFound = false;
        for (Restaurant restaurant : restaurants) {
            if (restaurant.name.equalsIgnoreCase(restaurantName)) {
                restaurantFound = true;
                for (String item : restaurant.getMenu()) {
                    if (item.equalsIgnoreCase(itemName)) {
                        cart.add(new CartItem(restaurantName, itemName, price));
                        System.out.printf("Added '%s' from '%s' to the cart for $%.2f.\n", itemName, restaurantName, price);
                        return;
                    }
                }
                throw new IllegalArgumentException("Error: Item '" + itemName + "' not found in the menu of '" + restaurantName + "'.");
            }
        }
        if (!restaurantFound) {
            throw new IllegalArgumentException("Error: Restaurant '" + restaurantName + "' not found.");
        }
    }

    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.printf("Cart is empty.\n");
            return;
        }
        System.out.printf("Cart items:\n");
        for (CartItem item : cart) {
            System.out.printf("- %s from %s: $%.2f\n", item.itemName, item.restaurantName, item.price);
        }
    }

    public double calculateCartTotal() {
        double total = 0.0;
        for (CartItem item : cart) {
            total += item.price;
        }
        return total;
    }

    public double applyDiscount(double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Error: Discount percentage must be between 0 and 100.");
        }
        double total = calculateCartTotal();
        return total - (total * discountPercentage / 100);
    }

    public double calculateTax(double total) {
        if (total < 0) {
            throw new IllegalArgumentException("Error: Total cannot be negative.");
        }
        return total * TAX_RATE;
    }

    public void generateOrderSummary(double discountPercentage) {
        if (cart.isEmpty()) {
            throw new IllegalArgumentException("Error: Cart is empty.");
        }

        System.out.printf("Order Summary:\n");
        double total = 0.0;
        for (CartItem item : cart) {
            System.out.printf("- %s from %s: $%.2f\n", item.itemName, item.restaurantName, item.price);
            total += item.price;
        }

        System.out.printf("\nSubtotal: $%.2f\n", total);
        double discountedTotal = applyDiscount(discountPercentage);
        System.out.printf("Discount (%.2f%%): -$%.2f\n", discountPercentage, total - discountedTotal);
        double tax = calculateTax(discountedTotal);
        System.out.printf("Tax (%.2f%%): $%.2f\n", TAX_RATE * 100, tax);
        System.out.printf("Total: $%.2f\n", discountedTotal + tax);
    }

    public void clearCart() {
        cart.clear();
        System.out.printf("Cart cleared.\n");
    }
}

class CartItem {
    String restaurantName;
    String itemName;
    double price;

    public CartItem(String restaurantName, String itemName, double price) {
        if (restaurantName == null || restaurantName.isEmpty() || itemName == null || itemName.isEmpty()) {
            throw new IllegalArgumentException("Error: Restaurant name and item name cannot be empty.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Error: Price must be greater than zero.");
        }
        this.restaurantName = restaurantName;
        this.itemName = itemName;
        this.price = price;
    }
}

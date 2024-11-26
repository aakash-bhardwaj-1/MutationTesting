package org.example;

import org.example.FoodDeliveryApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    private FoodDeliveryApp app;

    @BeforeEach
    void setup() {
        app = new FoodDeliveryApp();
    }

    @Test
    void testAddRestaurantDuplicateCheck() {
        app.addRestaurant("Pizza Palace", new String[]{"Pepperoni Pizza"});
        assertThrows(IllegalArgumentException.class, () ->
                app.addRestaurant("Pizza Palace", new String[]{"Veggie Pizza"}));
    }

    @Test
    void testAddToCartNonexistentRestaurant() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                app.addToCart("Nonexistent", "Item", 9.99));
        assertEquals("Error: Restaurant 'Nonexistent' not found.", exception.getMessage());
    }

    @Test
    void testAddToCartNonexistentItem() {
        app.addRestaurant("Pizza Palace", new String[]{"Pepperoni Pizza"});
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                app.addToCart("Pizza Palace", "Nonexistent Item", 9.99));
        assertEquals("Error: Item 'Nonexistent Item' not found in the menu of 'Pizza Palace'.", exception.getMessage());
    }

    @Test
    void testApplyDiscountNegativeBoundary() {
        app.addRestaurant("Pizza Palace", new String[]{"Pepperoni Pizza"});
        app.addToCart("Pizza Palace", "Pepperoni Pizza", 10.99);
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                app.applyDiscount(-0.1));
        assertEquals("Error: Discount percentage must be between 0 and 100.", exception.getMessage());
    }

    @Test
    void testApplyDiscountAboveBoundary() {
        app.addRestaurant("Pizza Palace", new String[]{"Pepperoni Pizza"});
        app.addToCart("Pizza Palace", "Pepperoni Pizza", 10.99);
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                app.applyDiscount(100.1));
        assertEquals("Error: Discount percentage must be between 0 and 100.", exception.getMessage());
    }

    @Test
    void testCalculateTaxZeroTotal() {
        double tax = app.calculateTax(0.0);
        assertEquals(0.0, tax, 0.01, "Tax for zero total should be zero.");
    }

    @Test
    void testCalculateTaxValidInput() {
        double tax = app.calculateTax(100.0);
        assertEquals(8.0, tax, 0.01, "Tax calculation should return 8% of total.");
    }

    @Test
    void testGenerateOrderSummaryWithDiscount() {
        app.addRestaurant("Pizza Palace", new String[]{"Pepperoni Pizza", "Veggie Pizza"});
        app.addToCart("Pizza Palace", "Pepperoni Pizza", 10.99);
        app.addToCart("Pizza Palace", "Veggie Pizza", 12.50);
        app.generateOrderSummary(10); // 10% discount
    }

    @Test
    void testGenerateOrderSummaryWithoutDiscount() {
        app.addRestaurant("Pizza Palace", new String[]{"Pepperoni Pizza"});
        app.addToCart("Pizza Palace", "Pepperoni Pizza", 10.99);
        app.generateOrderSummary(0); // No discount
    }

    @Test
    void testClearCartBehavior() {
        app.addRestaurant("Pizza Palace", new String[]{"Pepperoni Pizza"});
        app.addToCart("Pizza Palace", "Pepperoni Pizza", 10.99);
        assertEquals(1, app.cart.size(), "Cart should have one item before clearing.");
        app.clearCart();
        assertEquals(0, app.cart.size(), "Cart should be empty after clearing.");
    }

    @Test
    void testIntegrationAddRestaurantAddToCartViewCart() {
        app.addRestaurant("Pizza Palace", new String[]{"Pepperoni Pizza", "Veggie Pizza"});
        app.addToCart("Pizza Palace", "Pepperoni Pizza", 10.99);
        List<String> menu = app.listMenu("Pizza Palace");
        assertEquals(2, menu.size(), "Menu should contain two items.");
        assertEquals(1, app.cart.size(), "Cart should contain one item.");
        app.viewCart();
    }

    @Test
    void testIntegrationCompleteOrderFlow() {
        app.addRestaurant("Pizza Palace", new String[]{"Pepperoni Pizza", "Veggie Pizza"});
        app.addToCart("Pizza Palace", "Pepperoni Pizza", 10.99);
        app.addToCart("Pizza Palace", "Veggie Pizza", 12.50);
        app.generateOrderSummary(10); // Validate console output
        double total = app.calculateCartTotal();
        assertEquals(23.49, total, 0.01, "Total should match sum of item prices before discount.");
        double discountedTotal = app.applyDiscount(10);
        assertEquals(21.14, discountedTotal, 0.01, "Discounted total should apply 10% correctly.");
        app.clearCart();
        assertTrue(app.cart.isEmpty(), "Cart should be empty after clearing.");
    }

    @Test
    void testIntegrationEmptyCartError() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                app.generateOrderSummary(10));
        assertEquals("Error: Cart is empty.", exception.getMessage());
    }
}

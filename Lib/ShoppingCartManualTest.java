
import java.util.ArrayList;

public class ShoppingCartManualTest {

    public static void run() {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---");
        System.out.println(); // for spacing

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้าเป็น null
        try {
            double total1 = ShoppingCartCalculator.calculateTotalPrice(null);
            if (total1 == 0.0) {
                System.out.println("PASSED: Null cart should return 0.0");
                passedCount++;
            } else {
                System.out.println("FAILED: Null cart expected 0.0 but got " + total1);
                failedCount++;
            }
        } catch (Exception e) {
            System.out.println("FAILED: Null cart caused an exception: " + e.getMessage());
            failedCount++;
        }

        // Test 2: ตะกร้าว่าง
        ArrayList<CartItem> emptyCart = new ArrayList<>();
        double total2 = ShoppingCartCalculator.calculateTotalPrice(emptyCart);
        if (total2 == 0.0) {
            System.out.println("PASSED: Empty cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("FAILED: Empty cart expected 0.0 but got " + total2);
            failedCount++;
        }

        // Test 3: คำนวณปกติ ไม่มีส่วนลด
        ArrayList<CartItem> simpleCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Bread", 25.0, 2)); // 50
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0, 1));      // 15
        double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total3 == 65.0) {
            System.out.println("PASSED: Simple cart total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 65.0 but got " + total3);
            failedCount++;
        }

        // Test 4: คำนวณ BOGO และ BULK
        ArrayList<CartItem> impleCart = new ArrayList<>();
        impleCart.add(new CartItem("BULK", "Bread", 25.0, 7)); // 157.5
        impleCart.add(new CartItem("BOGO", "Milk", 15.0, 4));      // 30
        double total4 = ShoppingCartCalculator.calculateTotalPrice(impleCart);
        if (total4 == 187.5) {
            System.out.println("PASSED: Simple cart total is correct (157.5+30.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 187.5.0 but got " + total4);
            failedCount++;
        }

        // Test 5: คำนวณ BOGO และ BULK ติดลบ
        ArrayList<CartItem> mpleCart = new ArrayList<>();
        mpleCart.add(new CartItem("BULK", "Bread", 25.0, 7)); // 157.5
        mpleCart.add(new CartItem("BOGO", "Milk", -15.0, 4));      // 0
        double total5 = ShoppingCartCalculator.calculateTotalPrice(mpleCart);
        if (total5 == 157.5) {
            System.out.println("PASSED: Simple cart total is correct (157.5+0.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 157.5 but got " + total5);
            failedCount++;
        }


        // --- Test Summary ---
        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passedCount + ", Failed: " + failedCount);
        if (failedCount == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}
package Arrays;

import java.util.*;

// storing the most recent minimum price encountered and taking it as current cost price to calculate profits with the prices ahead it.
// taking a maxProfit variable and updating it if profit is found to be greater than previous.
// also updating min_price if any price lower than it is found.

public class stock {
    public static void main(String[] args) {
        int arr[] = { 7, 1, 5, 3, 6, 4 };
        int min_price = arr[0];
        int maxProfit = 0;
        for (int i = 0; i < arr.length; i++) {
            min_price = Math.min(min_price, arr[i]);
            maxProfit = Math.max(maxProfit, arr[i] - min_price);
        }
        System.out.println("Max profit is : " + maxProfit);
    }
}

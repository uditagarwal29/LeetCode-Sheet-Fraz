package Arrays;

import java.util.*;

// Calculate Prefix Sum array  - Note this takes extra space. We can avoid this by using ArrayList to store nums[] or vector in c++
//To save space just add Prefix Sum elements starting from the end of num[] array

// currMult store the the multiplication sum of all the elements traversed.
// Multiplication for any index is 
//{(Multiplication of all the elements ahead of it (from  the prefix array) )* (Mulplicaiton of all elements before it)}

public class arrayProduct {
    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4 };

        int suffx[] = new int[nums.length];

        int mult = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            mult *= nums[i];
            suffx[i] = mult;
        }
        int currMult = 1;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (i == nums.length - 1) {
                nums[i] = currMult;
            } else {
                nums[i] = suffx[i + 1] * currMult;
            }

            currMult *= temp;
        }

        for (int val : nums) {
            System.out.print(val + " ");
        }

    }
}

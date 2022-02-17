package Arrays;

import java.util.*;
import java.util.Collections;

//METHOD 1 - O(N) - USING HASMAP
// Initially hashmap is empty, we traverse through array elements one by one. for each element we calculate the other no. req to achieve target sum
// ny using totalSum - currElement. If this is present in hashmap, we fetch the index and print it .
//if not present we Store the value and index of the current element and move to the next element in the iteration.
class twoSum {
    public static void main(String[] args) {
        int arr[] = { 3,3 };
        int t = 6;
        HashMap<Integer, Integer> hm = new HashMap<>();

        int result[] = new int[2];
        
        for (int i = 0; i < arr.length; i++) {
            int remSum = t - arr[i];
            if (hm.containsKey(remSum)) {
                result[0] = i;
                result[1] = hm.get(remSum);
            }
            hm.put(arr[i], i);
        }

        for (int val : result) {
            System.out.print(arr[val] + ", ");
        }
    }
}
// METHOD 2 - O(N2)
// sort
// find numbers less than target.
// pointer on array
// Find index of Target - current element
// class twoSum {

// public static void main(String[] args) {
// Scanner scn = new Scanner(System.in);
// int n, tSum;
// System.out.println("Input Array Size : ");
// n = scn.nextInt();

// ArrayList<Integer> arr = new ArrayList<>();
// System.out.println("Input Array : ");
// for (int i = 0; i < n; i++) {
// int temp = scn.nextInt();
// arr.add(temp);
// }

// System.out.println("Target Sum : ");
// tSum = scn.nextInt();

// int ptr = 0;
// int ele = arr.get(0);
// int remSum;

// int result[] = new int[2];

// while (ptr!=n-1) {
// ele = arr.get(ptr);
// remSum = tSum - ele;
// for (int x = ptr + 1; x<n; x++) {
// if (arr.get(x) == remSum) {
// result[0] = ptr;
// result[1] = x;
// break;
// }
// }
// ptr++;
// }

// for (int val : result) {
// System.out.print(val + ", ");
// }
// // java twoSum.java

// }
// }

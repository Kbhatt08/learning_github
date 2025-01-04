package com.karan.prctice;
import java.util.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Algorithms {
    public static void main(String[] args) {
        log.info("multiplication(x,y) = "+multiplication(5,9));
        log.info(Arrays.toString(merge(new int[] {1,2,3,0,0,0}, 3, new int[] {2,5,6}, 0)));
    }
    /**
     * Multiplies two numbers without using the multiplication operator.
     * Complexity: O(log min(x, y))
     *
     * @param a The first number to be multiplied.
     * @param b The second number to be multiplied.
     * @return The product of a and b.
     */
    private static int multiplication(int a, int b){
        // Choose the larger number as x and the smaller as y.
        int x, y;
        if(a >= b) {
            x = a;
            y = b;
        } else {
            x = b;
            y = a;
        }
        
        int prod = 0;  // Initialize the product.
        // Iterate until x becomes 0.
        while(x > 0) {
            // If x is odd, add y to the product.
            if (x % 2 == 1) {
                prod += y;
            }
            // Divide x by 2 and double y.
            x /= 2;
            y += y;
        }
        // Return the product.
        return prod;
    }
    /* 
    • What: A precise specification of the problem that the algorithm solves.
    • How: A precise description of the algorithm itself.
    • Why: A proof that the algorithm solves the problem it is supposed to solve.
    • How fast: An analysis of the running time of the algorithm.
     */
    // Mergesort
   
/*TODO 
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].

Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 */

 public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
    int j=0;
    while(j <= m+n-1) {
        if(nums1[j]>=nums2[j]){
            nums1[j]
        }
        j++;
    }
    return nums1;
}
}

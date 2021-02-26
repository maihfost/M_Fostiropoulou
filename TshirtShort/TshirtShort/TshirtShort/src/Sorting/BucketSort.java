/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

/**
 *
 * @author maihf
 */
public class BucketSort {

    public int[] sort(int[] nums, int max_value) {
        // Bucket Sort
        int[] Bucket = new int[max_value + 1];
        int[] sorted_nums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Bucket[nums[i]]++;
        }
        int outPos = 0;
        for (int i = 0; i < Bucket.length; i++) {
            for (int j = 0; j < Bucket[i]; j++) {
                sorted_nums[outPos++] = i;
            }
        }
        return sorted_nums;
    }

    public int max_value(int[] nums) {
        int max_value = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max_value) {
                max_value = nums[i];
            }
        }
        return max_value;
    }
}

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */

class Solution {
    private double findKthNumberOfSortedArrays(int[] arrayA, int startIndexA, int[] arrayB, int startIndexB, int k) {
        if (startIndexA >= arrayA.length) {
            return arrayB[startIndexB + k - 1];
        }
        if (startIndexB >= arrayB.length) {
            return arrayA[startIndexA + k - 1];
        }
        if (k == 1) {
            return Math.min(arrayA[startIndexA], arrayB[startIndexB]);
        }
        int halfKthOfA = startIndexA + (k / 2) - 1 < arrayA.length ? arrayA[startIndexA + (k / 2) - 1] : Integer.MAX_VALUE;
        int halfKthOfB = startIndexB + (k / 2) - 1 < arrayB.length ? arrayB[startIndexB + (k / 2) - 1] : Integer.MAX_VALUE;
        if (halfKthOfA > halfKthOfB) {
            return findKthNumberOfSortedArrays(arrayA, startIndexA, arrayB, startIndexB + k / 2, k - k / 2);
        } else {
            return findKthNumberOfSortedArrays(arrayA, startIndexA + k / 2, arrayB, startIndexB, k - k / 2);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int M = nums1.length + num2.length;
        if (M % 2 == 0) {
            return ((double) (findKthNumberOfSortedArrays(nums1, 0, nums2, 0, M / 2) 
            + findKthNumberOfSortedArrays(arrayA, startIndexA, arrayB, startIndexB, M / 2 + 1))) / 2;
        }
        return (double) findKthNumberOfSortedArrays(nums1, 0, nums2, 0, M / 2);
    }
}
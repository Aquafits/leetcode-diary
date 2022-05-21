//Given two sorted arrays nums1 and nums2 of size m and n respectively, return 
//the median of the two sorted arrays. 
//
// The overall run time complexity should be O(log (m+n)). 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
// Related Topics Array Binary Search Divide and Conquer 👍 16529 👎 2011


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if ((m + n) % 2 == 1) {
            return solve(nums1, 0, m, nums2, 0, n, 1 + (m + n) / 2, false);
        } else {
            return solve(nums1, 0, m, nums2, 0, n, (m + n) / 2, true);
        }
    }

    private double solve(int[] nums1, int i, int sz1, int[] nums2, int j, int sz2, int k, boolean even) {
        if (sz1 > sz2) return solve(nums2, j, sz2, nums1, i, sz1, k, even);

        if (sz1 == 0) {
            if (even) {
                return (nums2[j + k - 1] + nums2[j + k]) / 2.0;
            } else {
                return nums2[j + k - 1];
            }
        } else {
            if (k == 1) {
                if (even) {
                    double res;
                    if (nums1[i] < nums2[j]) {
                        res = nums1[i] + solve(nums1, i + 1, sz1 - 1, nums2, j, sz2, 1, false);
                    } else {
                        res = nums2[j] + solve(nums1, i, sz1, nums2, j + 1, sz2 - 1, 1, false);
                    }
                    return res / 2;
                } else {
                    return Math.min(nums1[i], nums2[j]);
                }
            } else {
                int k1 = Math.min(sz1, k / 2);
                int k2 = k - k1;
                if (nums1[i + k1 - 1] < nums2[j + k2 - 1]) {
                    return solve(nums1, i + k1, sz1 - k1, nums2, j, sz2, k - k1, even);
                } else {
                    return solve(nums1, i, sz1, nums2, j + k2, sz2 - k2, k - k2, even);
                }
            }
        }
    }
//
//    private double findKSmallest(int[] nums1, int i, int sz1, int[] nums2, int j, int sz2, int k) {
//        if (sz1 > sz2) return findKSmallest(nums2, j, sz2, nums1, i, sz1, k);
//
//        if (sz1 == 0) {
//            return nums2[j + k - 1];
//        } else {
//            if (k == 1) {
//                return Math.min(nums1[i], nums2[j]);
//            } else {
//                int k1 = Math.min(sz1, k / 2);
//                int k2 = k - k1;
//                if (nums1[i + k1 - 1] < nums2[j + k2 - 1]) {
//                    return findKSmallest(nums1, i + k1, sz1 - k1, nums2, j, sz2, k - k1);
//                } else {
//                    return findKSmallest(nums1, i, sz1, nums2, j + k2, sz2 - k2, k - k2);
//                }
//            }
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

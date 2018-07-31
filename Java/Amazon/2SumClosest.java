class Solution {
    public int twoSumClosest(int[] nums, int target) {
        if (nums.length < 2) {
            return Integer.MAX_VALUE;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int closest = Integer.MAX_VALUE;
        while (left < right) {
            int sum = nums[left] + nums[right];
            int diff = Math.abs(sum - target);
            if (diff == 0) {
                return sum;
            }

            if (diff < Math.abs(closest - target)) {
                closest = sum;
            }
            if (sum < target) {
                left++;
            }
            else {
                right--;
            }
        }
        return closest;
    }
}
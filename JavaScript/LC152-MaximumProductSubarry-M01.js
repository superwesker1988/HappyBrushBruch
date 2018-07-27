/**
 * @param {number[]} nums
 * @return {number[]}
 */
var maxProduct = function(nums) {
    if (nums === null) {
        return [];
    }
    if (nums.length < 2)
        return nums;
    let maxProduct = currentMax = currentMin = nums[0];
    let minLeft = 0, minRight = 0, maxLeft = 0, maxRight = 0;
    let answerLeft = 0, answerRight = 0;
    for (let i = 1; i < nums.length; i++) {
        const lastMax = currentMax;
        const lastMin = currentMin;
        if (nums[i] > 0) {
            // Calculate new min product
            if (lastMin * nums[i] < nums[i]) {
                minRight++;
                currentMin = lastMin * nums[i];
            } else {
                currentMin = nums[i];
                minLeft = i;
                minRight = i;
            }
            // Calculate new max product
            if (lastMax * nums[i] > nums[i]) {
                currentMax = lastMax * nums[i];
                maxRight++;
            } else {
                currentMax = nums[i];
                maxLeft = i;
                maxRight = i;
            }
        } else {
            const lastMinLeft = minLeft;
            const lastMaxLeft = maxLeft;
            // Calculate new min product
            if (lastMax * nums[i] < nums[i]) {
                minRight = i;
                minLeft = lastMaxLeft;
                currentMin = lastMax * nums[i];
            } else {
                currentMin = nums[i];
                minLeft = i;
                minRight = i;
            }
            // Calculate new max product
            if (lastMin * nums[i] > nums[i]) {
                currentMax = lastMin * nums[i];
                maxLeft = lastMinLeft;
                maxRight = i;
            } else {
                currentMax = nums[i];
                maxLeft = i;
                maxRight = i;
            }
        }
        if (currentMax > maxProduct) {
            answerLeft = maxLeft;
            answerRight = maxRight;
            maxProduct = currentMax;
        }
    }
    return [answerLeft, answerRight];
};
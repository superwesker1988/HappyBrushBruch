/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

 


The largest rectangle is shown in the shaded area, which has area = 10 unit.

 

Example:

Input: [2,1,5,6,2,3]
Output: 10
 */

/**
 * @param {number[]} heights
 * @return {number}
 */
var largestRectangleArea = function(heights) {
    if (heights === null || heights.length === 0) {
        return 0;
    }
    const stack = [];
    const answer = 0;
    for (let i = 0; i < heights.length; i++) {
        // Monotone stack: index got pop when its area cannot be increased by height pointed by the index
        // i.e. current height has to be the smallest
        while (stack.length && heights[i] <= heights[stack[stack.length - 1]]) {
            const height = heights[stack.pop()];
            const left = stack.length ? stack[stack.length - 1] : -1;
            answer = Math.max(answer, height * (i - left - 1));
        }
        stack.push(i);
    }
    return answer;
};
/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 */

/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    if (height === null || height.length < 3) {
        return 0;
    }
    const stack = [];
    let answer = 0;
    for (let i = 0; i < height.length; i++) {
        while (stack.length && height[i] > height[stack[stack.length - 1]]) {
            let lowIndex = stack.pop();
            if (!stack.length) {
                continue;
            }
            const stackPeek = stack[stack.length - 1];
            answer += (i - stackPeek - 1) * (Math.min(height[i], height[stackPeek]) - height[lowIndex]);
        }
        stack.push(i);
    }
    return answer;
};
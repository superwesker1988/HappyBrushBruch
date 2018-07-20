/**
 * @param {number[]} heights
 * @return {number}
 */
var largestRectangleArea = function(heights) {
    if (heights === null || heights.length === 0)
        return 0;
    const heightStack = [];
    let maxArea = 0;
    for (let i = 0; i <= heights.length; i++) {
        let newHeight = (i === heights.length) ? -1 : heights[i];
        while (heightStack.length > 0 && newHeight <= heights[heightStack[heightStack.length - 1]]) {
            let curHeight = heights[heightStack.pop()];
            let curWidth = heightStack.length === 0 ? i : i - heightStack[heightStack.length - 1] - 1;
            maxArea = Math.max(maxArea, curHeight * curWidth);
        }
        heightStack.push(i);
    }
    return maxArea;
};

/**
Max Area: 0, Stack: 0
Max Area: 2, Stack: 1
Max Area: 2, Stack: 1,2
Max Area: 2, Stack: 1,2,3
Max Area: 10, Stack: 1,4
Max Area: 10, Stack: 1,4,5
Max Area: 10, Stack: 6
 */

/**
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
 */
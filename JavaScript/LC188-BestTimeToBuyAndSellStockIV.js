/**
 * 
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example 1:

Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 */

/**
 * @param {number} k
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(k, prices) {
    if (prices === null || prices.length === 0) {
        return 0;
    }
    // When you can do buy/sell for every price points, just to accumulate positive diff throughout time
    if (k >= prices.length / 2) {
        let profit = 0;
        for (let i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
    const K = k;
    const profits = new Array(2);
    for (let i = 0; i < 2; i++) {
        profits[i] = new Array(prices.length).fill(0);
    }
    for (let i = 1; i < K + 1; i++) {
        let tempMax = profits[(i - 1) % 2][0] - prices[0];
        for (let j = 1; j < prices.length; j++) {
            profits[i % 2][j] = Math.max(profits[i % 2][j - 1], tempMax + prices[j]);
            tempMax = Math.max(tempMax, profits[(i - 1) % 2][j] - prices[j]);
        }
    }
    return profits[K % 2][prices.length - 1];
};
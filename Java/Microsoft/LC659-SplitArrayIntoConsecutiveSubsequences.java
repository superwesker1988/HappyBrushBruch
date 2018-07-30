import java.util.Map;

/**
 * 
You are given an integer array sorted in ascending order (may contain duplicates), you need to split them into several subsequences, where each subsequences consist of at least 3 consecutive integers. Return whether you can make such a split.

Example 1:
Input: [1,2,3,3,4,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3
3, 4, 5
Example 2:
Input: [1,2,3,3,4,4,5,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3, 4, 5
3, 4, 5
Example 3:
Input: [1,2,3,4,4,5]
Output: False
Note:
The length of the input is in range of [1, 10000]
 */

public class Solution {
    private HashMap<Integer, PriorityQueue<Integer>> dmap;
    public boolean isPossible(int[] nums) {
        dmap = new HashMap<>();
        for (int num : nums) {
            PriorityQueue<Integer> pq0 = getOrPut(num - 1);
            int len = pq0.isEmpty() ? 0 : pq0.poll();
            PriorityQueue<Integer> pq1 = getOrPut(num);
            pq1.offer(len + 1);
        }
        for (int key : dmap.keySet()) {
            for (int len : dmap.get(key)) {
                if (len < 3) return false;
            }
        }
        return true;
    }
    public PriorityQueue<Integer> getOrPut(int num) {
        PriorityQueue<Integer> pq = dmap.get(num);
        if (pq == null) {
            pq = new PriorityQueue<Integer>();
            dmap.put(num, pq);
        }
        return pq;
    }
}
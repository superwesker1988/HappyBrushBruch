import java.util.Set;

/**
 * Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return generateTreeByNum(1, n);
    }
    
    private List<TreeNode> generateTreeByNum(int start, int end) {
        List<TreeNode> answer = new ArrayList<TreeNode>();
        if (start > end) {
            answer.add(null);
            return answer;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftAnswers = generateTreeByNum(start, i - 1);
            List<TreeNode> rightAnswers = generateTreeByNum(i + 1, end);
            for (TreeNode left : leftAnswers) {
                for (TreeNode right : rightAnswers) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    answer.add(root);
                }
            }
        }
        return answer;
    }
}
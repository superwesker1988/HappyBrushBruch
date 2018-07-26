import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/**
 * 
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        if (root == null) {
            return answer;
        }
        Stack<TreeNode> curStack = new Stack<TreeNode>();
        Stack<TreeNode> nextStack = new Stack<TreeNode>();
        Stack<TreeNode> tempStack;
        boolean isZipDirection = true;
        curStack.push(root);

        while (curStack.size() > 0) {
            int stackSize = curStack.size();
            List<Integer> curLevel = new ArrayList<Integer>();
            while (stackSize > 0) {
                stackSize--;
                TreeNode node = curStack.pop();
                curLevel.add(node.val);
                if (isZipDirection) {
                    if (node.right != null) {
                        nextStack.push(node.right);
                    }
                    if (node.left != null) {
                        nextStack.push(node.left);
                    }
                }
                else {
                    if (node.left != null) {
                        nextStack.push(node.left);
                    }
                    if (node.right != null) {
                        nextStack.push(node.right);
                    }
                }
            }
            tempStack = nextStack;
            nextStack = curStack;
            curStack = tempStack;
            answer.add(curLevel);
            isZipDirection = !isZipDirection;
        }
        return answer;
    }
}
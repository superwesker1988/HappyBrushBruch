import java.awt.Stroke;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    TreeNode rootPointer;
    Stack<TreeNode> storage;
    public BSTIterator(TreeNode root) {
        storage = new Stack<TreeNode>();
        while (root != null) {
            storage.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !storage.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode curNode = storage.pop();
        if (curNode.right != null) {
            TreeNode node = curNode.right;
            while (node != null) {
                storage.push(node);
                node = node.left;
            }
        }
        return curNode.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
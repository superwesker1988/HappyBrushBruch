import java.util.Queue;

import javax.swing.tree.TreeNode;

import sun.reflect.generics.tree.Tree;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        StringBuffer buf = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            while (queueSize > 0) {
                TreeNode curNode = queue.poll();
                queueSize--;
                if (curNode == null) {
                    buf.append(",#");
                    continue;
                }
                buf.append(",");
                buf.append(curNode.val);
                queue.offer(curNode.left);
                queue.offer(curNode.right);
            }
        }
        return buf.toString().substring(1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        if (nodes.length == 0 || nodes[0].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index < nodes.length) {
            int queueSize = queue.size();
            while (queueSize > 0) {
                queueSize--;
                TreeNode curNode = queue.poll();
                if (index < nodes.length && !nodes[index].equals("#")) {
                    curNode.left = new TreeNode(Integer.parseInt(nodes[index]));
                    queue.offer(curNode.left);
                }
                index++;
                if (index < nodes.length && !nodes[index].equals("#")) {
                    curNode.right = new TreeNode(Integer.parseInt(nodes[index]));
                    queue.offer(curNode.right);
                }
                index++;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
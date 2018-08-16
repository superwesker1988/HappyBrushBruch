/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function(preorder, inorder) {
    return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);
};

var buildTreeHelper = function(preorder, inorder, preStart, preEnd, inStart, inEnd) {
    if (preStart > preEnd) {
        return null;
    }
    const thisNode = new TreeNode(preorder[preStart]);
    const newInStart = getPositionInInorder(preorder[preStart], inorder);
    thisNode.left = buildTreeHelper(preorder, inorder, preStart + 1, preStart + (newInStart - inStart), inStart, newInStart - 1);
    thisNode.right = buildTreeHelper(preorder, inorder, preStart + (newInStart - inStart) + 1, preEnd, newInStart + 1, inEnd);
    return thisNode;
};

var getPositionInInorder = function(target, inorder) {
    for (let index = 0; index < inorder.length; index++) {
        if (target === inorder[index]) {
            return index;
        }
    }
    return -1;
};
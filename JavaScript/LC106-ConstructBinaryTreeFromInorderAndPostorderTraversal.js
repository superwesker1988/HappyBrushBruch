/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
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
 * @param {number[]} inorder
 * @param {number[]} postorder
 * @return {TreeNode}
 */
var buildTree = function(inorder, postorder) {
    if (inorder.length !== postorder.length) {
        return null;
    }
    return getTreeRoot(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
};

const getIndexInInorder = (inorder, target) => {
    for (let index = 0; index < inorder.length; index++) {
        if (target === inorder[index]) {
            return index;
        }
    }
    return -1;
};

const getTreeRoot = (inorder, postorder, inStart, inEnd, postStart, postEnd) => {
    if (postStart > postEnd) {
        return null;
    }
    const root = new TreeNode(postorder[postEnd]);
    const inIndex = getIndexInInorder(inorder, postorder[postEnd]);
    root.right = getTreeRoot(inorder, postorder, inIndex + 1, inEnd, postEnd - (inEnd - inIndex), postEnd - 1);
    root.left = getTreeRoot(inorder, postorder, inStart, inIndex - 1, postStart, postEnd - (inEnd - inIndex) - 1);
    return root;
};
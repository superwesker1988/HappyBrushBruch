/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

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
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var zigzagLevelOrder = function(root) {
    if (root === null) {
        return [];
    }
    const answer = [];
    let nextLevelStack = [];
    let thisLevelStack = [];
    let isZig = true;
    thisLevelStack.push(root);
    while (thisLevelStack.length) {
        let levelSize = thisLevelStack.length;
        const levelNodes = [];
        while (levelSize) {
            levelSize--;
            const node = thisLevelStack.pop();
            levelNodes.push(node.val);
            if (isZig) {
                if (node.left) {
                    nextLevelStack.push(node.left);
                }
                if (node.right) {
                    nextLevelStack.push(node.right);
                }
            } else {
                if (node.right) {
                    nextLevelStack.push(node.right);
                }
                if (node.left) {
                    nextLevelStack.push(node.left);
                }
            }
        }
        isZig = !isZig;
        const temp = thisLevelStack;
        thisLevelStack = nextLevelStack;
        nextLevelStack = temp;
        answer.push(levelNodes.slice(0));
    }
    return answer;
};
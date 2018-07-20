/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var postorderTraversal = function(root) {
    return getAnswer(root);
};

const getAnswer = (root) => {
    const answer = [];
    if (root === null)
        return answer;
    let curNode = null, prevNode = null;
    const stack = [];
    stack.push(root);
    while (stack.length > 0) {
        curNode = stack[stack.length - 1];
        if (prevNode === null || prevNode.left === curNode || prevNode.right === curNode) {
            if (curNode.left) {
                stack.push(curNode.left);
            } else if (curNode.right) {
                stack.push(curNode.right);
            }
        } else if (curNode.left === prevNode) {
            if (curNode.right) {
                stack.push(curNode.right);
            }
        } else {
            answer.push(curNode.val);
            stack.pop();
        }
        prevNode = curNode;
    }
    return answer;
}
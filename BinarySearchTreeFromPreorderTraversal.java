/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public TreeNode bstFromPreorder(int[] preorder) {

        int len = preorder.length;
        if (len == 0) {
            return null;
        }

        Stack<TreeNode> treeStack = new Stack<>();
        Stack<LimitPair> limitsStack = new Stack<>();
        int preorderIndex = 0;
        TreeNode tree = new TreeNode(preorder[preorderIndex++]);
        treeStack.push(tree);
        limitsStack.push(new LimitPair(Integer.MIN_VALUE, Integer.MAX_VALUE));

        while (preorderIndex < len) {

            LimitPair topLimit = limitsStack.peek();
            TreeNode topTreeNode = treeStack.peek();
            TreeNode treeNode = new TreeNode(preorder[preorderIndex]);

            if (preorder[preorderIndex] < topTreeNode.val &&
                topLimit.isInLimits(preorder[preorderIndex])) {

                limitsStack.push(new LimitPair(topLimit.min, topTreeNode.val));
                topTreeNode.left = treeNode;
                treeStack.push(treeNode);
                preorderIndex++;
                
            } else if (preorder[preorderIndex] > topTreeNode.val &&
                topLimit.isInLimits(preorder[preorderIndex])) {
                
                topTreeNode.right = treeNode;
                limitsStack.push(new LimitPair(topTreeNode.val, topLimit.max));
                treeStack.push(treeNode);
                preorderIndex++;
                
            } else {
                treeStack.pop();
                limitsStack.pop();
            }
        }
        return tree;
    }
}

class LimitPair {

    Integer min;
    Integer max;

    LimitPair(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    public boolean isInLimits(Integer num) {
        return (num > min && num < max);
    }
}

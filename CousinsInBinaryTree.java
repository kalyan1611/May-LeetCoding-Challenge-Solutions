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

    private int deapthOfX = -1;
    private int deapthOfY = -1;
    private int parentOfX = -1;
    private int parentOfY = -1;
    private boolean gotX = false;
    private boolean gotY = false;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.val == x || root.val == y) {
            return false;
        }
        isCousins(root, null, 0, x, y);
        return deapthOfX == deapthOfY && parentOfX != parentOfY;
    }

    public void isCousins(TreeNode root, TreeNode parent, int currentDepth, int x, int y) {

        if (gotX && gotY) {
            return;
        }
        if (root.val == x) {
            gotX = true;
            deapthOfX = currentDepth;
            parentOfX = parent.val;
        }
        if (root.val == y) {
            gotY = true;
            deapthOfY = currentDepth;
            parentOfY = parent.val;
        }
        if (root.left != null) {
            isCousins(root.left, root, currentDepth + 1, x, y);
        }
        if (root.right != null) {
            isCousins(root.right, root, currentDepth + 1, x, y);
        }
    }

}

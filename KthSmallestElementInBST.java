class Solution {

    public int kthSmallest(TreeNode root, int k) {
        Stack<Integer> stack = new Stack<>();
        traverseAndFillTheStack(root, stack, k);
        return stack.peek();
    }

    public void traverseAndFillTheStack(TreeNode root, Stack < Integer > stack, int k) {
        if (root == null || stack.size() >= k) {
            return;
        }
        traverseAndFillTheStack(root.left, stack, k);
        if (stack.size() < k) {
            stack.push(root.val);
        }
        traverseAndFillTheStack(root.right, stack, k);
    }
}

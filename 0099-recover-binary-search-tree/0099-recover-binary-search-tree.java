class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode first = null, second = null, prev = null;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            if (prev != null && prev.val > curr.val) {
                if (first == null) {
                    first = prev;
                }
                second = curr;
            }

            prev = curr;
            curr = curr.right;
        }

        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}
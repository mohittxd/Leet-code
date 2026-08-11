class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; // empty tree
        dp[1] = 1; // single node
        
        for (int nodes = 2; nodes <= n; nodes++) {
            for (int root = 1; root <= nodes; root++) {
                int left = root - 1;          // nodes available for left subtree
                int right = nodes - root;     // nodes available for right subtree
                dp[nodes] += dp[left] * dp[right];
            }
        }
        
        return dp[n];
    }
}
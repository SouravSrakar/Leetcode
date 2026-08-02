class Solution {

    Integer[][] dp;

    public boolean predictTheWinner(int[] nums) {

        int n = nums.length;
        dp = new Integer[n][n];

        return solve(nums, 0, n - 1) >= 0;
    }

    private int solve(int[] nums, int left, int right) {

        // Only one element left
        if (left == right) {
            return nums[left];
        }

        // Already computed
        if (dp[left][right] != null) {
            return dp[left][right];
        }

        // Pick left
        int pickLeft = nums[left] - solve(nums, left + 1, right);

        // Pick right
        int pickRight = nums[right] - solve(nums, left, right - 1);

        // Store the maximum score difference
        dp[left][right] = Math.max(pickLeft, pickRight);

        return dp[left][right];
    }
}
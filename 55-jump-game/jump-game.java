class Solution {

    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        return helper(nums, 0, dp);
    }

    private boolean helper(int[] nums, int index, Boolean[] dp) {
        if (index >= nums.length - 1) {
            return true;
        }
        if (nums[index] == 0) {
            return false;
        }
        if (dp[index] != null) {
            return dp[index];
        }
        for (int jump = 1; jump <= nums[index]; jump++) {
            if (helper(nums, index + jump, dp)) {
                dp[index] = true;
                return true;
            }
        }

        dp[index] = false;
        return false;
    }
}

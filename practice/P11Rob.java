package practice;

public class P11Rob {
    /*
    No.198 house-robber
    1 2 3 1 不能访问相邻元素，求和的最大值，1+3=4
    典型的动态规划问题，下一个状态受到前一个和更加前一个的影响
    状态定义为到达索引i时最大的金额，要么是索引i-1的金额，要么是索引i-2的金额加上当前金额
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int res = new P11Rob().rob(nums);
        System.out.println(res);
    }
}

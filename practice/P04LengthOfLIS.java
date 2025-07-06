package practice;

import java.util.Arrays;

public class P04LengthOfLIS {
    /*
    No.300 longest-increasing-subsequence
    [1,3,6,7,9,4,10,5,6]
    1,3,6,7,9,10
    subsequence是指可以删除里面的部分元素，但顺序不变，要找到最长递增子序列的长度
    和前面的coin change类似，也是可以通过前面所有长度更短的长度推导出长度更长的情况
    例如对于1 3 6 7 9 4，讨论其最长的长度，最后的4要么参与要么不参与，如果参与，需要比上一个更大，即在索引0 1的基础上可以+1
    如果不参与，那么4实际上就对于最长长度没有贡献，另外也没有参与到最长的长度计算中
    所以length[]中应该维护当前索引i参与的情况下，最长递增子序列的长度
     */
    public int lengthOfLIS(int[] nums) {
        int[] length = new int[nums.length];
        Arrays.fill(length, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    length[i] = Math.max(length[i], length[j] + 1);
                }
            }
            max = Math.max(max, length[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};
        int res = new P04LengthOfLIS().lengthOfLIS(nums);
        System.out.println(res);
    }
}

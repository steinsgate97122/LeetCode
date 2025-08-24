package practice;

public class P35MinSubArrayLen {
    /*
    No.209 minimum-size-subarray-sum
    input: 正整数数组nums、目标正整数target
    output: 总和大于等于nums的长度最小的子数组长度，如果不存在就返回0
    滑动窗口的经典题目，分成左右指针，当前和小于target时右指针加，大于等于target时左指针加
    左指针加之前记录当前长度，动态维护最小长度即可，特殊case就是左指针一直没动就是0
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = nums[left], result = nums.length + 1;
        while (true) {
            if (sum < target) {
                right++;
                if (right == nums.length) {
                    break;
                }
                sum += nums[right];
            } else {
                int length = right - left + 1;
                result = Math.min(result, length);
                sum = sum - nums[left];
                left++;
            }
        }
        if (left == 0) {
            return 0;
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(new P35MinSubArrayLen().minSubArrayLen(7, nums));
    }
}

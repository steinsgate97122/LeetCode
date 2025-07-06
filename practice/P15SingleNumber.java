package practice;

public class P15SingleNumber {
    /*
    No.136 single-number
    要求用O(n)的时间复杂度 O(1)的空间复杂度 已知数组中1个元素出现1次，其他元素都出现2次
    这个比较trick，需要用异或运算，n异或n等于0，0异或n等于n，所以所有数据异或一下就能出答案
    java中 ^ 代表异或，而不是表示数学中的power
     */
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        int res = new P15SingleNumber().singleNumber(nums);
        System.out.println(res);
    }
}

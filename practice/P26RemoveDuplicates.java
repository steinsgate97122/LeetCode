package practice;

import java.util.Arrays;

public class P26RemoveDuplicates {
    /*
    No.26 remove-duplicates-from-sorted-array
    nums数组内的元素保证单调递增，需要原地删除重复元素，元素的相对顺序保持一致，返回前k个元素的个数
    eg: [0,0,1,1,1,2,2,3,3,4]  output: 5 [0,1,2,3,4]
    遍历一次即可，出现不同元素时填入对应位置
     */
    public int removeDuplicates(int[] nums) {
        int i = 1, prev = nums[0];
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != prev) {
                nums[i] = nums[j];
                i++;
                prev = nums[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int k = new P26RemoveDuplicates().removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}

package practice;

import java.util.Arrays;

public class P27RemoveDuplicates {
    /*
    No.80 remove-duplicates-from-sorted-array-ii
    input:  [0,0,1,1,1,1,2,3,3]
    output: [0,0,1,1,2,3,3]
    input具有单调性，要求对出现次数超过2次的元素仅保留2次，出现次数为1次的还是1次
    0 1 2 3 或者 0 0 1 1 2 2这种模式完全不需要处理，需要处理的是1 1 1这种模式
    用0到left的部分表示已经处理好且满足要求的片段，right表示当前遍历的待加入的元素
    如果right与left-2的元素相同，那么right不能加进去，需要继续往后查看；如果不同，那么就能加进去
    用right扫描完整个数组后，得到的left指向末尾索引+1，即元素个数
    上面的前提是元素个数>=2，小于2的时候直接返回
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int left = 2;
        for (int right = 2; right < nums.length; right++) {
            if (nums[right] != nums[left - 2]) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = new P27RemoveDuplicates().removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}

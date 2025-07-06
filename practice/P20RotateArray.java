package practice;

import java.util.Arrays;

public class P20RotateArray {
    /*
    No.189 rotate-array
    nums = [1,2,3,4,5,6,7], k = 3,  向右边轮转3次，变成5 6 7 1 2 3 4
    显然，对于上面这个长度为7的array，k=7时相当于没转，k=8和k=1等效
    题目中保证k为正数，那么直接用 (k % len)来处理逻辑即可
    k=3的时候，是将数组 [arr.length - k, arr.length) 移动到了0索引开始
    然后将0索引开始的元素挪到了从k开始
     */
    public void rotateV1(int[] nums, int k) {
        k = k % nums.length;
        int[] tmp = new int[nums.length];
        System.arraycopy(nums, nums.length - k, tmp, 0, k);
        System.arraycopy(nums, 0, tmp, k, nums.length - k);
        System.arraycopy(tmp, 0, nums, 0, nums.length);
    }

    /*
    再写一个原地rotate的版本
    对于nums = [1,2,3,4,5,6,7], k = 3，如果将1 2 3 4看作一个整体，5 6 7看作一个整体
    实际上就是对这两部分顺序进行了翻转，如果原地翻转整个数组，那么7 6 5对应索引0 1 2，实际上已经成功了一半
    之后只要将这两部分内部再进行一次翻转即可
    即先整体翻转为[7 6 5 4 3 2 1]，然后内部翻转为[5 6 7 1 2 3 4]
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
    }

    private void reverseArray(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        new P20RotateArray().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}

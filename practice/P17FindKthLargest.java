package practice;

import java.util.Random;

public class P17FindKthLargest {
    /*
    No.215 kth-largest-element-in-an-array
    [3 2 1 5 6 4] 第二大的元素是5, 重复元素也计算进去
    最naive的方法就是先排序，不过这样复杂度变成nlogn不满足要求
    最大值的问题考虑用heap？先维护一个max堆，然后弹出k次，复杂度也是nlogn，维持堆结构比较费时间
    用快排的思路？快排本身是nlogn，不过每次partition操作都可以锁定一个位置，如果刚好锁定了k，那么复杂度就很低
    另外也不再需要左右递归调用，只需要调用包含k的那一边就行
     */
    public int findKthLargest(int[] nums, int k) {
        // k = 1, 索引nums.length - 1  k = 2, 索引nums.length - 2
        k = nums.length - k;
        return findKthSmallest(nums, k, 0, nums.length - 1);
    }

    private int findKthSmallest(int[] nums, int k, int left, int right) {
        int pivotIndex = partition(nums, left, right);
        while (pivotIndex != k) {
            if (pivotIndex < k) {
                pivotIndex = partition(nums, pivotIndex + 1, right);
            } else {
                pivotIndex = partition(nums, left, pivotIndex - 1);
            }
        }
        return nums[pivotIndex];
    }

    /*
    改成Lomuto分区，直接随机选择pivot，先放在最后，等前面的交换完成后再放到目标位置
     */
    private int partition(int[] nums, int left, int right) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt(right - left + 1) + left;
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, right); // 把 pivot 放到最后

        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) { // 小于 pivot 的放左边
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        swap(nums, storeIndex, right); // 把 pivot 放回中间
        return storeIndex;
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int res = new P17FindKthLargest().findKthLargest(nums, 1);
        System.out.println(res);
    }
}

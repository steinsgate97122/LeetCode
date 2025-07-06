package practice;

import java.util.Arrays;

public class P25RemoveElement {
    /*
    No.27 remove-element
    在数组nums中移除val，需要让nums中不为val的k个值都放在前面，这k个值可以任意顺序
    nums = [0,1,2,2,3,0,4,2], val = 2, 返回5, nums的前5个元素为0 1 3 0 4
    因为保留的k个值可以是任意顺序，那么从前往后遍历需要remove的元素，从后往前遍历不需要remove的元素
    当这两个指针相遇时就完成任务，并且这个位置就是有效元素的截止位置
    如果剩下的k个元素需要保持原先顺序，那么就类似选择排序，从前往后遍历，选择合法元素放在当前位置
    假设nums中只有第0个元素需要删掉，选择排序的这种方法的交换次数会多出很多，所以还是前后指针的效率高一点
     */
    public int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length - 1, k = 0;
        while (true) {
            while (left < nums.length && nums[left] != val) {
                left++;
                k++;
            }
            while (right >= 0 && nums[right] == val) {
                right--;
            }
            if (left < right) {
                swap(nums, left, right);
            } else {
                break;
            }
        }
        return k;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int k = new P25RemoveElement().removeElement(nums, 2);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}

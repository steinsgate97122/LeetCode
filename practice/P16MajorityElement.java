package practice;

public class P16MajorityElement {
    /*
    No.169 majority-element
    [3 2 3] 返回3  多数元素指出现频率高于n/2的元素
    naive idea就是维护一个hashmap，value是频率，出现频率大于n/2的就返回，但这个空间占太多了
    clever idea利用了出现次数高于n/2的特性，直接变成消消乐，最后能剩下的就是多数元素
     */
    public int majorityElement(int[] nums) {
        int majEle = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                majEle = nums[i];
                count++;
            } else {
                if (majEle == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return majEle;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,3};
        int element = new P16MajorityElement().majorityElement(nums);
        System.out.println(element);
    }
}

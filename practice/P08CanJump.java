package practice;

public class P08CanJump {
    /*
    No.55 jump-game
    2 3 1 1 4, 索引i对应的值j代表最远能跳j，从0索引跳1，然后跳3就到达末尾
    索引0，最远跳到0+nums[0]=2，然后看索引1和2最远能到的距离，看能不能到最后一个索引即可
     */
    public boolean canJump(int[] nums) {
        int largestIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > largestIndex) {
                return false;
            }
            largestIndex = Math.max(largestIndex, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        boolean res = new P08CanJump().canJump(nums);
        System.out.println(res);
    }
}

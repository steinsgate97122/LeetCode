package practice;

public class P09Jump {
    /*
    No.45 jump-game-ii
    2 3 1 1 4, 从0索引跳1，然后跳3就到达末尾，最少需要跳2次，返回2，题目保证可以跳到结尾
    索引0，最远跳到0+nums[0]=2，即跳1次最远能到索引2
    然后看索引2之前最远能到哪里，就是跳2次最远能到的距离
     */
    public int jump(int[] nums) {
        int largestIndex = 0, jumpCount = 0, curMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curMax = Math.max(curMax, i + nums[i]);
            if (i == largestIndex) {
                jumpCount++;
                largestIndex = curMax;
            }
        }
        return jumpCount;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int res = new P09Jump().jump(nums);
        System.out.println(res);
    }
}

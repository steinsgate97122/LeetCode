package practice;

import java.util.Arrays;

public class P03CoinChange {
    /*
    No.322 coin-change
    coins表示可用的硬币字典，amount是需要凑齐的总金额，求凑集所需的最少硬币数
    本质上就是一个背包问题，可以用类似动态规划的方式处理，核心是状态需要使用金额数从小到大
    要求amount对应的最少硬币数，那么可能使用coins里面的各种硬币，遍历这些硬币，剩余金额的最少硬币数如果已知，遍历一次之后就知道amount的最少数量
    所以从小到大维护amountCoin即可，如果扣除硬币后为负数那么说明这个硬币不可能参与到amount里面
     */
    public int coinChange(int[] coins, int amount) {
        int[] amountCoin = new int[amount + 1];
        Arrays.fill(amountCoin, Integer.MAX_VALUE);
        amountCoin[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin && amountCoin[i - coin] != Integer.MAX_VALUE) {
                    amountCoin[i] = Math.min(amountCoin[i], amountCoin[i - coin] + 1);
                }
            }
        }
        return (amountCoin[amount] == Integer.MAX_VALUE) ? -1 : amountCoin[amount];
    }

    public static void main(String[] args) {
        int[] coins = {3};
        int res = new P03CoinChange().coinChange(coins, 2);
        System.out.println(res);
    }
}

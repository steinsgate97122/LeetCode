package practice;

public class P07MaxProfit {
    /*
    No.121 best-time-to-buy-and-sell-stock
    7,1,5,3,6,4 价格1买入，价格6卖出，利润为5
    用贪心策略，当前利润为0，碰见一个价格就买入，如果当前价格小于买入价格，那么更新买入价格
    如果当前价格高于买入价格，就更新利润
     */
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0], profit = 0;
        for (int price : prices) {
            if (price > buyPrice) {
                profit = Math.max(profit, price - buyPrice);
            } else {
                buyPrice = price;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int res = new P07MaxProfit().maxProfit(prices);
        System.out.println(res);
    }
}

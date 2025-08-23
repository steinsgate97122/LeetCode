package practice;

public class P28MaxProfitTwo {
    /*
    No.122 best-time-to-buy-and-sell-stock-ii
    7,1,5,3,6,4 价格1买入，价格5卖出，价格3买入，价格6卖出，总利润7
    只要出现递增就累加上去，递减就不持有，这种情况下利润最高
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int res = new P28MaxProfitTwo().maxProfit(prices);
        System.out.println(res);
    }
}

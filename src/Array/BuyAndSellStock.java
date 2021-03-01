package Array;

public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }

    //[7,1,5,3,6,4]

    public int maxProfitInConstantTime(int[] prices) {
        int maxProfit = 0;
        int minimumPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (minimumPrice > prices[i])
                minimumPrice = prices[i];
            else if (prices[i] - minimumPrice > maxProfit)
                maxProfit = prices[i] - minimumPrice;
        }
        return maxProfit;
    }
}

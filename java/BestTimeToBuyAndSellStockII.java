package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2020-02-06
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                result += prices[i + 1] - prices[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(prices));
    }
}

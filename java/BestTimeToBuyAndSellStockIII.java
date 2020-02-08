package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2020-02-07
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        // 看的答案，没怎么懂。。
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] local = new int[3];
        int[] global = new int[3];
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            for (int j = 2; j >= 1; j--) {
                if (diff > 0) {
                    local[j] = Math.max(local[j] + diff, global[j - 1] + diff);
                } else {
                    local[j] = Math.max(local[j] + diff, global[j - 1]);
                }
                global[j] = Math.max(local[j], global[j]);
            }
        }
        return global[2];
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(prices));
    }
}

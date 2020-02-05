package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2020-02-05
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int price: prices) {
            min = Math.min(price, min);
            result = Math.max(price - min, result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));
    }
}

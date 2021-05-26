package com.sekhar.coding;

public class BestTimeToBuyAndSellStock3 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int[] leftProfits = new int[prices.length];
        int[] rightProfits = new int[prices.length + 1];
        int leftMin = prices[0];
        int rightMax = prices[prices.length - 1];
        leftProfits[0] = 0;
        rightProfits[prices.length] = 0;
        for (int i = 1; i < prices.length; i++) {
            leftProfits[i] = Math.max(prices[i] - leftMin, leftProfits[i - 1]);
            if (leftMin > prices[i])
                leftMin = prices[i];
            int rIndex = prices.length - i - 1;
            rightProfits[rIndex] = Math.max(rightMax - prices[rIndex], rightProfits[i + 1]);
            if (rightMax < prices[rIndex])
                rightMax = prices[rIndex];
        }
        for (int i = 0; i < prices.length; i++)
            maxProfit = Math.max(maxProfit, leftProfits[i] + rightProfits[i + 1]);
        return maxProfit;
    }
}

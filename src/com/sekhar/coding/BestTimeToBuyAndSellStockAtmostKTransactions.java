package com.sekhar.coding;

public class BestTimeToBuyAndSellStockAtmostKTransactions {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        if (k <= 0 || n <= 0)
            return 0;
        if (2 * k > n) {
            for (int i = 0; i < n - 1; i++)
                maxProfit += Math.max(0, prices[i + 1] - prices[i]);
            return maxProfit;
        }
        int[][][] optimalSubstructure = new int[n][k + 1][2];
        for (int i = 0; i < n; i++)
            for (int j = 0 ;j <= k; j++){
                optimalSubstructure[i][j][0] = -1111111111;
                optimalSubstructure[i][j][1] = -1111111111;
            }
        optimalSubstructure[0][0][0] = 0;
        optimalSubstructure[0][1][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                optimalSubstructure[i][j][0] = Math.max(optimalSubstructure[i - 1][j][0], optimalSubstructure[i - 1][j][1] + prices[i]);
                if (j > 0)
                    optimalSubstructure[i][j][1] = Math.max(optimalSubstructure[i - 1][j][1], optimalSubstructure[i - 1][j - 1][0] - prices[i]);
            }
        }
        for (int i = 0; i <= k; i++)
            maxProfit = Math.max(maxProfit, optimalSubstructure[n -1][i][0]);
        return maxProfit;
    }
}

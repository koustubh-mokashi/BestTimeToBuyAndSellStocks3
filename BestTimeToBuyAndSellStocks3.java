class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit[] = new int[n];
		for (int i = 0; i < n; i++)
			profit[i] = 0;

		int maxPrice = prices[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (prices[i] > maxPrice)
				maxPrice = prices[i];
			profit[i] = Math.max(profit[i + 1], maxPrice - prices[i]);
		}

		int min_price = prices[0];
		for (int i = 1; i < n; i++) {
			if (prices[i] < min_price)
				min_price = prices[i];

			profit[i] = Math.max(profit[i - 1], profit[i] + (prices[i] - min_price));
		}
		int result = profit[n - 1];
		return result;
    }
}

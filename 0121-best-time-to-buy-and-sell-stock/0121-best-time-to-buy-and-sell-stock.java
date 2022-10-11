class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i=0; i<prices.length; i++){
            //if the current iteration value is smaller than min only then update min to currentElement
            if(prices[i] < minPrice)
                minPrice = prices[i];
            //If the profit is greater than proft value we update profit to bigger profit
            else if(prices[i] - minPrice > maxprofit)
                //Profit formula
                maxprofit = prices[i] - minPrice;
        }
        return maxprofit;
    }
}
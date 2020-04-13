package practice;

public class BuySellStock {

	public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int[] profit = new int[prices.length];
        
        if(prices.length>1) {
        		for(int i=0;i<prices.length;i++) {
        			profit[i]=0;
        			for(int j=1;j<prices.length;j++) {
        				profit[i] = Math.max(profit[i], prices[j]-prices[i]);
        				if(maxProfit<profit[i]) {
        					maxProfit = profit[i];
        				}
        			}
        		}
        }
        
        return maxProfit;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

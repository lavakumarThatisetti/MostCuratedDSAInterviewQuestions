package arrays;

public class BuyAndSellStock_121 {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice = prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<buyPrice){
                buyPrice = prices[i];
            }
            else if(prices[i] - buyPrice > maxProfit){
                maxProfit = prices[i] - buyPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] array = {7,1,5,3,6,4};
        System.out.println(maxProfit(array));
    }
}

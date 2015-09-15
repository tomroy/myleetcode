package com.tomroy;

/**
 * Created by tom_th_lin on 2015/7/28.
 * <br>Say you have an array for which the i-th element is the price of a given stock on day i.
 *
 * <br>If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class BestTimetoBuyandSellStock {

  public static int maxProfit(int[] prices) {

    int max = 0,min = 0,maxProfit = 0;
    boolean first = true;

    for(int i : prices) {
      if(first) {
        max = i;
        min = i;
        first = false;
      }
      if(i < min) {
        max = 0;
        min = i;
      } else if (i > max) {
        max = i;
        maxProfit = max-min > maxProfit? max-min : maxProfit;
      }

      System.out.println("maxProfit(" + i + ")=" + maxProfit + " min:" + min + ",max:" + max);
    }
    System.out.println("min = " + min);
    System.out.println("max = " + max);
    return maxProfit;
  }

  public static void main(String[] args) {

    int[] array = {2,1,2,1,0,1,2};
    System.out.println("maxProfit=" + maxProfit(array));
  }
}

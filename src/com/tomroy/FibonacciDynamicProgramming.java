package com.tomroy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tom_th_lin on 2015/10/12.
 * Reference from:
 * http://emn178.pixnet.net/blog/post/91987861-%E8%B2%BB%E6%B3%A2%E9%82%A3%E8%A5%BF%E6%95%B8%E5%88%97(fibonacci)
 */
public class FibonacciDynamicProgramming {
  static Map<Integer, Long> map = new HashMap<Integer, Long>() {{put(0,0L);put(1,1L);}};

  public static long Fibonacci(int n) {
    if (map.containsKey(n)) {
      return map.get(n);
    }
    map.put(n, Fibonacci(n - 1) + Fibonacci(n - 2));
    return map.get(n);
  }

  public static void main(String[] args) {
    int n = 10;
    for(int i = 0;i < n; ++i)
      System.out.print(Fibonacci(i) + " ");
  }
}

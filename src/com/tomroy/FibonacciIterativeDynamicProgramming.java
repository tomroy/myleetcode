package com.tomroy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tom_th_lin on 2015/10/12.
 */
public class FibonacciIterativeDynamicProgramming {

  public static long Fibonacci(int n) {
    Map<Integer, Long> map = new HashMap<Integer, Long>() {{put(0,0L);put(1,1L);}};

    for(int i = 2; i <= n; ++i) {
      map.put(i, map.get(i - 1) + map.get(i - 2));
    }
    return map.get(n);
  }

  public static void main(String[] args) {
    int n = 10;
    for(int i = 0;i < n; ++i)
      System.out.print(Fibonacci(i) + " ");
//    long now = System.nanoTime();
//    System.out.println(Fibonacci(100));
//    long duration = System.nanoTime() - now;
//    System.out.println("dr = " + duration + " ns");
  }
}

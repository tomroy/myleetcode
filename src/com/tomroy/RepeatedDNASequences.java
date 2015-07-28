package com.tomroy;

import java.util.*;

/**
 * Created by tom_th_lin on 2015/7/28.
 * <br>
 * <br>https://leetcode.com/problems/repeated-dna-sequences/
 * <br>Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * <br>
 * <br>Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * <br>
 * <br>Return:
 * <br>    ["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class RepeatedDNASequences {

  public static List<String> findRepeatedDnaSequences(String s) {

    List<String> list = new LinkedList<>();
    Map<String, Integer> map = new HashMap<>();
    Set<String> set = new HashSet<>();

    int count = s.length() - 10 + 1;
    for(int i = 0; i < count;i++) {
      String repeated = s.substring(i,i + 10);
      if(null != map.get(repeated))
        set.add(repeated);
      else
        map.put(repeated,1);
    }
    list.addAll(set);

    return list;
  }

  public static void main(String[] args) {

    String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    List<String> list = findRepeatedDnaSequences(s);
    System.out.println(list.toString());

  }

}

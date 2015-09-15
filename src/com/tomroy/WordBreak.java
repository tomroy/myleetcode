package com.tomroy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tom_th_lin on 2015/8/20.
 *
 <br>Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 <br>
 <br> For example, given
 <br>s = "leetcode",
 <br>dict = ["leet", "code"].
 <br>
 <br>Return true because "leetcode" can be segmented as "leet code".
 <br>https://leetcode.com/problems/word-break/
 */

public class WordBreak {
  public static boolean wordBreak(String s, Set<String> wordDict) {

    if(s.length() > 1) {
      for (int i = 0; i < s.length(); i++) {
        String a = s.substring(0, i);
        String b = s.substring(i, s.length());
      if(wordDict.contains(a) && wordDict.contains(b))
        return true;
      }
    } else {
      for (String word : wordDict) {
        if(s.contains(word))
          return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    String s = "abcd";
    Set<String> wordDict = new HashSet<>(Arrays.asList("a","abc","b","cd"));

    boolean answer = wordBreak(s,wordDict);
    System.out.println(answer);
  }
}

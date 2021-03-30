package com.mylearning.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenerateParantheses {

  public static void main(String[] args) {
    int n = 3;
    List<String> result = new ArrayList<>();
    generateParenthesis(result, "", 0, 0, n);
    result.stream().forEach(s -> System.out.println(s));
  }

  public static void generateParenthesis(List<String> result, String s, int open, int close, int n ) {
    if (s.length() == n * 2) {
      result.add(s);
      return;
    }
    if (open < n) {
      generateParenthesis( result, s + "(", open + 1, close, n);
    }
    if (close < open) {
      generateParenthesis(result, s + ")", open, close + 1, n);
    }
  }

  void gen(List<String> result, StringBuffer buf, int l, int r) {
    if(l < 1 && r < 1) {
      // done
      result.add(buf.toString());
      return;
    }
    if(l > 0) {
      buf.append("(");
      gen(result, buf, l-1, r);
      buf.setLength(buf.length()-1);
    }
    if(r > 0 && l < r) {
      buf.append(")");
      gen(result, buf, l, r-1);
      buf.setLength(buf.length()-1);
    }
  }
}

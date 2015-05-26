package com.tomroy;


import java.util.Arrays;

public class MultiplyStrings {

    public static String multiply(String num1, String num2) {

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        String x = new StringBuilder(num1).reverse().toString();
        String y = new StringBuilder(num2).reverse().toString();
        char[] A = x.toCharArray();
        char[] B = y.toCharArray();
        int[] ansInt = new int[num1.length() + num2.length()];

        for(int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int index = i+j;
                int tmpAns = ansInt[index];
                tmpAns += (Character.getNumericValue(A[i]) * Character.getNumericValue(B[j]));
                if(tmpAns >= 10) {
                    ansInt[index+1] = ansInt[index+1] + tmpAns/10;
                    ansInt[index] = tmpAns%10;
                }
                else
                ansInt[index] = tmpAns;
            }
        }

        for(int i = 0; i < ansInt.length / 2; i++)
        {
            int temp = ansInt[i];
            ansInt[i] = ansInt[ansInt.length - i - 1];
            ansInt[ansInt.length - i - 1] = temp;
        }
        System.out.println(Arrays.toString(ansInt));
        String opt = "";
        boolean leftHead = true;
        for(int i : ansInt) {
            if(leftHead) {
                if(i == 0) {

                }
                else {
                    opt += i;
                    leftHead = false;
                }
            } else
                opt += i;
        }
        return opt == "" ? "0" : opt;
    }

    public static void main(String[] args) {
        System.out.println(multiply("100","5"));
    }
}

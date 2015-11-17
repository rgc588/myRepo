package com.chengong.algorithm;

/**
 * Created by chengong on 11/9/15.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int[] rst = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            int v1 = num1.charAt(i) - '0';
            int c = 0;
            int j = num2.length() - 1;
            for (; j >= 0; j--) {
                int v2 = num2.charAt(j) - '0';
                rst[i + j + 1] = c + rst[i + j + 1] + v1 * v2;
                c = rst[i + j + 1] / 10;
                rst[i + j + 1] %= 10;
            }
            rst[i + j + 1] = c;
        }

        StringBuilder sb = new StringBuilder();

        int index = 0;
        while(index < rst.length - 1 && rst[index] == 0) {
            index++;
        }

        for(int i = index; i < rst.length; i++) {
            sb.append((char)('0' + rst[i]));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings test = new MultiplyStrings();
        String num1 = "123";
        String num2 = "345";

        String num3 = test.multiply(num1, num2);

        System.out.println(num3);
    }
}

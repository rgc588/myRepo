package com.chengong.algorithm;

/**
 * Created by chengong on 3/7/14.
 */
public class PalindromeNumber {

    public static boolean isPalindrome(int inputNumber){
        if (inputNumber < 0) return false;
        if (inputNumber == 0) return true;
        int digitsNumber = 0;
        int copyOfInput = inputNumber;
        while(copyOfInput > 0){
            copyOfInput = copyOfInput/10;
            digitsNumber++;
        }

        return recursive(inputNumber, digitsNumber);
    }

    private static boolean recursive(int inputNumber, int digitsNumber){
        if(digitsNumber < 2) return true;
        int lowDigit = getLowDigit(inputNumber);
        int highDigit = getHighDigit(inputNumber, digitsNumber);
        int multi = 1;
        for(int i = 0; i < digitsNumber - 1; i++){
            multi = multi*10;
        }
        if(lowDigit == highDigit){
            int newNumber = (inputNumber - lowDigit - highDigit*multi)/10;
            return recursive(newNumber, digitsNumber - 2);
        }
        return false;
    }

    private static int getLowDigit(int inputNumber){
        return inputNumber%10;
    }

    private static int getHighDigit(int inputNumber, int digitsNumber){
        for(int i = 0; i < digitsNumber - 1; i++){
            inputNumber = inputNumber/10;
        }
        return inputNumber;
    }
}

package com.company.array;

import java.util.Arrays;

public class DuplicateZeros {
    public static void duplicateZeros(int[] arr) {
        int countZero = 0;
        int i, j, len=arr.length;
        for (i = 0; i + countZero < len; i++) {
            if (arr[i] == 0) countZero++;
        }
        //Get rid of the last zero if we have no space to fit it twice
        if (i + countZero > len) {
            arr[len-1] = 0; countZero--; len--;
        }
        //We just need O(1) space if we scan from back
        //i point to the original array, j point to the new location
        for (i = len - 1 - countZero, j = len - 1; i >= 0 && countZero > 0; i--, j--) {
            if (arr[i] == 0) {
                arr[j--] = 0;  // extra 0 when hit '0'
                countZero--;
            }
            arr[j] = arr[i];
        }
    }
    public static void main(String args[]){
        int[] a={1,0,2,3,0,4,5,0};
        duplicateZeros(a);
        System.out.println(Arrays.toString(a));
    }
}

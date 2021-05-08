package com.company;

public class Main {

    public static void main(String[] args) {
	int[] input={4725,4586,1330,8792,1594,5729};
	radixSort(input,10,4);
	for(int i=0;i< input.length;i++)
	    System.out.println(input[i]);
    }
    //  loop for traversing through position
    private static void radixSort(int[] input, int radix, int width) {
        for(int position=0;position< width;position++)
            radixSingleSort(input,position,radix);
    }
    //  loop for calculating countArray for input array
    private static void radixSingleSort(int[] input, int position, int radix) {
        int numItems= input.length;
        int[] countArray=new int[radix];
        for(int value : input)
            countArray[getDigit(position,value,radix)]++;
        //adjust the countArray
        for(int j=1;j<radix;j++)
            countArray[j]+=countArray[j-1];
        int[] temp=new int[numItems];
        for (int tempIndex=numItems-1;tempIndex>=0;tempIndex--)
            temp[--countArray[getDigit(position,input[tempIndex],radix)]]=input[tempIndex];
        for(int i=0;i<numItems;i++)
            input[i]=temp[i];
    }

    private static int getDigit(int position, int value, int radix) {
        return value/(int)Math.pow(10,position)%radix;
    }
}

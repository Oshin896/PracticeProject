package com.company;

public class Main {

    public static void main(String[] args) {
	String input[]={"bcdef","dbaqc","abcde","omadd","bbbbb"};
	radixSort(input,5,26);
	for(int i=0;i<input.length;i++)
	    System.out.println(input[i]);
    }

    private static void radixSort(String[] input, int length, int radix) {
        for(int i=length-1;i>=0;i--)
            radixSingleSort(input,radix,i);
    }

    private static void radixSingleSort(String[] input, int radix, int pos) {
        int num_items= input.length;
        int[] temp=new int[radix];
        for(int i=0;i<num_items;i++){
            temp[getCorrectArrayIndex(input[i],pos)]++;
        }
        for (int i=1;i<radix;i++){
            temp[i]+=temp[i-1];
        }
        String newtemp[]=new String[num_items];
        for(int i=num_items-1;i>=0;i--){
            newtemp[--temp[getCorrectArrayIndex(input[i],pos)]]= input[i];
        }
        for (int i=0;i<num_items;i++)
            input[i]=newtemp[i];
    }

    private static int getCorrectArrayIndex(String s,int pos) {
        char c=s.charAt(pos);
        return (int)((int)c-97);
    }


}

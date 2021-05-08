package com.company;

public class Main {

    public static void main(String[] args) {
	int input[]={2,5,9,8,2,8,7,10,4,3};
	countingSort(input,1,10);
	for(int i=0;i< input.length;i++)
	    System.out.println(input[i]);
    }

    private static void countingSort(int[] input, int min, int max) {
        int countArray[]=new int[max-min+1];
        for(int i=0;i<input.length;i++)
            countArray[input[i]-min]++;
       int j=0;
        for(int i=min;i<=max;i++){
            while (countArray[i-min]>0){
                input[j++]=i;
                countArray[i-min]--;
            }

        }
    }
}

package com.company;

public class Main {

    public static void main(String[] args) {
	int input[] ={7,6,5,4,3,2,1};
	insertionSortRec(input,input.length);

	for(int i=0;i< input.length;i++)
	    System.out.println(input[i]);
    }

    private static void insertionSortRec(int[] input,int length) {
        if(length<2)
            return;
        insertionSortRec(input,length-1);
        int newElement=input[length-1];
        int i=length-1;
        while(i>0 && input[i-1]>newElement) {
            input[i] = input[i - 1];
            i--;
        }
        input[i]=newElement;
    }

}

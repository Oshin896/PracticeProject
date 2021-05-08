package com.company;

public class Main {

    public static void main(String[] args) {
	 int input[]={1,2,3,4,5,6};
        mergeSortDesc(input,0,input.length);
        
        for(int i=0;i< input.length;i++)
            System.out.println(input[i]);
    }

    private static void mergeSortDesc(int[] input, int start, int end) {
            if(end-start<2)
                return;
            int mid=(start+end)/2;
            mergeSortDesc(input,start,mid);
            mergeSortDesc(input,mid,end);
            merge(input,start,mid,end);
    }

    private static void merge(int[] input, int start, int mid, int end) {
        if(input[mid]<=input[mid-1])
            return;
        int temp[]=new int[(end-start)];
        int i=start;
        int j=mid;
        int k=0;
        while (i<mid && j<end){
            if (input[i] >= input[j]) {
                temp[k++]=input[i++];
            }
            else
                temp[k++]=input[j++];
        }
        System.arraycopy(input,i,input,start+k,mid-i);
        System.arraycopy(temp,0,input,start,k);

    }
}

package com.company;

public class Main {

    public static void main(String[] args) {
        int arr[]={ 20, 35, -15, 7, 55, 1, -22 };

        mergeSort(arr,0, arr.length);
        for(int i=0;i< arr.length;i++)
            System.out.println(arr[i]);
    }
    public static  void mergeSort(int arr[],int startIndex,int lastIndex){
        if(lastIndex-startIndex<2)
            return;
        int mid=(startIndex+lastIndex)/2;
        mergeSort(arr,startIndex,mid);
        mergeSort(arr,mid,lastIndex);
        merge(arr,startIndex,mid,lastIndex);
    }

    private static void merge(int[] arr, int startIndex, int mid, int lastIndex) {
        if(arr[mid-1]<=arr[mid])
            return;
        int i=startIndex;
        int j=mid;
        int tempIndex=0;
        int temp[]=new int[startIndex+lastIndex];
        while (i<mid && j<lastIndex)
            temp[tempIndex++]=arr[i]<arr[j]?arr[i++]:arr[j++];
        System.arraycopy(arr,startIndex,arr,startIndex+tempIndex,mid-i);
        System.arraycopy(temp,0,arr,startIndex,tempIndex);
    }
}

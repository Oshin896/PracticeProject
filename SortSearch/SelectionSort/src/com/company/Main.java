package com.company;

public class Main {

    public static void main(String[] args) {
        int arr[]={ 20, 35, -15, 7, 55, 1, -22 };

        for(int i = arr.length-1; i>0 ;i--){
            int largest=0;
            for(int j=1;j<=i;j++){
                if(arr[j]>arr[largest])
                    largest=j;
            }
            swap(arr,largest,i);
        }

        for (int i=0;i< arr.length;i++)
            System.out.println(arr[i]);

    }

    public static void swap(int arr[],int a, int b){
        if(a==b)
            return;
        int temp;
        temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}

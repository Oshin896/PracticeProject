package com.company;

public class Main {

    public static void main(String[] args) {
        int arr[]={ 20, 35, -15, 7, 55, 1, -22 };
        int temp;
for(int firstUnsortedIndex = 1; firstUnsortedIndex< arr.length;firstUnsortedIndex++){
    temp=arr[firstUnsortedIndex];
    int i;
    for(i=firstUnsortedIndex;i>0 && arr[i-1]>temp;i--){
        arr[i]=arr[i-1];
    }
arr[i]=temp;
}

        for (int i=0;i< arr.length;i++)
            System.out.println(arr[i]);

    }
}

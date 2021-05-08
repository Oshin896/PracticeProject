package com.company.bitonicArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BitonicArray {
    public static int findBitonic(List<Integer> arr, int element) {
        int n=arr.size(),l=0,r=n-1;

        int index=findBitonicIndex(arr,n,l,r);
        return index;
    }

    public static int findSearchElement(List<Integer> arr, int n, int l, int r, int element,int index) {
        int search_index=0;
        if(element == arr.get(index))
                return index;
            else if(element> arr.get(index))
                return -1;
            else{
                search_index=findSearchElementAscending(arr,0,index-1,element);
                if(search_index != -1)
                    return search_index;
            }
            return findSearchElementDescending(arr,index+1,r,element);
    }

    public static int findSearchElementDescending(List<Integer> arr, int l, int r, int element) {

        while(l<=r){
            int mid=(l+r)/2;
            if(arr.get(mid)==element)
                return mid;
            else if(arr.get(mid)>element)
                l=mid+1;
            else
                r=mid-1;
        }return -1;
    }

    public static int findSearchElementAscending(List<Integer> arr, int l, int r, int element) {

        while(l<=r){
            int mid=(l+r)/2;
            if(arr.get(mid)==element)
                return mid;
            else if(arr.get(mid)>element)
                r=mid-1;
            else
                l=mid+1;
        }return -1;
    }


    public static int findBitonicIndex(List<Integer> arr, int n,int l,int r){
        int mid;
        mid=(l+r)/2;
        if(arr.get(mid)>arr.get(mid+1) && arr.get(mid)>arr.get(mid-1)){
            return mid;
        }
        else if(arr.get(mid)>arr.get(mid+1) && arr.get(mid)<arr.get(mid-1)){
           mid= findBitonicIndex(arr,n,l,mid);
        }else if(arr.get(mid)>arr.get(mid-1) && arr.get(mid)<arr.get(mid+1)){
           mid= findBitonicIndex(arr,n,mid,r);
        }
        return mid;
    }

    public static void main(String args[])
    {
        int[] arr = { -8, 1, 2, 3, 4, 5, -2, -3 };
        List<Integer> arr1=Arrays.asList(-8, 1, 2, 3, 4, 5, -2, -3);
       // Collections.singletonList(arr);
        int key = 8;
        int n, l, r;
        n = arr.length;
        l = 0;
        r = n - 1;
        int index;
        index = findBitonic(arr1,key);

        int x = findSearchElement(arr1,n,l,r,key,index);

        if (x == -1) {
            System.out.println("Element Not Found");
        }
        else {
            System.out.println("Element Found at index "
                    + x);
        }
    }
}

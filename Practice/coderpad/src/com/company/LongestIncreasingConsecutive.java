package com.company;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class LongestIncreasingConsecutive {

    public static int solve(int[] a){
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(a[0],1);
        for(int i=1;i<a.length;i++){
            if(map.containsKey(a[i]-1)){
                map.put(a[i],map.get(a[i]-1)+1);
                map.remove(a[i]-1);
            }else {
                map.put(a[i],1);
            }
        }
       return Collections.max(map.values());
    }
    public static void main(String args[])
    {
        // Take input from user
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(solve(arr));
    }

}

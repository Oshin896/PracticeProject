package com.company;

import java.util.Scanner;

public class RainWaterTrapping {

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        while(t-->0){
            int n=sc.nextInt();
            sc.nextLine();
           // int a[]=new int[n];

            //String s1[]=sc.nextLine().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
           System.out.println(rainWaterTrap(n,a));
        }
    }

    private static int rainWaterTrap(int n, int[] a) {
        int left[]=new int[n];
        int right[]=new int[n];
        int curr_max_left=Integer.MIN_VALUE;
        int curr_max_right=Integer.MIN_VALUE;
        left[0]=a[0];
        right[n-1]=a[n-1];
        int i=1;
        while(i<n){
            curr_max_left=Math.max(left[i-1],a[i]);
            left[i]=curr_max_left;
            curr_max_right=Math.max(right[n-i],a[n-i-1]);
            right[n-i-1]=curr_max_right;
            i++;
        }
        int total_water=0;
        for(int j=0;j<n;j++)
            total_water=total_water+Math.min(left[j],right[j])-a[j];
        return total_water;
    }
}

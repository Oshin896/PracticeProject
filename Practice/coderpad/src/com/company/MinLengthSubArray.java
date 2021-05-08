package com.company;

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String s3[]=sc.nextLine().split("\\s");
        int t;
        if(s3.length>1)
            t=1;
        else
            t=Integer.parseInt(s3[0]);

        sc.nextLine();
        while(t-->0){
            String s2=sc.nextLine();
            String s[]=s2.split("\\s");
            int n=Integer.parseInt(s[0]);
            int x=Integer.parseInt(s[1]);
            String s1[]=sc.nextLine().split("\\s");
            int a[]=new int[s1.length];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(s1[i]);

            System.out.println(minimumLengthSubArray(a,n,x));
        }
    }

    public static int minimumLengthSubArray(int[] a,int n,int x){
        int start=0,end=0,curr_sum=0,min_length=n-1;

        if(n==0)
            return a[0];
        while(end<n){
            while(curr_sum<=x && end<n){
                curr_sum=curr_sum+a[end++];
            }
            while(curr_sum>x && start<n){
                if(end-start<min_length)
                    min_length=end-start;
                curr_sum=curr_sum-a[start++];
            }

        }
        return min_length;
    }
}

package com.company;

import java.util.Scanner;

public class LargestSubsequence {

        public static void main (String[] args) {
            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();
            sc.nextLine();
            while(t-->0){
                int n=sc.nextInt();
                int a[]=new int[n];
                for(int i=0;i<n;i++)
                    a[i]=sc.nextInt();
                int b=solve(a);
                System.out.println("Largest subsequence:"+b);
            }
        }

        public static int solve(int[] a){
            int max=a[0];
            int count=1;
            int max_so_far=a[0];
            int max_here=1;
            int n=a.length;
            for(int i=1;i<n;i++){
                if(max<a[i]){
                    max=a[i];
                    count++;
                }else{
                    if(count>max_here){
                        max_here=count;
                        count=1;
                        max=a[i];
                    }else{
                        count=1;max=a[i];
                    }
                }
            }
            if(count>max_here)
                max_here=count;

            return max_here;

        }
    }


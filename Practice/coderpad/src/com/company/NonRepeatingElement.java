package com.company;

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class NonRepeatingElement {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){

            int n=sc.nextInt();
            long a[]=new long[n];
            for(int i=0;i<n;i++)
                a[i]=sc.nextLong();
            System.out.println(nonRepeatingElement(a));

        }
    }

        public static long nonRepeatingElement ( long[] a){
            HashMap<Long, Integer> map = new HashMap<>();
            for (int i = 0; i < a.length; i++) {
                if (map.containsKey(a[i]))
                    map.put(a[i], map.get(a[i]) + 1);
                else
                    map.put(a[i], 1);
            }
            for (int i = 0; i < a.length; i++) {
                if (map.get(a[i]) == 1)
                    return a[i];
            }
            return 0;
        }

    public static long hashCode(long n){
        return (long)(n%Math.pow(10,7));
    }
}
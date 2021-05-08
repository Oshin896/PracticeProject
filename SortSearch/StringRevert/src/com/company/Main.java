package com.company;/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        if(t==0)
            t=1;
        while(t>0){
            long n=2044897764l;
            String s="";
            long d=0l;
            while(n>0){
                d=n%26;
                if(d==0){
                    s=(char)(64+26)+s;
                    n=(n/26)-1;
                }else{
                    s=(char)(64+d)+s;n=n/26;
                }
            }
            System.out.println(s);
            t--;
        }
    }
}
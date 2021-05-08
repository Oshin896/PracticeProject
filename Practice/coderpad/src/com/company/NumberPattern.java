package com.company;

import java.util.Scanner;

public class NumberPattern {

        public static void main (String[] args) {
            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();
            sc.nextLine();
            while(t-->0){
                String s=sc.nextLine();
                System.out.println(numberPattern(s));
            }
        }

        public static String numberPattern(String s){
            int n=s.length();
            int count=0;
            char[] a=new char[n+1];
            for(int i=0;i<=n;i++){

                if( i==n || s.charAt(i)=='I' ){
                    for(int j=i-1;j>=-1;j--){
                        a[j+1]=(char)((int)'0' + count++);
                        if(j>=0 && s.charAt(j)=='I')
                            break;
                    }
                }
            }
            return new String(a);
        }

}

package com.company.permutation;

import java.util.Scanner;

public class kthPermutationString {

    /*// n is length of each substring
    // l is the no. of sustrings
    public String permutation(String s,int k,int n){
        int sl=s.length();
        int l=s.length()/n;
        if(s.length()%n==1)
            l=l+1;
        int[] fact=new int[l+1];
        fact[0]=1;
        for(int i=1;i<=l;i++)
            fact[i]=fact[i-1]*i;
        StringBuilder s1=new StringBuilder("");
        k=k-1;
        int i=0;
        //n is the number of substrings
        while(l>0){
            int len= Math.min(sl, n);
            String s2=s.substring(i,i+len);
            int a=k/fact[len];
            s1.append(s2.charAt(a));

            k=k-;
            l--;
            sl=sl-len;
            i=i+len;

        }
        return s1.toString();
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int k=Integer.parseInt(sc.nextLine());
        int n=Integer.parseInt(sc.nextLine());
        String s=sc.nextLine();
        kthPermutationString obj=new kthPermutationString();
        System.out.println(obj.permutation(s,k,n));

    }*/
}

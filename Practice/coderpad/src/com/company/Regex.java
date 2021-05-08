package com.company;

public class Regex {

    public static void main(String[] args) {
        String s="ABABCABABCD";
        int n=s.length();
        System.out.println(compress(s));
    }

    public static String compress(String str){

        int i = 0;
        int n = str.length();
        String ans = "";
        while(n>0){
            if(n%2==0&&str.substring(i,n/2).equals(str.substring(n/2,n))){
                ans = compress(str.substring(i,n/2))+"*"+ans;
                break;
            }
            else{
                ans = str.substring(n-1,n)+ans;
                n--;
            }
        }

        return ans;
    }
}

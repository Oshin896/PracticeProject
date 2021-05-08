package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static int gcd(int a,int b){
        if(a==0)
            return b;
        return gcd(b%a,a);
    }
    public static int gcdOfArray(List<Integer> a){
        int result=a.get(0);
        for(int i=1;i<a.size();i++){
            result=gcd(a.get(i),result);
            if(result==1)
                return 1;
        }
        return result;
    }
    public static int lcmOfArray(List<Integer> a){
        int result=a.get(0);
        for(int i=1;i<a.size();i++){
            result=(result*a.get(i))/(gcd(a.get(i),result));
        }
        return result;
    }
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int lcmOfA=lcmOfArray(a);//4
        int gcdOfB=gcdOfArray(b);//16
        List<Integer> noDivisibleByX=new ArrayList<>();
        Collections.sort(a);
        int possibleX=lcmOfA,x=possibleX;
        int l,k=1,count=0,c=b.get(0);
        //4,8,12,16
        while(x<c){

            x=possibleX*k;
            noDivisibleByX.add(x);
            k++;
        }
        k=0;
        while(k!=noDivisibleByX.size()){
            l=noDivisibleByX.get(k);
            if(gcdOfB%l==0)
                count++;
            k++;
        }
        return count;
    }

}


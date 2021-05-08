package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int S[]={1, 2, 3, 4, 5};
    public static int s=10;
    public static boolean db[][]=new boolean[S.length+1][s+1];
    public static void main(String[] args) {

	//subsetSum(S,s);

    }

    private static void subsetSum(int[] S, int s) {

        int columnIndex=0,rowIndex=0;
        for(int i=0;i<=S.length;i++)
            db[i][0]=true;
        for(rowIndex=1;rowIndex<=S.length;rowIndex++){
            for(columnIndex=1;columnIndex<=s;columnIndex++){
                if(columnIndex<S[rowIndex-1] || db[rowIndex - 1][columnIndex])
                {
                    db[rowIndex][columnIndex]=db[rowIndex-1][columnIndex];
                }else{
                    db[rowIndex][columnIndex]=db[rowIndex-1][columnIndex-S[rowIndex-1]];
                }
            }
        }
        if(db[S.length][s]==false) {
            System.out.println("There are no subsets with" +
                    " sum " + s);
            return;
        }
        ArrayList<Integer> p = new ArrayList<>();

        printSubsetsRec(S, S.length, s, p);
    }

    private static void printSubsetsRec(int[] S, int i, int s1, ArrayList<Integer> p) {
        // If we reached end and sum is non-zero. We print
        // p[] only if arr[0] is equal to sun OR dp[0][sum]
        // is true.
        if(i==0 && s1!=0 && db[0][s1]){
            p.add(S[i]);
            display(p);
            p.clear();
            return;
        }
        // If sum becomes 0
        if (i == 0 && s1 == 0)
        {
            display(p);
            p.clear();
            return;
        }
        // If given sum can be achieved after ignoring
        // current element.
        if(db[i-1][s1]){
            ArrayList<Integer> arr=new ArrayList<>();
            arr.addAll(p);
            printSubsetsRec(S,i-1,s1,arr);
        }
// If given sum can be achieved after considering
        // current element.
        if(s1>=S[i-1] && db[i-1][s1-S[i-1]]){
            p.add(S[i-1]);
            printSubsetsRec(S,i-1,s1-S[i-1],p);
        }

    }

    static void display(ArrayList<Integer> v)
    {
        System.out.println(v);
    }
   /* private static void show(){
        int columnIndex=s;
        int rowIndex=S.length;
        while (columnIndex>0 || rowIndex>0){
            if(db[rowIndex][columnIndex]==db[rowIndex-1][columnIndex]){
                rowIndex=rowIndex-1;
            }else{
                System.out.println("show:"+ S[rowIndex-1]);
                columnIndex=columnIndex-S[rowIndex-1];
                rowIndex=rowIndex-1;
            }
        }
    }*/

    }


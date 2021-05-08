package com.company;

import java.util.ArrayList;

public class RodCuttingProblem {

    int maxLength;
    int totalItems;
    int price[];
    int length[];
    int dp[][];

    public RodCuttingProblem(int maxLength, int totalItems, int[] price, int[] length) {
        this.maxLength = maxLength;
        this.totalItems = totalItems;
        this.price = price;
        this.length = length;
        this.dp=new int[totalItems+1][maxLength+1];
    }

    public int solve(){
        int row=0;
        int col=0;
        for(row=1;row<=totalItems;row++){
            for (col=1;col<=maxLength;col++){
                int nottakenItem=dp[row-1][col];
                int takenitem=0;
                if(col>=length[row])
                     takenitem=price[row]+dp[row-1][col-length[row]];
                dp[row][col]=Math.max(takenitem,nottakenItem);
            }
        }
        return dp[totalItems][maxLength];
    }
    public void display(ArrayList<Integer> arr)
    {
        System.out.println(arr);
    }
    public void show(){
        int row=totalItems;
        int col=maxLength;
        while (row>=0 || col>=0){
            if(dp[row][col]!=0 && dp[row-1][col]!=dp[row][col]){
                System.out.println("Show:"+length[row]);
                col=col-length[row];
                row=row-1;
            }
        }

    }
}

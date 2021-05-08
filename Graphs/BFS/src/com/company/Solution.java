package com.company;

class Solution{
    static int maximumPath(int N, int Matrix[][])
    {

        int[][] cost=new int[N][N];
        int result=Integer.MIN_VALUE;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                cost[i][j]=0;
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(cost[i][j]==0){
                    longestPathFromCell(i,j,Matrix,cost,N);

                    result=Math.max(result,cost[i][j]);
                }
            }
        }
        return result;
    }
    static int longestPathFromCell(int row,int col,int Matrix[][],int cost[][],int N){
        if(row<0 || row>=N || col<0 || col>=N)
            return 0;
        if(cost[row][col]!=0)
            return cost[row][col];
        int x=0;
        int y=0;
        int z=0;

        /*if(row>0)
        w=Matrix[row][col]+longestPathFromCell(row-1,col,Matrix,cost);*/
        if(row<N-1){
            x=longestPathFromCell(row+1,col,Matrix,cost,N);
            if(col>0)
                y=longestPathFromCell(row+1,col-1,Matrix,cost,N);
            if(col<N-1)
                z=longestPathFromCell(row+1,col+1,Matrix,cost,N);
        }

        cost[row][col]=Matrix[row][col]+Math.max(x,Math.max(y,z));
        return cost[row][col];

    }
}
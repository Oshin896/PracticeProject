package com.company.minCostPath;

import java.util.PriorityQueue;

public class Solution {
/*
    private static int shortest(int A[][],int n){
            int[] dx={-1,0,1,0};
            int[] dy={0,1,0,-1};
            int dist[][]=new int[A.length][A.length];
            for (int i=0;i<A.length;i++){
                for(int j=0;j<A.length;j++)
                    dist[i][j]=Integer.MAX_VALUE;
            }
        dist[0][0]=A[0][0];
        PriorityQueue<Node> queue=new PriorityQueue<>(new DistanceComparator());
        queue.add(new Node(0,0,A[0][0]));
            while (!queue.isEmpty()){
                Node visitingVertex=queue.poll();
                for(int i=0;i<4;i++){
                    //end row and col
                    int row= visitingVertex.x+dx[i];
                    int col= visitingVertex.y+dy[i];
                    if(insideMatrix(row,col,n)){

                        //dist:vertex.getDistance
                        //A:edge.getWeight
                        if(dist[row][col]>dist[visitingVertex.x][visitingVertex.y]+A[row][col]){
                            if(dist[row][col]!=Integer.MAX_VALUE)
                            {
                                Node node=new Node(row,col,dist[row][col]);
                                queue.remove(node);
                            }
                            dist[row][col]=dist[visitingVertex.x][visitingVertex.y]+A[row][col];
                            queue.add(new Node(row,col,dist[row][col]));
                        }
                    }
                }
            }
            return dist[n-1][n-1];
    }

    private static boolean insideMatrix(int row, int col,int n) {
        if(row<0 || row>n-1 || col<0 || col>n-1) return false;
        return true;
    }*/

   public int shortest(int A[][], int n){
       if(n==0)
           return 0;
       if(n==1)
           return A[0][0];
       int dp[][]=new int[n][n];
       return minimumShortestPath(A,dp,n-1,n-1,n);
   }

    private int minimumShortestPath(int[][] a,int[][] dp, int row, int col,int n) {
       if(dp[row][col]!=0)
           return Integer.MAX_VALUE;

       if(row==0 && col==0)
           return a[0][0];
       if(row==n-1 && col==n-1 ) {
           dp[row][col]=1;
           return a[row][col]+Math.min(minimumShortestPath(a,dp,row-1,col,n),minimumShortestPath(a,dp,row,col-1,n));
       }
       if(row==0){

           if(col==n-1 && dp[row][col]==0){
               dp[row][col]=1;
           return a[row][col]+Math.min(minimumShortestPath(a,dp,row,col-1,n),minimumShortestPath(a,dp,row+1,col,n));}
           else if(dp[row][col]==0) {
               dp[row][col]=1;
               return a[row][col] + Math.min(minimumShortestPath(a, dp, row + 1, col, n),
                       Math.min(minimumShortestPath(a, dp, row, col - 1, n), minimumShortestPath(a, dp, row, col + 1, n)));
           }
       }
       if(row==n-1){

           if(col==0 && dp[row][col]==0){
               dp[row][col]=1;
               return
                   a[row][col]+Math.min(minimumShortestPath(a,dp,row+1,col,n),minimumShortestPath(a,dp,row,col+1,n));
               }
           else if(dp[row][col]==0){
               dp[row][col]=1;
               return a[row][col]+Math.min(minimumShortestPath(a,dp,row-1,col,n),
                       Math.min(minimumShortestPath(a,dp,row,col-1,n),minimumShortestPath(a,dp,row,col+1,n)));
       }}

       if(col==0){

           if(row==n-1 && dp[row][col]==0){
               dp[row][col]=1;
               return
                       a[row][col]+Math.min(minimumShortestPath(a,dp,row+1,col,n),minimumShortestPath(a,dp,row,col+1,n));

           }
           else if(dp[row][col]==0){
               dp[row][col]=1;
               return a[row][col]+Math.min(minimumShortestPath(a,dp,row+1,col,n),
                       Math.min(minimumShortestPath(a,dp,row-1,col,n),minimumShortestPath(a,dp,row,col+1,n)));
           }
       }
       if(col==n-1){
           if(row==0 && dp[row][col]==0 ){
               dp[row][col]=1;
               return a[row][col]+Math.min(minimumShortestPath(a,dp,row,col-1,n),minimumShortestPath(a,dp,row+1,col,n));
           }
           else if(dp[row][col]==0){
               dp[row][col]=1;
               return a[row][col]+Math.min(minimumShortestPath(a,dp,row+1,col,n),
                       Math.min(minimumShortestPath(a,dp,row-1,col,n),minimumShortestPath(a,dp,row,col-1,n)));
           }
       }
       return a[row][col]+Math.min(minimumShortestPath(a,dp,row+1,col,n),
               Math.min(minimumShortestPath(a,dp,row-1,col,n),Math.min(minimumShortestPath(a,dp,row,col+1,n),minimumShortestPath(a,dp,row,col-1,n))));

    }

   /* int findMinInAllFourDirections(int row,int col,int[][] dp,int[][] a){
       if(row>0 && row<a.length-1 && col>0 && col<a.length-1){

       }
    }*/
}

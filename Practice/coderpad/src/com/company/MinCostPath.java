package com.company;

import java.io.IOException;

public class MinCostPath {

    boolean isInside(int n,int row,int col, boolean[][] a){
        if(row<0 || row>n-1 )
            return false;
        if(col<0 || col>n-1)
            return false;
        if(a[row][col])
            return false;
        return true;
    }

    public int minimumCostPath(int[][] grid)
    {

        int n=grid.length;
        int row=n-1;
        int col=n-1;
        boolean a[][]=new boolean[n][n];
        int min_cost=grid[row][col];
        a[row][col]=true;
        while(true){

            int top=isInside(n,row-1,col,a)?grid[row-1][col]:Integer.MAX_VALUE;
            int bottom=isInside(n,row+1,col,a)?grid[row+1][col]:Integer.MAX_VALUE;
            int left=isInside(n,row,col-1,a)?grid[row][col-1]:Integer.MAX_VALUE;
            int right=isInside(n,row,col+1,a)?grid[row][col+1]:Integer.MAX_VALUE;

            if(row==0 && col==0) {
                break;
            }

            if(top<bottom && top<left && top<right){
                row--;
            }
            else if(bottom<top && bottom<left && bottom<right){
                row++;
            }
            else if(left<top && left<bottom && left<right){
                col--;
            }
            else if(right<top && right<bottom && right<left){
                col++;
            }
            min_cost+= grid[row][col];
            a[row][col]=true;
        }
        return min_cost;
    }
    public static void main(String[] args)
            throws IOException
    {
        int[][] grid = { { 9, 4, 9, 9 },
                { 6, 7, 6, 4 },
                { 8, 3, 3, 7 },
                { 7, 4, 9, 10} };
        MinCostPath m=new MinCostPath();
        System.out.println(m.minimumCostPath(grid));
    }
}

package com.company;

import java.util.Arrays;

class CoinChange
{


   /* public static long countWays(int S[], int m, int n)
    {
        long dp[][]=new long[m+1][n+1];
        int row;//types of coins
        int col;//total sum
        dp[0][0]=1;
        for(col=1;col<=n;col++)
            dp[0][col]=1;
        for(row=1;row<m;row++){
            for(col=0;col<=n;col++){
                if(col>=S[row-1]){
                    dp[row][col]=dp[row-1][col]+dp[row-1][col-S[row-1]];
                }else{
                    dp[row][col]=dp[row-1][col];
                }
            }
        }return dp[m-1][n];
    }*/

    static long countWays(int S[], int m, int n)
    {
        //Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)

        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        long[] table = new long[n+1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i=0; i<m; i++)
            for (int j=S[i]; j<=n; j++)
                table[j] += table[j-S[i]];

        return table[n];
    }

    // Driver Function to test above function
    public static void main(String args[])
    {
        int arr[] = {5, 6, 7,9,11,12,13,15};
        int m = arr.length;
        int n = 9;
        System.out.println(countWays(arr, m, n));
    }
}

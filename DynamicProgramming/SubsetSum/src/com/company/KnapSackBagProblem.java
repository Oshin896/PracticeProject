package com.company;

public class KnapSackBagProblem {
    int maxWeight;
     int[] value;
     int[] weight;
     int dp[][];

    public KnapSackBagProblem(int maxWeight, int[] value, int[] weight) {
        this.maxWeight = maxWeight;
        this.value = value;
        this.weight = weight;
        this.dp = new int[weight.length + 1][maxWeight + 1];
    }

    public int calculateMaxWeight(int maxWeight, int[] value, int[] weight) {
        int takenitem = 0;
        int notTakenItem = 0;
        for (int row = 1; row < weight.length; row++) {
            for (int col = 1; col <= maxWeight; col++) {
                notTakenItem = dp[row - 1][col];
                if (col >= weight[row])
                    takenitem = value[row] + dp[row - 1][col - weight[row]];
                dp[row][col] = Math.max(notTakenItem, takenitem);
            }

        }return dp[weight.length-1][maxWeight];
    }

    public void show(){
        int row=weight.length-1;
        int col=maxWeight;
        while (row>=0 || col>=0){
            if(dp[row][col]!=0 && dp[row][col]!=dp[row-1][col]){
                System.out.println("item:"+weight[row]);
                col=col-weight[row];
                row=row-1;

            }
        }
    }
}

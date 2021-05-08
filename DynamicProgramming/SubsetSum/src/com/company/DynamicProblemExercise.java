package com.company;

public class DynamicProblemExercise {

    int totalCapacity;
    int weights[];
    int value[];
    int dp[][];

    public DynamicProblemExercise(int totalCapacity, int[] weights, int[] value) {
        this.totalCapacity = totalCapacity;
        this.weights = weights;
        this.value = value;
        this.dp = new int[weights.length+1][totalCapacity+1];
    }

    int toSolve(int sum,int w[],int v[],int n){
        if(sum==0 || n==0)
            return 0;
        if(w[n-1]>sum)
            return toSolve(sum,w,v,n-1);
        return Math.max(toSolve(sum,w,v,n-1),v[n-1]+toSolve(sum-w[n-1],w,v,n-1));
    }
}

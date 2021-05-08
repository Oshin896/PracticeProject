package com.company;

public class App {

    public static void main(String[] args){
        int numOfitems=3;
        int capacityOfknapsack=50;

        int weight[]=new int[numOfitems+1];
        weight[0]=10;
        weight[1]=20;
        weight[2]=30;

        int profit[]=new int[capacityOfknapsack+1];
        profit[0]=60;
        profit[1]=100;
        profit[2]=120;

       /* KnapSackBagProblem knapSackBagProblem=new KnapSackBagProblem(capacityOfknapsack,profit,weight);
        knapSackBagProblem.calculateMaxWeight(capacityOfknapsack,profit,weight);
        knapSackBagProblem.show();*/

        /*RodCuttingProblem rodCuttingProblem=new RodCuttingProblem(capacityOfknapsack,numOfitems,profit,weight);
        rodCuttingProblem.solve();
        rodCuttingProblem.show();*/

        DynamicProblemExercise dynamicProblemExercise=new DynamicProblemExercise(capacityOfknapsack,weight,profit);
        System.out.println(dynamicProblemExercise.toSolve(capacityOfknapsack,weight,profit,numOfitems));
    }
}

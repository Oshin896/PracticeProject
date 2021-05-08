package com.company;

public class Main {

    public static void main(String[] args) {
	   /* NQueensProblem nQueensProblem=new NQueensProblem(4);
	    nQueensProblem.solve();*/

	    int[][] graphMatrix=new int[][]{
                {0,1,0,1,0},
                {1,0,1,1,0},
                {0,1,0,1,0},
                {1,1,1,0,1},
                {0,0,0,1,0}
        };

	    int numColor=3;

	    ColourProblem colourProblem=new ColourProblem(graphMatrix, numColor);
	    colourProblem.toSolve();

        int adjacencyMatrix[][]=new int[][]{
                {0,1,1,1,0,0},
                {1,0,1,0,1,0},
                {1,1,1,1,0,1},
                {1,0,1,0,0,1},
                {0,1,0,0,0,1},
                {0,1,1,1,1,1}
        };


	   /* HamiltonianCycle hamiltonianCycle=new HamiltonianCycle(adjacencyMatrix);
	    hamiltonianCycle.solve();*/
    }
}

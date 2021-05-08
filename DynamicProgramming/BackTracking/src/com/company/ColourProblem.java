package com.company;

public class ColourProblem {


    int adjacencyMatrix[][];
    int noOfVertices;
    int colors;
    int vertexArray[];

    public ColourProblem( int[][] adjacencyMatrix, int colors) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.colors = colors;
        this.vertexArray=new int[adjacencyMatrix.length];
        this.noOfVertices= adjacencyMatrix.length;

    }

    void toSolve(){
        if(isPossible(0))
            printSoln();
        else
            System.out.println("No soln");
    }

    private void printSoln() {
        for(int i:vertexArray)
            System.out.print(i+"-");
    }

    private boolean isPossible(int vertex) {
        if(vertex==noOfVertices)
            return true;
        for(int colorIndex=1;colorIndex<=colors;colorIndex++){
            if(isFeasible(colorIndex,vertex)) {
                vertexArray[vertex] = colorIndex;
                if(isPossible(vertex+1))
                    return true;
            }
        }return false;
    }

    private boolean isFeasible(int colorIndex, int vertex) {

        for(int i=0;i<noOfVertices;i++){
            if(adjacencyMatrix[vertex][i]==1 && vertexArray[i]==colorIndex)
            return false;
        }
        return true;
    }

}

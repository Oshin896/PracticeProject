package com.company;

public class HamiltonianCycle {
    int[] hamiltonianPath;
    int[][] adjacencyMatrix;
    int noOfVertices;

    public HamiltonianCycle( int[][] adjacencyMatrix) {

        this.adjacencyMatrix = adjacencyMatrix;
        this.noOfVertices = adjacencyMatrix.length;
        this.hamiltonianPath=new int[adjacencyMatrix.length];
    }

    public void solve(){

        hamiltonianPath[0]=0;
        if(feasibleSolution(1))
            printHamiltonianCycle();
        else
            System.out.println("No solution");
    }

    private void printHamiltonianCycle() {
        for(int item:hamiltonianPath)
            System.out.print(item+"-");
        System.out.println();
    }

    private boolean feasibleSolution(int position) {
//check if all vertices are traversed and last vertex is connected to first vertex
        if(position==noOfVertices){
            if(adjacencyMatrix[hamiltonianPath[position-1]][hamiltonianPath[0]]==1)
                return true;
            else
                return false;
        }
        for (int j=1;j<adjacencyMatrix.length;++j){//rows

                if (isFeasible(j,position)) {
                    hamiltonianPath[position] = j;
                    if(feasibleSolution(position+1))
                        return true;
                }

        } return false;
    }

    private boolean isFeasible(int j, int position) {
        //if the nodes are connected or not
        if(adjacencyMatrix[hamiltonianPath[position-1]][j]==0)
            return false;
        for (int i=0;i<position;i++){
            if(hamiltonianPath[i]==j)
                return false;
        }
        return true;
        }


}

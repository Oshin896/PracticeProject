package com.company;

public class NQueensProblem {
    int chess[][];
    int noOfQueens;

    public NQueensProblem(int noOfQueens) {
        this.chess = new int[noOfQueens][noOfQueens];
        this.noOfQueens = noOfQueens;
    }
    void solve(){
        if(setQueens(0))
            printQueens();
        else
            System.out.println("No solution found");
    }

    private boolean setQueens(int columnIndex) {
        if(columnIndex==noOfQueens)
            return true;
        for (int row=0;row<noOfQueens;++row){
        if(isValidPos(row,columnIndex)){
            chess[row][columnIndex]=1;
        if(setQueens(columnIndex+1))
            return true;

            chess[row][columnIndex]=0;
        }
        //backtracking

        }return false;
    }

    private boolean isValidPos(int row,int columnIndex) {
        //check if queen is present in the column
        for (int i=0;i<columnIndex;i++){
            if(chess[row][i]==1)
                return false;
        }
        //check if queen is present in left diagonal
        for (int i=row, j=columnIndex;i<chess.length && j>=0;i++,j--){
                if(chess[i][j]==1)
                    return false;
        }
        for(int i=row,j=columnIndex;i>=0 && j>=0;i--,j--){
                if(chess[i][j]==1)
                    return false;
        }
        return true;
    }

    private void printQueens() {
        for(int i=0;i<noOfQueens;i++){
            for(int j=0;j<noOfQueens;j++){
                if(chess[i][j]==1)
                    System.out.print(" * ");
                else
                    System.out.print(" - ");
            }
            System.out.println();
        }
    }
}

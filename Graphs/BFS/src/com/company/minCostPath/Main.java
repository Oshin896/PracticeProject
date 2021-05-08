package com.company.minCostPath;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int grid[][] = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }


            System.out.println((new Solution()).shortest(grid, n));


        }
    }

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
        }
}

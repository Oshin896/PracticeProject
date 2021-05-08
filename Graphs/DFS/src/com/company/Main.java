package com.company;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    public static void main(String[] args) {
      //  Vertex v0=new Vertex("0");
	    /*Vertex v1=new Vertex("1");
        Vertex v2=new Vertex("2");
        Vertex v3=new Vertex("3");
        Vertex v4=new Vertex("4");
        Vertex v5=new Vertex("5");
        Vertex v6=new Vertex("6");*/


        VertexCycleDetection v1=new VertexCycleDetection("1");
        VertexCycleDetection v2=new VertexCycleDetection("2");
        VertexCycleDetection v3=new VertexCycleDetection("3");
        VertexCycleDetection v4=new VertexCycleDetection("4");
        VertexCycleDetection v5=new VertexCycleDetection("5");
        VertexCycleDetection v6=new VertexCycleDetection("6");

       // List<Vertex> vertexList=new ArrayList<>();

        List<VertexCycleDetection> vertexList=new ArrayList<>();

        /*v2.addAdjacentVertices(v3);
        v3.addAdjacentVertices(v1);
        v4.addAdjacentVertices(v0);
        v4.addAdjacentVertices(v1);
        v5.addAdjacentVertices(v0);
        v5.addAdjacentVertices(v2);*/

        v1.addAdjacentVertices(v2);
        v2.addAdjacentVertices(v3);
        v3.addAdjacentVertices(v1);
        v4.addAdjacentVertices(v1);
        v4.addAdjacentVertices(v5);
        v5.addAdjacentVertices(v6);
        v6.addAdjacentVertices(v4);

       // vertexList.add(v0);
        vertexList.add(v1);
        vertexList.add(v2);
        vertexList.add(v3);
        vertexList.add(v4);
        vertexList.add(v5);
        vertexList.add(v6);

       /* DepthFirstSearch depthFirstSearch=new DepthFirstSearch();
        depthFirstSearch.dfs(vertexList);*/


        /*TopologicalOrdering topologicalOrdering=new TopologicalOrdering();
            for (int i=0;i<vertexList.size();i++)
            {
                if(!vertexList.get(i).isVisited())
                    topologicalOrdering.topologicalOrder(vertexList.get(i));
            }
        Deque<Vertex> vertexDeque= topologicalOrdering.listOfVertices;
            for (Vertex v:vertexDeque)
                System.out.println(v+"->");*/

        CycleDetectionDFS cycleDetectionDFS=new CycleDetectionDFS();
        cycleDetectionDFS.detectCycle(vertexList);

    }
}

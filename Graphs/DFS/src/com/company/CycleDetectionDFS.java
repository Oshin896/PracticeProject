package com.company;

import java.util.List;

public class CycleDetectionDFS {

    void traverseDFS(VertexCycleDetection v){
        System.out.println("DFS on vertex:"+v);
        v.setBeingVisited(true);
        for(VertexCycleDetection vertex:v.getAdjacentVertices()){
            if(vertex.isBeingVisited())
            {
                System.out.println("Cycle exists");
                return;
            }else if (!vertex.isVisited()){
                System.out.println("Vertex visited : "+vertex+" recursively...");
                vertex.setVisited(true);
                traverseDFS(vertex);
            }
        }
        System.out.println("Set vertex : "+v+" setBeingVisited(false) and visited(true)...");
        v.setBeingVisited(false);
        v.setVisited(true);
    }

    void detectCycle(List<VertexCycleDetection> vertexList){
        for(VertexCycleDetection v:vertexList){
            if(!v.isVisited())
                traverseDFS(v);
        }
    }
}

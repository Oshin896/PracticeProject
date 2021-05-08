package com.company.dag;

import java.util.*;

public class DagAlgorithm {

   void dag(List<Vertex> vertexList, Vertex sourceVertex, Vertex targetVertex){
       sourceVertex.setDistance(0);

       TopologicalOrdering topologicalOrdering=new TopologicalOrdering(vertexList);
       topologicalOrdering.topologicalOrdering();
       Deque<Vertex> stack= topologicalOrdering.printVertices();

       Iterator<Vertex> iterator=stack.iterator();
       while (iterator.hasNext()){

           for(Edge edge:iterator.next().getAdjacentEdges()){
               Vertex u= edge.getStartVertex();
               Vertex v= edge.getEndVertex();
               if(u.getDistance()==Double.MAX_VALUE)
                   continue;
               Double newDistance=u.getDistance()+ edge.getWeight();
               if(newDistance<v.getDistance())
               {
                   v.setDistance(newDistance);
                   v.setPredecessor(u);
               }
           }
       }

       if(targetVertex.getDistance()==Double.MAX_VALUE)
           System.out.println("No shortest path");
       else
           System.out.println("Shortest path is :"+targetVertex.getDistance());
   }

   void printShortestPath(Vertex targetVertex){
       List<Vertex> vertices=new ArrayList<>();
       vertices.add(targetVertex);
       while (targetVertex.getPredecessor()!=null){
           vertices.add(targetVertex.getPredecessor());
           targetVertex=targetVertex.getPredecessor();
       }
       Collections.reverse(vertices);
       for(Vertex vertex: vertices){
           System.out.println(vertex+"->");
       }
   }
}

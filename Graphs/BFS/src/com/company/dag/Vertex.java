package com.company.dag;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    String name;
    List<Edge> adjacentEdges;
    boolean isVisited;
    Vertex predecessor;
    double distance;

    public Vertex(String name) {
        this.name = name;
        this.adjacentEdges = new ArrayList<>();
        this.distance=Double.MAX_VALUE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getAdjacentEdges() {
        return adjacentEdges;
    }

    public void setAdjacentEdges(List<Edge> adjacentEdges) {
        this.adjacentEdges = adjacentEdges;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return name;
    }

    public void addAdjacentEdges(Edge adjacentEdge) {
        this.adjacentEdges.add(adjacentEdge);
    }
}

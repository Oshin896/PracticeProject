package com.company;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    String name;
    boolean visited;
    List<Vertex> adjacentList;

    public Vertex(String name) {
        this.name = name;
        this.adjacentList = new ArrayList<>();
    }

    void addVetex(Vertex v){
        adjacentList.add(v);
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getAdjacentList() {
        return adjacentList;
    }

}

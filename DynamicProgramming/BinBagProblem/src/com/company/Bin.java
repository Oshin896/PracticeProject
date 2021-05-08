package com.company;


import java.util.ArrayList;
import java.util.List;

public class Bin {

    int id;
    int capacity;
    int currentSize;
    List<Integer> items;

    public Bin(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.currentSize=0;
        this.items = new ArrayList<>();
    }

    public boolean toPut(int item){
        if(this.currentSize+item>this.capacity)
            return false;
        this.items.add(item);
        this.currentSize=currentSize+item;
        return true;
    }

    @Override
    public String toString() {

        String contentOfBin="Items in bin "+this.id+": ";
        for(Integer item:items){
            contentOfBin=contentOfBin+item+" ";
        }
        return contentOfBin;
    }
}

package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> items= Arrays.asList(10,5,5);
        int binCapacity=10;
        FirstFitAlgo firstFitAlgo=new FirstFitAlgo(items,binCapacity);
        firstFitAlgo.solveBinProblem();
        firstFitAlgo.showResults();
    }
}

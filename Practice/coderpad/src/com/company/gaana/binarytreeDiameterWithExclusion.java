package com.company.gaana;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class binarytreeDiameterWithExclusion {
int maxD=0;
    public int maxDiameter(int input1,int[][] input2,int input3,int[] input4){
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0;i<input2.length;i++){
            map.putIfAbsent(input2[i][0],new ArrayList<>());
            map.get(input2[i][0]).add(input2[i][1]);
            map.putIfAbsent(input2[i][1],new ArrayList<>());
        }
        getDiameter(map,1,input4);
        return maxD;
    }
    public int getDiameter(HashMap<Integer, List<Integer>> map,int node,int[] input){
        List<Integer> a=map.get(node);
        if(a.isEmpty()){
            if(node==-1)
                return 0;
            map.get(node).add(-1);
            map.putIfAbsent(-1,new ArrayList<>());
        }

        int lheight=getDiameter(map,a.get(0),input);
        if(Arrays.binarySearch(input,a.get(0))>=0)
            lheight=0;
        int rheight=a.size()==2 ?getDiameter(map,a.get(1),input):0;
        if(a.size()==2 && Arrays.binarySearch(input,a.get(1))>=0)
            rheight=0;

        if(Arrays.binarySearch(input,node)<0 ) {
            maxD = Math.max(lheight + rheight, maxD);

        }
        return Math.max(lheight,rheight)+1;

    }


    public static void main(String[] args){
        int[][] a={{1,2},{2,3},{2,4},{1,5}};
        binarytreeDiameterWithExclusion b=new binarytreeDiameterWithExclusion();
        int[] c={1,2,3};
       System.out.println(b.maxDiameter(4,a,2,c));
    }
}

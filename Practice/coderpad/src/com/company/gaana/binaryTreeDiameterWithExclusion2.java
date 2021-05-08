package com.company.gaana;

import java.util.*;

public class binaryTreeDiameterWithExclusion2 {

    int maxD=0;
    public int maxDiameter(int input1,int[][] input2,int input3,int[] input4){
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        boolean[] isExcluded=new boolean[input1+1];
        for(int i=0;i<input3;i++){
            isExcluded[input4[i]]=true;
        }
        for(int i=0;i<input2.length;i++){
            map.putIfAbsent(input2[i][0],new ArrayList<>());
            map.get(input2[i][0]).add(input2[i][1]);
            map.putIfAbsent(input2[i][1],new ArrayList<>());
        }
        getDiameter(map,1,input4,isExcluded);
        return maxD;
    }
    public int getDiameter(Map<Integer, List<Integer>> map, int node, int[] input, boolean[] isExcluded){
        List<Integer> a=map.get(node);
        if(a.isEmpty()){
            if(node==0)
                return 0;
            map.get(node).add(0);
            map.putIfAbsent(0,new ArrayList<>());
        }

        int lheight=getDiameter(map,a.get(0),input,isExcluded);
        if(isExcluded[a.get(0)])
            lheight=0;
        int rheight=a.size()==2 ?getDiameter(map,a.get(1),input,isExcluded):0;
        if(a.size()==2 && isExcluded[a.get(1)])
            rheight=0;

        if(!isExcluded[node]) {
            maxD = Math.max(lheight + rheight, maxD);

        }
        return Math.max(lheight,rheight)+1;

    }


    public static void main(String[] args){
        int[][] a={{1,2},{2,3},{2,4},{1,5}};
        binarytreeDiameterWithExclusion b=new binarytreeDiameterWithExclusion();
        int[] c={2};
        System.out.println(b.maxDiameter(4,a,2,c));
    }
}

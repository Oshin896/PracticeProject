package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FirstFitAlgo {
    List<Bin> bins;
    List<Integer> items;
    int capacityOfBins;
    int binCounter=0;

    public FirstFitAlgo( List<Integer> items, int capacityOfBins) {
        this.bins = new ArrayList<>(items.size());
        this.items = items;
        this.capacityOfBins = capacityOfBins;

    }

    public void solveBinProblem(){
        Collections.sort(items,Collections.reverseOrder());
        if(items.get(0)>capacityOfBins) {
            System.out.println("No solution");
            return;
        }
        this.bins.add(new Bin(binCounter,this.capacityOfBins));//first bin

        for(int i=0;i<items.size();i++){
            boolean isOk=false;//check whether we have put item into
            int currentBin=0;
            while(!isOk){
                if(currentBin==this.bins.size()){//item does not fit into the last bin , hence create new bin
                    Bin newBean=new Bin(++binCounter,capacityOfBins);
                    newBean.toPut(items.get(i));
                    this.bins.add(newBean);
                    isOk=true;
                }
                else if(this.bins.get(currentBin).toPut(items.get(i))){//current item fits into the bin
                    isOk=true;
                }
             /*else if(this.bins.get(currentBin).toPut(items.get(i))){//current item fits into the bin
                isOk=true;
            }*/
            else
            currentBin++;//trying next bin
            }
        }
    }

    void showResults(){
        for(Bin bin:this.bins){
           System.out.println(bin.toString());
        }
    }
}

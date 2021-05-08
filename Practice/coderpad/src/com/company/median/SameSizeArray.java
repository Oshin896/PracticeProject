package com.company.median;

import java.util.ArrayList;

public class SameSizeArray {


    public static int findMedian(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
        int x=arr1.size();
        int low=0,high=x;
        while(low<=high){
            int partitionX=(low+high)/2;
            int partitionY=x-partitionX;

            int maxLeftX=partitionX==0?Integer.MIN_VALUE:arr1.get(partitionX-1);
            int minRightX=partitionX==x?Integer.MAX_VALUE:arr1.get(partitionX);

            int maxLeftY=partitionY==0?Integer.MIN_VALUE:arr2.get(partitionY-1);
            int minRightY=partitionY==x?Integer.MAX_VALUE:arr2.get(partitionY);

            if(maxLeftX<=minRightY && maxLeftY<=minRightX){
                if(x%2==0)
                    return (Math.max(maxLeftX,maxLeftY)+Math.min(minRightX,minRightY))/2;
                else
                    return Math.max(maxLeftX,maxLeftY);

            }else if(maxLeftX>minRightY){
                high=partitionX-1;
            }
            else
                low=partitionX+1;
        }
        throw new IllegalArgumentException();
    }
    public static void main(String[] args)
    {
        //int A1[] = { 1,2,3,7 };

        ArrayList<Integer> A=new ArrayList<>();
        A.add(1);A.add(12);A.add(15);A.add(26);A.add(38);
        ArrayList<Integer> B=new ArrayList<>();
        B.add(2);B.add(13);B.add(17);B.add(30);B.add(45);
        //int B[] = { 5, 8, 10, 20 };



        System.out.println(findMedian(A,  B));
    }
}

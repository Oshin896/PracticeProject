package com.company.binaryIndexTree;

public class FenwickTree {

    public int[] createTree(int[] input){
        int[] binaryIndexTree=new int[input.length+1];
        for(int i=1;i<= input.length;i++){
            updateTree(binaryIndexTree,input[i-1],i);
        }
        return binaryIndexTree;
    }

    public void updateTree(int[] binaryIndexTree, int input, int index) {
        while(index< binaryIndexTree.length){
            binaryIndexTree[index]+=input;
            index=getNext(index);
        }
    }

    public int getNext(int index) {
        return (index & -index)+index;
    }

    public int getSum(int[] binaryIndexTree,int ei){
        ei=ei+1;
        int sum=0;
        while(ei!=0){
            sum+=binaryIndexTree[ei];
            ei=getParent(ei);
        }
        return sum;
    }

    private int getParent(int ei) {
        return ei-(ei & -ei);
    }
    public static void main(String args[]){
        int input[] = {1,2,3,4,5,6,7};
        FenwickTree ft = new FenwickTree();
        int binaryIndexedTree[] = ft.createTree(input);
        assert 1 == ft.getSum(binaryIndexedTree, 0);
        assert 3 == ft.getSum(binaryIndexedTree, 1);
        assert 6 == ft.getSum(binaryIndexedTree, 2);
        assert 10 == ft.getSum(binaryIndexedTree, 3);
        assert 15 == ft.getSum(binaryIndexedTree, 4);
        assert 21 == ft.getSum(binaryIndexedTree, 5);
        assert 28 == ft.getSum(binaryIndexedTree, 6);
    }
}

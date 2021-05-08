package com.company;

public class TreeNode {

    int data;
    TreeNode leftNode;
    TreeNode rightNode;

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    void insert(int value){
        if(data==value)
            return;
        if(data<value){
            if(rightNode==null)
            {
                rightNode=new TreeNode(value);
            }
            else
                rightNode.insert(value);
        }
        else{
            if(leftNode==null)
                leftNode=new TreeNode(value);
            else
                leftNode.insert(value);
        }
    }
    void traversalInOrder(){
        if(leftNode!=null)
            leftNode.traversalInOrder();
        System.out.print(data+",");
        if(rightNode!=null)
            rightNode.traversalInOrder();
    }
    void traversalPreOrder(){
        System.out.print(data+",");
        if(leftNode!=null)
            leftNode.traversalPreOrder();
        if(rightNode!=null)
            rightNode.traversalPreOrder();
    }
    void traversalPostOrder(){
        if(leftNode!=null)
            leftNode.traversalPostOrder();
        if(rightNode!=null)
            rightNode.traversalPostOrder();
        System.out.print(data+",");

    }
    TreeNode getTreeNode(int value){
        if(data==value)
            return this;
        if(data>value){
            if(leftNode!=null)
                return leftNode.getTreeNode(value);
        }else{
            if(rightNode!=null)
               return rightNode.getTreeNode(value);
        }
        return null;
    }
    int max(){
        if(rightNode==null)
            return data;
        return rightNode.max();

    }
    int min(){
        if(leftNode==null)
            return data;
        return leftNode.min();
    }


}

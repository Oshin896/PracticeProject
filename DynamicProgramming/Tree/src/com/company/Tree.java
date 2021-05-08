package com.company;

public class Tree {

    TreeNode root;

    void insert(int value){
        if(root==null)
            root=new TreeNode(value);
        root.insert(value);
    }
    void traversalInOrder(){
        if(root==null)
            System.out.println("No tree found");
        else
            root.traversalInOrder();
    }
    void traversalPreOrder(){
        if(root==null)
            System.out.println("No tree found");
        else
            root.traversalPreOrder();
    }
    void traversalPostOrder(){
        if(root==null)
            System.out.println("No tree found");
        else
            root.traversalPostOrder();
    }
    TreeNode getTreeNode(int value){
        if(root!=null)
            return root.getTreeNode(value);
        return null;
    }
    int max(){
        if(root!=null)
            return root.max();
        return Integer.MAX_VALUE;
    }
    int min(){
        if(root!=null)
            return root.min();
        return Integer.MIN_VALUE;
    }
    void deleteNode(int n){

        root=deleteSubTree(root,n);

    }

    private TreeNode deleteSubTree(TreeNode subTreeNode, int n) {
       if(subTreeNode==null)
           return subTreeNode;
       else if(n<subTreeNode.data)
           subTreeNode.setLeftNode(deleteSubTree(subTreeNode.getLeftNode(),n));
       else if(n> subTreeNode.data)
           subTreeNode.setRightNode(deleteSubTree(subTreeNode.getRightNode(),n));
       else{
           if(subTreeNode.getLeftNode()==null)
               return subTreeNode.getRightNode();
           else if(subTreeNode.getRightNode()==null)
               return subTreeNode.getLeftNode();
           subTreeNode.setData(subTreeNode.getRightNode().min());
           subTreeNode.setRightNode(deleteSubTree(subTreeNode.getRightNode(),n));
       }
       return subTreeNode;
    }
}

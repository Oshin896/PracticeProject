package com.company.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {


    public static class TrieNode{
        HashMap<Character,TrieNode> map=new HashMap<>();
        int flag;

    }
    public TrieNode insert(String w, TrieNode root){
        TrieNode curr=root;
        for(int i=0;i<w.length();i++){
            char c=w.charAt(i);
            TrieNode node=new TrieNode();
            if(curr==null){
                curr=new TrieNode();
                curr.map.put(c,node);
                curr.flag=1;
                curr=node;
            }else{

                if(curr.map.get(c)==null){

                    curr.map.put(c,node);
                    curr.flag++;
                    curr=node;
                }else{
                    curr.flag++;
                    node=curr.map.get(c);
                    curr=node;
                }
            }

        }
return root;
    }

    public ArrayList<String> shortestUniquePrefix(ArrayList<String> arr) {
            TrieNode root=new TrieNode();
            root.flag=0;
            for(String a:arr){
                root=insert(a,root);
            }
            ArrayList<String> st=new ArrayList<>();
        for(String a:arr){
            shortestUniquePrefixUtil(root,st,a);
        }

        return st;
    }

    private void shortestUniquePrefixUtil(TrieNode root, ArrayList<String> st,String a) {
        if(root == null)
            return ;
        TrieNode curr=root;
        String prefix="";
        for(int i=0;i<a.length();i++){

            TrieNode n=curr.map.get(a.charAt(i));
            if(n != null) {
                if (n.flag == 1) {
                    prefix += a.charAt(i);
                    break;
                } else {
                    prefix += a.charAt(i);
                    curr=curr.map.get(a.charAt(i));
                }
            }
        }
        st.add(prefix);
    }
    public static void main(String args[])
    {
        String arr[] = {"zebra", "dog", "duck", "dove"};
        ArrayList<String> arr1=new ArrayList<String>(Arrays.asList(arr));
        //int n = arr.length;
        Solution s=new Solution();
        ArrayList<String> a=s.shortestUniquePrefix(arr1);
        for(int i=0;i<a.size();i++)
            System.out.println(a.get(i));
    }

}

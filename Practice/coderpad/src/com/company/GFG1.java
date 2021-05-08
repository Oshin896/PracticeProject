package com.company;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class GFG1 {

    static class TrieNode{
        HashMap<Character,TrieNode> map;
        int flag;
        TrieNode(){
            map=new HashMap<>();
            flag=0;
        }

    }
    public static void main (String[] args) {
        String arr[] = {"zebra", "dog", "duck", "dove"};
        ArrayList<String> a=new ArrayList(Arrays.asList(arr));
        int n = arr.length;
        GFG1 g=new GFG1();
        ArrayList<String> s=g.prefix(a);
        for(int i=0;i<n;i++)
            System.out.println(s.get(i));

    }
    public ArrayList<String> prefix(ArrayList<String> arr){
        TrieNode root=new TrieNode();
        for(int i=0;i<arr.size();i++)
            root=insert(root,arr.get(i));

        ArrayList<String> st=new ArrayList<>();
        for(int i=0;i<arr.size();i++)
            prefixUtil(st,arr.get(i),root);
        return st;
    }

    public TrieNode insert(TrieNode root,String s){
        TrieNode curr=root;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            TrieNode temp=new TrieNode();
            if(curr.map.get(c)==null)
                curr.map.put(c,temp);
            else
                temp=curr.map.get(c);
            curr.flag++;
            curr=temp;
        }
        return root;
    }

    public void prefixUtil(ArrayList<String> f,String a,TrieNode root){
        TrieNode curr=root;String pref="";
        for(int i=0;i<a.length();i++){
            char c=a.charAt(i);
            TrieNode temp=curr.map.get(c);

            if(temp != null){
                if(temp.flag==1){
                    pref+=c;
                    break;
                }else{
                    pref+=c;
                    curr=temp;
                }
            }

        }f.add(pref);
    }

}

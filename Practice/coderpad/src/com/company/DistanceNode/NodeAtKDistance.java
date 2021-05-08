package com.company.DistanceNode;



import java.lang.reflect.Array;
import java.util.*;

public class NodeAtKDistance {

    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        ArrayList<Integer> arr=getKNodes(root,target,k);
        return arr;

    }

    public static Node getTargetNode(HashMap<Node,Node> map,int target){
        for(Map.Entry<Node,Node> entry:map.entrySet()){
            if(entry.getKey().data==target)
                return entry.getKey();
        }
        return null;
    }
//level order traversing to store parent -node of every node in hashmap
    private static HashMap<Node, Node> levelOrderTraversal(Node root) {
        HashMap<Node,Node> map=new HashMap<>();// <Parent,Child>
        Queue<Node> queue=new LinkedList<>();
        if(root==null)
            return  null;
        queue.add(root);
        map.put(root,null);
        while (!queue.isEmpty()){
            Node n=queue.poll();
            if(n.left!=null){
                queue.add(n.left);
                map.put(n.left,n);
            }
            if(n.right!=null){
                queue.add(n.right);
                map.put(n.right,n);
            }
        }return  map;
    }

    //Function to find the nodes at distance K from give node

    // bfs to get left,right and parent node at a distance k from the given node

    private static ArrayList<Integer> getKNodes(Node root,int target,int k){
        HashMap<Node,Node> map=levelOrderTraversal(root);
        ArrayList<Integer> arr=new ArrayList<>();
        Node targetNode=getTargetNode(map,target);
        HashSet<Node> set=new HashSet<>();
        Queue<Node> queue=new LinkedList<>();
        queue.add(targetNode);
        set.add(targetNode);
        int dist=0;
        while (!queue.isEmpty()){
            if(dist==k){
                while (!queue.isEmpty()){
                    arr.add(queue.poll().data);
                }
            }
            int size= queue.size();
            for(int i=0;i<size;i++){
                Node p=queue.poll();
                if(p.left!=null && !set.contains(p.left)){
                            set.add(p.left);
                            queue.add(p.left);
                }
                if(p.right!=null && !set.contains(p.right)){
                    set.add(p.right);
                    queue.add(p.right);
                }
                if(map.get(p) != null && !set.contains(map.get(p))){
                    set.add(map.get(p));
                    queue.add(map.get(p));
                }
            }
            dist++;
        }
        return arr;
    }
}

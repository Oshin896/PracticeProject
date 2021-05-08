package com.company.TreeToDLL;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeToDLL {
   public Node bToDLL(Node root)
    {
        Node new_head=null;
        Node curr_pos=null;
        Deque<Node> dq=new ArrayDeque<>();
        Node curr=root;
        while (curr != null || !dq.isEmpty()) {
            while(curr != null){
                dq.push(curr);
                curr=curr.left;
            }
            curr=dq.poll();
            if(new_head==null) {
                new_head = curr;
                curr_pos=new_head;
            }
            else{
                curr_pos.right=curr;
                curr.left=curr_pos;
                curr_pos=curr;
            }

                curr=curr.right;
        }
        return new_head;
    }
}

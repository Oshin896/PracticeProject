package com.company.insertion;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * @type of head: ListNode
 * @return type: ListNode
 */
class Solution {

    public static void main(String args[]) {
        ListNode head = new ListNode(2);
        ListNode l1 = new ListNode(8);
        head.next = l1;
        ListNode l2 = new ListNode(3);
        l1.next = l2;
        ListNode l3 = new ListNode(5);
        l2.next = l3;
        ListNode l4 = new ListNode(10);
        l3.next = l4;
        //l4.next = l2;

        // 2->8->3->5->10--
        //       ^        |
        //       |        |
        //        ---------
        Solution s1 = new Solution();
        head=s1.insertionSort(head);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public ListNode insertionSort(ListNode head) {
        ListNode curr=head;
        ListNode nh=head;
        ListNode res=null;
        while(curr != null){
            ListNode next=curr.next;
            if(res == null || curr.val<=res.val)
            {
                curr.next=res;res=curr; curr= next;continue;
            }
            nh=res;
            ListNode prev=null;
            while(nh!=null && nh.val<curr.val){
                prev=nh;nh=nh.next;
            }
            if(prev == null){
                curr.next=res;
                res=curr;
            }else{
                prev.next=curr;
                curr.next=nh;
            }
            curr=next;
        }
        return res;
    }
}

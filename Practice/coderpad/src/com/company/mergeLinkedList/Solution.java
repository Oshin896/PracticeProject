package com.company.mergeLinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * @type of head1: ListNode
 * @type of head2: ListNode
 * @return type: ListNode
 */
class Solution {
    public static void main(String args[]) {
        ListNode head1 = new ListNode(1);
        ListNode l1 = new ListNode(2);
        head1.next = l1;
        ListNode l2 = new ListNode(3);
        l1.next = l2;
        ListNode l3 = new ListNode(4);
        l2.next = l3;
        ListNode l4 = new ListNode(5);
        l3.next = l4;
        ListNode head2 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        head2.next = l12;
        ListNode l22 = new ListNode(6);
        l12.next = l22;

        Solution s1 = new Solution();
        head1=s1.mergeSortedLists(head1,head2);
        while (head1 != null) {
            System.out.print(head1.val + "->");
            head1 = head1.next;
        }
        System.out.println("NULL");
    }

    public ListNode mergeSortedLists(ListNode head1, ListNode head2) {
        ListNode prev=null;
        ListNode curr1;
        ListNode curr2;

        if(head1==null)
            return head2;
        else if(head2==null)
            return head1;

        if(head1.val>head2.val){
            ListNode next=head2.next;
            head2.next=head1;
            head1=head2;
            head2=next;
        }
        prev=head1;
        curr1=head1.next;
        curr2=head2;
        while(curr1 != null && curr2 != null){
            if(curr1.val >= curr2.val){
                ListNode next=curr2.next;
                curr2.next=curr1;
                prev.next=curr2;
                curr1=prev.next;
                curr2=next;
            }else{
                prev=curr1;
                curr1=curr1.next;
            }

        }

        if(curr1 == null && curr2!=null)
            prev.next=curr2;
        return head1;
    }
}

package com.company.floyd;

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
            s1.detectAndRemoveLoop(head);
            while (head != null) {
                System.out.print(head.val + "->");
                head = head.next;
            }
            System.out.println("NULL");
        }

        ListNode detectAndRemoveLoop(ListNode head) {
            ListNode loop=floydAlgo(head);

            if(loop != null){
                ListNode curr=head;
                while(curr.next != loop.next){
                    curr=curr.next;
                    loop=loop.next;
                }
                loop.next=null;
            }
            return head;
        }

        ListNode floydAlgo(ListNode head){
            ListNode h1=head;
            ListNode h2=head;

            while(h1 != null && h2.next != null){
                h1=h1.next;
                h2=h2.next.next;

                if(h1 == h2)
                    return h1;

            }
            return null;

        }
    }


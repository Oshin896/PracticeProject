package com.company.sum;

public class SumLinked {

   static ListNode head1 = null;
  static ListNode head2 = null;
   static ListNode result = null;

    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        ListNode nh=new ListNode((head1.val+head2.val)%10);

        nh.next=new ListNode((head1.val+head2.val)/10);


        ListNode curr1=head1.next;
        ListNode curr2=head2.next;
        ListNode curr=nh.next;
        ListNode prev=nh;

        int sum=0;
        while(curr1 != null && curr2 != null){
            sum=curr1.val+curr2.val+curr.val;
            curr.val=sum%10;
            curr.next=new ListNode(sum/10);
            curr1=curr1.next;
            curr2=curr2.next;
            prev=curr;
            curr=curr.next;
        }
        while(curr1 != null){
            sum=curr1.val+curr.val;
            curr.val=sum%10;
            curr.next=new ListNode(sum/10);
            curr1=curr1.next;
            prev=curr;
            curr=curr.next;
        }

        while(curr2 != null){
            sum=curr2.val+curr.val;
            curr.val=sum%10;
            curr.next=new ListNode(sum/10);
            curr2=curr2.next;
            prev=curr;
            curr=curr.next;
        }
        if(curr.val==0)
            prev.next=null;
        return nh;
    }

    static void push(int val, int list)
    {
        ListNode newnode = new ListNode(val);
        if (list == 1)
        {
            newnode.next = head1;
            head1 = newnode;
        }
        else if (list == 2)
        {
            newnode.next = head2;
            head2 = newnode;
        }
        else
        {
            newnode.next = result;
            result = newnode;
        }

    }
   static void printlist(ListNode head)
    {
        while (head != null)
        {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String args[])
    {


       // ListNode carry = 0;
        int arr1[] = { 4 };
        int arr2[] = { 1 };

        // Create first list as 9->9->9
        for (int i = arr1.length - 1; i >= 0; --i)
            push(arr1[i], 1);

        // Create second list as 1->8
        for (int i = arr2.length - 1; i >= 0; --i)
            push(arr2[i], 2);

      result=  addTwoNumbers(head1,head2);

        printlist(result);
    }
}

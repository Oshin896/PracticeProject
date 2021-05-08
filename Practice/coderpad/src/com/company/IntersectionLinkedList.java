package com.company;

class Intersect
{
    int intersectPoint(Node head1, Node head2)
    {
        Node cur1=head1;
        Node cur2=head2;
        int c1=0,c2=0;
        while(cur1!=null){
            c1++;
            cur1=cur1.next;
        }
        while(cur2!=null){
            c2++;
            cur2=cur2.next;
        }
        cur1=head1;
        cur2=head2;
        if(c1>c2){
            while(c2!=c1){
                cur1=cur1.next;
                c1--;
            }
        }
        else{
            while(c1!=c2){
                cur2=cur2.next;
                c2--;
            }

        }
        while(cur1!=null && cur2!=null){
            if(cur1==cur2)
                return cur1.data;
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return -1;
    }
}

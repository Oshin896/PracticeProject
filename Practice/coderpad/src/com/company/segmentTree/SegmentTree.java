package com.company.segmentTree;

public class SegmentTree {
public  static int[] st;
    public SegmentTree(int[] given_array, int n) {
        int x=(int)Math.ceil(Math.log(n)/Math.log(2));
        int max_size=2*(int)Math.pow(2,x)-1;
        st=new int[max_size];
        constructTree(given_array,st,0,n-1,0);
    }

    int constructTree(int[] given_array, int[] st, int si, int ei, int ci){
        if(si==ei){
            st[ci]=given_array[si];
            return given_array[si];
        }
        int mid=get_mid(si,ei);
        st[ci]=constructTree(given_array,st,si,mid,ci*2+1)+constructTree(given_array,st,mid+1,ei,ci*2+2);

        return st[ci];
    }

    private int get_mid(int si, int ei) {
        return (si+(ei-si)/2);
    }


    public static void main(String args[])
    {
        int arr[] = {1, 3, 5, 7, 9, 11};
        int n = arr.length;
        SegmentTree  tree = new SegmentTree(arr, n);

        // Build segment tree from given array
for(int i=0;i<st.length;i++){
    System.out.println(i+"-"+st[i]);
}
        // Print sum of values in array from index 1 to 3
       System.out.println("Sum of values in given range = " +
                tree.getSum(n, 1, 3));

        // Update: set arr[1] = 10 and update corresponding segment
        // tree nodes
        tree.updateValue(arr, n, 1, 10);

        // Find sum after the value is updated
        System.out.println("Updated sum of values in given range = " +
                tree.getSum(n, 1, 3));
    }

    private void updateValue(int[] arr, int n, int index, int value) {
        if(index <0 || index> arr.length-1)
            return;
        int diff=value-arr[index];
        arr[index]=value;
        updateValueUtil(0,n-1,diff,index,0);
    }

    private void updateValueUtil(int ss, int se, int diff, int index, int si) {
        if(index<ss || index>se)
            return;
        st[si]=st[si]+diff;
        if(se != ss) {
            int mid = get_mid(ss, se);
            updateValueUtil(ss, mid, diff, index, 2 * si + 1);
            updateValueUtil(mid + 1, se, diff, index, 2 * si + 2);
        }
    }

    private int getSum(int n, int start, int end) {
        if(start>end || start<0 || end>n-1)
            return -1;
        return getSumUtil(0,n-1,start,end,0);
    }

    private int getSumUtil( int start, int end, int qstart, int qend, int curr) {
        if(start>=qstart && end<=qend)
            return st[curr];
         if(start>qend || end<qstart)
             return 0;
         int mid=get_mid(start,end);
         return getSumUtil(start,mid,qstart,qend,2*curr+1)+getSumUtil(mid+1,end,qstart,qend,2*curr+2);

    }
}


package com.company;/*
package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    */
/*Tree tree=new Tree();
	    tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(27);
        tree.insert(30);
        tree.insert(29);
        tree.insert(26);
        tree.insert(22);
        tree.insert(32);

        tree.traversalInOrder();
        System.out.println();
        tree.traversalPreOrder();
        System.out.println();
        tree.traversalPostOrder();
        System.out.println();
        System.out.println(tree.getTreeNode(25).data);
        System.out.println(tree.max());
        System.out.println(tree.min());
        tree.deleteNode(25);
        tree.traversalInOrder();*//*



//System.out.println(nonrepeatingCharacter("hqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvs"));
String[] arr={"3","30","34","5","9"};
        System.out.println(printLargest(arr));

    }

    */
/*static char nonrepeatingCharacter(String s)
    {

        int a[]=new int[26];
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int index=(((int)c)-97)%26;
            a[index]++;
        }
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int index=(((int)c)-97)%26;
            if(a[index]==1)
                return c;
        }
        return 'S';


    }*//*


    static String printLargest(String[] arr) {
        List<String> arr1= Arrays.asList(arr);
        Collections.sort(arr1, (Comparator<String>) (o1, o2) -> {
            String s1=o1+o2;
            String s2=o2+o1;
            return s1.compareTo(s2) > 0 ? -1:1;
        }
        );
        Iterator it = arr1.iterator();
String s1="";
        while(it.hasNext())
            s1=s1+it.next();
return s1;
    }

}
*/

// { Driver Code Starts
//Initial Template for Java

/**
 * <b>IDeserve <br>
 * <a href="<a class="vglnk" href="https://www.youtube.com/c/IDeserve" rel="nofollow"><span>https</span><span>://</span><span>www</span><span>.</span><span>youtube</span><span>.</span><span>com</span><span>/</span><span>c</span><span>/</span><span>IDeserve</span></a>"><a class="vglnk" href="https://www.youtube.com/c/IDeserve" rel="nofollow"><span>https</span><span>://</span><span>www</span><span>.</span><span>youtube</span><span>.</span><span>com</span><span>/</span><span>c</span><span>/</span><span>IDeserve</span></a></a>
 * Given a cost matrix having a cost at each cell. Find the minimum cost it
 * will take to reach cell (m, n) from top left corner cell (0, 0) if the only
 * allowed directions to move from a cell are right, down and diagonally down.
 *
 * @author Saurabh
 */
public class Main {

    public static int minimumCostPathRec(int[][] costMatrix, int m, int n) {
        if (m < 0 || n < 0)
            return Integer.MAX_VALUE;

        if (m == 0 && n == 0)
            return costMatrix[0][0];

        return costMatrix[m][n]
                + minimum(minimumCostPathRec(costMatrix, m - 1, n - 1),
                minimumCostPathRec(costMatrix, m - 1, n),
                minimumCostPathRec(costMatrix, m, n - 1));
    }

    public static int minimumCostPathDP(int[][] costMatrix, int m, int n) {
        int[][] minimumCostPath = new int[m+1][n+1];
        minimumCostPath[0][0] = costMatrix[0][0];

        for (int i = 1; i <= m; i++) {
            minimumCostPath[i][0] = minimumCostPath[i - 1][0] + costMatrix[i-1][0];
        }

        for (int j = 1; j <= n; j++) {
            minimumCostPath[0][j] = minimumCostPath[0][j - 1] + costMatrix[0][j-1];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                minimumCostPath[i][j] = costMatrix[i-1][j-1]
                        + minimum(minimumCostPath[i - 1][j - 1],
                        minimumCostPath[i - 1][j],
                        minimumCostPath[i][j - 1]);
            }
        }
        return minimumCostPath[m][n];
    }

    public static int minimum(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        int[][] costMatrix = { { 31, 100, 65, 12, 18 },
                { 10, 13, 47, 157, 6 },
                { 100, 113, 174, 11, 33 },
                { 88, 124, 41, 20, 140 },
                { 99, 32, 111, 41, 20 } };
        System.out.println("Minimum cost: " + minimumCostPathDP(costMatrix, 4, 3));
    }
}
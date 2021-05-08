package SearchAlgo;

class InterpolationClass {

    static int[] a=new int[]{1,2,3,4,5,16,34,89,98,900,9000};

    static int interpolationSearch(int x){
        int l=0;
        int u=a.length-1;

        while(l <= u && x >= a[l] && x <= a[u]){
            if(l==u){
                if(a[l]==x)
                    return l;
                return -1;
            }
            int pos=l + (((u-l) /
                    (a[u]-a[l]))*(x - a[l]));
            if(a[pos]==x)
                return pos;
            else if(a[pos]>x)
                u=pos-1;
            else{
                l=pos+1;
            }
        }
        return -1;
    }
    public static void main(String args[]){
       int b= interpolationSearch(98);
       if(b==-1)
           System.out.print("Element not found");
       else
           System.out.print(b);
    }


}

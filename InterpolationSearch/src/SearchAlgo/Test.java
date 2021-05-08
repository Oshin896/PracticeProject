package SearchAlgo;

class Test
{
    // Array of items on which search will
    // be conducted.
    static int data[] = new int[]{10, 12, 13, 16, 18, 19, 20, 21, 22, 23,
            24, 33, 35, 42, 47};

    // If x is present in arr[0..n-1], then returns
    // index of it, else returns -1.
    public static int interpolationSearch( int item) {

        int highEnd = (data.length - 1);
        int lowEnd = 0;

        while (item >= data[lowEnd] && item <= data[highEnd] && lowEnd <= highEnd) {

            int probe
                    = lowEnd + (highEnd - lowEnd) * (item - data[lowEnd]) / (data[highEnd] - data[lowEnd]);

            if (highEnd == lowEnd) {
                if (data[lowEnd] == item) {
                    return lowEnd;
                } else {
                    return -1;
                }
            }

            if (data[probe] == item) {
                return probe;
            }

            if (data[probe] < item) {
                lowEnd = probe + 1;
            } else {
                highEnd = probe - 1;
            }
        }
        return -1;
    }

    // Driver method
    public static void main(String[] args)
    {
        int x = 18; // Element to be searched
        int index = interpolationSearch(x);

        // If element was found
        if (index != -1)
            System.out.println("Element found at index " + index);
        else
            System.out.println("Element not found.");
    }
}
package Seminar_02_sorts;

import com.sun.source.tree.BreakTree;

public class QuickSearch {
    public static int search(int[] array, int N) {
        return QuickSearch.search(array, 0, array.length - 1, N);
    }

    public static int search(int[] array, int startItem, int endItem, int N) {

        int midpoint;
        if (startItem > endItem) {
            return -1;
        } else
        {
            midpoint = (endItem - startItem) /2 + startItem;
        }


        if (array[midpoint] < N) {
            return QuickSearch.search(array, midpoint + 1, endItem, N);
        } else if (array[midpoint] > N) {
            return QuickSearch.search(array, startItem, midpoint - 1, N);
        }
        return midpoint;
    }

}

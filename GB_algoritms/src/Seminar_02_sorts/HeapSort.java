package Seminar_02_sorts;

public class HeapSort {
    private static void siftRecursive(int[] array, int arrayLenth, int root) {
        int maxChild = root;
        if ((2 * root + 2) <= (arrayLenth - 1) && array[2 * root + 1] < array[2 * root + 2]) {
            maxChild = 2 * root + 2;
        } else if ((2 * root + 1) <= (arrayLenth - 1)) {
            maxChild = 2 * root + 1;
        }
        if (array[root] < array[maxChild]) {
            int tmp = array[root];
            array[root] = array[maxChild];
            array[maxChild] = tmp;
            root = maxChild;
            siftRecursive(array, arrayLenth, root);
        }
    }

    private static void sift(int[] array, int arrayLenth, int root) {
        int maxChild;
        while (2 * root < arrayLenth - 1) {
            if ((2 * root + 2) <= (arrayLenth - 1) && array[2 * root + 1] < array[2 * root + 2]) {
                maxChild = 2 * root + 2;
            } else {
                maxChild = 2 * root + 1;
            }
            if (array[root] < array[maxChild]) {
                int tmp = array[root];
                array[root] = array[maxChild];
                array[maxChild] = tmp;
                root = maxChild;
            } else {
                break;
            }
        }
//        Main.showArrya(array);
    }

    public static void sort(int[] array) {
        int arrayLenght = array.length;
        int startElem = arrayLenght / 2 - 1;

        for (int i = startElem; i >= 0; i--) {
            siftRecursive(array, arrayLenght, i);
        }

        for (int i = arrayLenght - 1; i >= 1; i--) {
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;
            siftRecursive(array, i, 0);
        }
    }
}

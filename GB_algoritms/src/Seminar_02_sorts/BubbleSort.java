package Seminar_02_sorts;

public class BubbleSort {
    public static void sort(int[] array) {
        int lng = array.length;
        for (int i = 0; i < lng; i++) {
            for (int j = 0; j < lng - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public static void sort_v2(int[] array) {
        int lng = array.length;
        boolean needSort;
        do {
            needSort = false;
            for (int i = 0; i < lng-1; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    needSort = true;
                }
            }
        } while(needSort);
    }
}


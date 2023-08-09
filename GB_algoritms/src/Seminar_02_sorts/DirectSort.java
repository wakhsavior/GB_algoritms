package Seminar_02_sorts;

public class DirectSort {
    public static void sort(int[] array) {
        int lng = array.length;
        for (int i = 0; i < lng-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < lng; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = tmp;
            }
        }
    }
}

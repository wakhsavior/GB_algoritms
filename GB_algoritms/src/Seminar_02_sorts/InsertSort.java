package Seminar_02_sorts;

public class InsertSort {
    public static void sort(int[] array) {
        int lng = array.length;
        for (int i = 0; i < lng-1; i++) {
            for (int j = i+1; j < lng; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }

            }
        }

    }
}

package Seminar_02_sorts;

import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] array, int minItem, int maxItem) {
        int pivot = array[(minItem + maxItem) / 2];

        int leftItem = minItem;
        int rightItem = maxItem;
        do {
            while (array[leftItem] < pivot) {
                leftItem++;
            }
            while (array[rightItem] > pivot) {
                rightItem--;
            }
            if (leftItem <= rightItem) {
                if (leftItem < rightItem) {
                    int tmp = array[leftItem];
                    array[leftItem] = array[rightItem];
                    array[rightItem] = tmp;
                }
                rightItem--;
                leftItem++;
            }
        } while (leftItem <= rightItem);
        if (leftItem < maxItem) {
            QuickSort.sort(array, leftItem, maxItem);
        }
        if (minItem < rightItem){
            QuickSort.sort(array, minItem, rightItem);
        }



    }

    public static void sort(int[] array) {
        QuickSort.sort(array, 0, array.length - 1);
    }
}

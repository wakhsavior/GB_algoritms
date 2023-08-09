package Seminar_02_sorts;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random rnd = new Random();
    static Scanner in = new Scanner(System.in);

    public static int[] createArray(int num) {

        int[] array;
        array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = rnd.nextInt(1000);
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.print("Input a number: ");
        int num = in.nextInt();
        int[] array = createArray(num);
        int[] array_tmp;

//        showArrya(array);
        // Bubble Sort
        array_tmp = array.clone();
        Date startDate = new Date();
        BubbleSort.sort(array_tmp);
        Date endDate = new Date();
        long bubbleDuration = endDate.getTime() - startDate.getTime();
        System.out.printf("Bubble sort duration: %d", bubbleDuration);
        System.out.println();
//        showArrya(array_tmp);
        // End Bubble sort

        //Bubble sort V2
        array_tmp = array.clone();
//        showArrya(array_tmp);
        startDate = new Date();
        BubbleSort.sort_v2(array_tmp);
        endDate = new Date();
        long bubbleDuration_v2 = endDate.getTime() - startDate.getTime();
        System.out.printf("Bubble sort V2 duration: %d", bubbleDuration_v2);
        System.out.println();
//        showArrya(array_tmp);
        // End Bubble sort V2

        //Direct sort
        array_tmp = array.clone();
//        showArrya(array_tmp);
        startDate = new Date();
        DirectSort.sort(array_tmp);
        endDate = new Date();
        long directSortDuration = endDate.getTime() - startDate.getTime();
        System.out.printf("Direct sort duration: %d", directSortDuration);
        System.out.println();
//        showArrya(array_tmp);
        // End Direct sort

        //Insert sort
        array_tmp = array.clone();
//        showArrya(array_tmp);
        startDate = new Date();
        InsertSort.sort(array_tmp);
        endDate = new Date();
        long insertSortDuration = endDate.getTime() - startDate.getTime();
        System.out.printf("Insert sort duration: %d", insertSortDuration);
        System.out.println();
//        showArrya(array_tmp);
        // End Insert Sort

        //Quick sort
        array_tmp = array.clone();
//        showArrya(array_tmp);
        startDate = new Date();
        QuickSort.sort(array_tmp);
        endDate = new Date();
        long quickSortDuration = endDate.getTime() - startDate.getTime();
        System.out.printf("Quick duration: %d", quickSortDuration);
        System.out.println();
//        showArrya(array_tmp);
        // End Quick Sort

        //Heap sort
        array_tmp = array.clone();
//        showArrya(array_tmp);
        startDate = new Date();
        HeapSort.sort(array_tmp);
        endDate = new Date();
        long heapSortDuration = endDate.getTime() - startDate.getTime();
        System.out.printf("Heap sort duration: %d", heapSortDuration);
        System.out.println();
//        showArrya(array_tmp);
        // End Heap Sort
//        showArrya(array);



//        int position = QuickSearch.search(array_tmp,25);
//        System.out.printf("Позиция искомого числа 25: %d",position);

    }

    public static void showArrya(int[] array) {
        int lng = array.length;
        for (int i = 0; i < lng; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
    }
}

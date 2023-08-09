package Seminar_01;

import java.util.Date;

public class Main {

    public static int fibonachi(int num) {
        if (num <= 2) {
            return 1;
        }
        return fibonachi(num - 1) + fibonachi(num - 2);
    }

    public static int fibonachiLine(int num) {
        if (num <= 2) {
            return 1;
        }
        final int[] numbers = new int[num];
        numbers[0] = 1;
        numbers[1] = 1;
        for (int i = 2; i < numbers.length; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }
        return numbers[num - 1];
    }

    public static void main(String[] args) {
//        System.out.println(fibonachi(10));
//        System.out.println(fibonachiLine(10));
        test();
    }

    public static void test() {
        for (int i = 10; i <= 100; i = i + 10){
            Date startDate = new Date();
            fibonachiLine(i);
            Date endDate = new Date();
            long lineDuration = endDate.getTime() - startDate.getTime();
            startDate = new Date();
            fibonachi(i);
            endDate = new Date();
            long resursiveDuration = endDate.getTime() - startDate.getTime();
            System.out.printf("Fibonachi: %d Linear time: %d Recursive time: %d\n", i,lineDuration,resursiveDuration);

        }
    }
}
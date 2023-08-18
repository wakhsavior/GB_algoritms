package Seminar_04;

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        MyTree<Integer> myTree = new MyTree<>();
        while (true) {
            System.out.print("Input a number: ");
            myTree.add(in.nextInt());
            System.out.println("finish");
        }
    }
}

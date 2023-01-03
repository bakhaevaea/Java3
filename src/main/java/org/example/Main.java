package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

       // delEvenInt();
       // listMinMax();
        arrayMergeSort();
    }

/*
Пусть дан произвольный список целых чисел, удалить из него четные числа
*/
    private static void delEvenInt() {
        List<Integer> array = new ArrayList<>();
        int size = 10;
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            int val = random.nextInt(-10, 10);
            array.add(val);
        }
        System.out.println("Дан список целых чисел");
        System.out.println(Arrays.asList(array));

        for (int i = 0; i <array.size(); ) {
            if (array.get(i) % 2 == 0) {
                array.remove(i);
            } else {
                i++;
            }
        }
        System.out.println("Удалены четные числа");
        System.out.println(Arrays.asList(array));
    }

    /*Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.*/
    private static void listMinMax(){
        List<Integer> array = new ArrayList<>();
        int size = 10;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            int val = random.nextInt(-10, 10);
            array.add(val);
            sum += val;
        }
        System.out.println("Задан целочисленный список");
        System.out.println(Arrays.asList(array));

        Collections.sort(array);
        System.out.println("Минимальное значение " + array.get(0).toString());
        System.out.println("Максимальное значение " + array.get(size-1).toString());
        System.out.println("Среднее значение " + (sum/size));

    }
/*Реализовать алгоритм сортировки слиянием*/
    private static  void arrayMergeSort(){
        ArrayList<Integer> array = new ArrayList<>();
        int size = 10;
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            int val = random.nextInt(-10, 10);
            array.add(val);
        }
        System.out.println("Задан целочисленный список");
        System.out.println(Arrays.asList(array));
        System.out.println("Список отсортирован слиянием");
        array = mergeSort(array);
        System.out.println(Arrays.asList(array));


    }
    private static ArrayList<Integer> mergeSort(ArrayList<Integer>  a) {
//        System.out.print(a.size() );
//        System.out.println(Arrays.asList(a));
        if (a.size() < 2 ) {
            return a;
        }
        else {
            int mid = a.size() / 2;
            ArrayList<Integer> array_l = new ArrayList<Integer>(mid);
            ArrayList<Integer> array_r = new ArrayList<Integer>(a.size() - mid);

            for (int i = 0; i < mid; i++) {
                array_l.add(a.get(i));
            }
            for (int i = mid; i < a.size(); i++) {
                array_r.add(a.get(i));
            }
            array_l = mergeSort(array_l);
            array_r = mergeSort(array_r);
            merge(a, array_l, array_r);
        }
        return a;
    }
    private static void merge(ArrayList<Integer>  a, ArrayList<Integer>  l, ArrayList<Integer>  r) {

        int i = 0, j = 0, k = 0;
        while (i < l.size() && j < r.size()) {
            if (l.get(i) <= r.get(j)) {
                a.set(k, l.get(i));
                k++;
                i++;
            }
            else {
                a.set(k, r.get(j));
                k++;
                j++;
            }
        }
        while (i < l.size()) {
            a.set(k, l.get(i));
            k++;
            i++;
        }
        while (j < r.size()) {
            a.set(k, r.get(j));
            k++;
            j++;
        }
    }
}
package algorithms.sorting.bubble_sort;

import algorithms.sorting.Sorter;

public class BubbleSort extends Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        if(array == null) return;

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if(array[j].compareTo(array[j - 1]) < 0){
                    T temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
}


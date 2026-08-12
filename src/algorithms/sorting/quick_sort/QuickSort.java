package algorithms.sorting.quick_sort;

import algorithms.sorting.Sorter;

import java.util.Random;

public class QuickSort extends Sorter {
    private final Random random = new Random();

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        if (array == null) {
            return;
        }

        sort(array, 0, array.length - 1);
    }

    private <T extends Comparable<T>> void sort(T[] array, int low, int high) {
        if (low >= high) return;

        int randomIndex = random.nextInt(low, high);

        // Swapping random element with the last one to get unpredictable pivot
        // to avoid situations like when algorithms.sorting will have complexity O(n)
        // in case when array is sorted, always picking the last element as pivot is not efficient
        swap(array, randomIndex, high);


        int pivot = high;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j].compareTo(array[pivot]) < 0) {
                swap(array, j, ++i);
            }
        }

        swap(array, ++i, pivot);

        sort(array, low, i - 1);
        sort(array, i + 1, high);
    }

    private <T extends Comparable<T>> void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
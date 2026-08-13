package algorithms.sorting;

import algorithms.sorting.bubble_sort.BubbleSort;
import algorithms.sorting.quick_sort.QuickSort;

import java.util.Random;

public class SortingTester {
    public static final int DEFAULT_ARRAY_LENGTH = 80000;
    public static final int DEFAULT_SORTING_ITERATIONS = 5;
    private static final String DIVIDER = "----------------------------------------";

    int arrayLength;
    int sortingIterations;


    private final Random random;

    public SortingTester() {
        random = new Random();
        arrayLength = DEFAULT_ARRAY_LENGTH;
        sortingIterations = DEFAULT_SORTING_ITERATIONS;
    }

    public SortingTester(int arrayLength, int sortingIterations) {
        random = new Random();
        this.arrayLength = arrayLength;
        this.sortingIterations = sortingIterations;
    }

    private long start;
    private long end;
    private double sortingResult;
    private double sortingAllIterationsResult = 0;

    public void testBubbleSort() {
        testSortingAlgorithm("Bubble sort", new BubbleSort());
    }

    public void testQuickSort() {
        testSortingAlgorithm("Quick sort", new QuickSort());
    }

    private void testSortingAlgorithm(String name, Sorter sorter) {
        Integer[] array;
        // JVM warm up.
        // Without this first sort iterations were taking much more time.
        System.out.println("Preparing...");
        for (int i = 0; i < 3; i++) {
            array = getRandomArray();
            sorter.sort(array);
        }

        for (int i = 0; i < sortingIterations; i++) {
            System.out.println("Starting sorting attempt number " + (i + 1));
            array = getRandomArray();
            sort(array, sorter);
            System.out.println("Array has been sorted in " + sortingResult + " seconds");
            System.out.println(DIVIDER);
        }
        sortingAllIterationsResult = sortingAllIterationsResult / sortingIterations;

        System.out.println(name + " has taken " + sortingAllIterationsResult + " seconds for sort a " + arrayLength + " length array.");
        System.out.println(DIVIDER);
        reset();
    }

    private Integer[] getRandomArray() {
        Integer[] array = new Integer[arrayLength];

        for (int j = 0; j < array.length; j++) {
            array[j] = random.nextInt(arrayLength);
        }

        return array;
    }

    private void sort(Integer[] array, Sorter sorter) {
        start = System.nanoTime();
        sorter.sort(array);
        end = System.nanoTime();

        sortingResult = (double) (end - start) / 1_000_000_000;
        sortingAllIterationsResult += sortingResult;
    }

    private void reset() {
        start = 0;
        end = 0;
        sortingAllIterationsResult = 0;
        sortingResult = 0;
    }
}

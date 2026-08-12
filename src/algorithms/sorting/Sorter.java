package algorithms.sorting;

public abstract class Sorter {
    public abstract <T extends Comparable<T>> void sort(T[] array);
}

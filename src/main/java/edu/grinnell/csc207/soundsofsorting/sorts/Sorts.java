package edu.grinnell.csc207.soundsofsorting.sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.grinnell.csc207.soundsofsorting.sortevents.CompareEvent;
import edu.grinnell.csc207.soundsofsorting.sortevents.CopyEvent;
import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;
import edu.grinnell.csc207.soundsofsorting.sortevents.SwapEvent;

/**
 * A collection of sorting algorithms.
 */
public class Sorts {
    static CompareEvent compEvent = new CompareEvent(0, 0);
    static List<Integer> compare = compEvent.getCompare();
    static CopyEvent copEvent = new CopyEvent(0, null);
    static List<Integer> copied = copEvent.getCopied();
    static SwapEvent swappedEvent = new SwapEvent(0, 0);
    static List<Integer> swapped = swappedEvent.getSwapped();
    static List<String> sortedEvents = new ArrayList<>();

    // static SortEvent sortedEvent = new SortEvent();
    // static List<Integer> sortedEvents = sortedEvent.getSorted();
    /**
     * Swaps indices <code>i</code> and <code>j</code> of array <code>arr</code>.
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to swap
     * @param i   the first index to swap
     * @param j   the second index to swap
     */
    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        sortedEvents.add("swap");
    }

    /**
     * Sorts the array according to the bubble sort algorithm:
     * 
     * <pre>
     * [ unprocessed | i largest elements in order ]
     * </pre>
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<T>> bubbleSort(T[] arr) {
        ArrayList<SortEvent<T>> events = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    events.add(new CompareEvent<>(j, j + 1));
                    compare.add(j);
                    sortedEvents.add("compare");
                    swap(arr, j, j + 1);
                    events.add(new SwapEvent<>(j, j + 1));
                    swapped.add(j);
                    swapped.add(j + 1);
                }
            }
        }
        return events;
    }

    /**
     * Sorts the array according to the selection sort algorithm:
     * 
     * <pre>
     * [ i smallest elements in order | unprocessed ]
     * </pre>
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<T>> selectionSort(
            T[] arr) {
        List<SortEvent<T>> events = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int k = i; k < arr.length; k++) {
                if (arr[k].compareTo(arr[min]) < 0) {
                    events.add(new CompareEvent<>(k, min));
                    compare.add(i);
                    sortedEvents.add("compare");
                    min = k;
                }
            }
            swap(arr, i, min);
            events.add(new SwapEvent<>(i, min));
            swapped.add(i);
            swapped.add(min);
        }
        return events;
    }

    /**
     * Sorts the array according to the insertion sort algorithm:
     * 
     * <pre>
     * [ i elements in order | unprocessed ]
     * </pre>
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<T>> insertionSort(
            T[] arr) {
        List<SortEvent<T>> events = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j].compareTo(arr[j - 1]) < 0) {
                compare.add(j);
                sortedEvents.add("compare");
                events.add(new CompareEvent<>(j, j - 1));
                swap(arr, j, j - 1);
                swapped.add(j);
                swapped.add(j - 1);
                events.add(new SwapEvent<>(j, j - 1));
                j--;
            }
        }
        return events;
    }

    /**
     * Merges two sorted arrays
     *
     * @param <T>  the type of arrays being merged
     * @param arr1 the first sorted array
     * @param arr2 the second sorted array
     * @param events the list of sort events to be generated
     * @return a sorted array
     */
    public static <T extends Comparable<? super T>> T[] 
        merge(T[] arr1, T[] arr2, List<SortEvent<T>> events) {
        T[] arr3 = Arrays.copyOf(arr1, arr1.length + arr2.length);
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i].compareTo(arr2[j]) < 0) {
                compare.add(i);
                sortedEvents.add("compare");
                events.add(new CompareEvent<>(i, j));
                arr3[k] = arr1[i];
                copied.add(k);
                copied.add(i);
                sortedEvents.add("copy");
                events.add(new CopyEvent<T>(k, arr1[i]));
                k++;
                i++;
            } else {
                arr3[k] = arr2[j];
                copied.add(k);
                copied.add(j);
                sortedEvents.add("copy");
                events.add(new CopyEvent<>(k, arr2[j]));
                k++;
                j++;
            }
        }
        while (i < arr1.length) {
            arr3[k] = arr1[i];
            copied.add(k);
            copied.add(i);
            sortedEvents.add("copy");
            events.add(new CopyEvent<>(k, arr1[i]));
            k++;
            i++;
        }
        while (j < arr2.length) {
            arr3[k] = arr2[j];
            copied.add(k);
            copied.add(j);
            sortedEvents.add("copy");
            events.add(new CopyEvent<>(k, arr2[j]));
            k++;
            j++;
        }
        return arr3;
    }

    /**
     * Sorts the array according to the merge sort algorithm:
     * 
     * <pre>
     * [ sorted | sorted ] -> [ sorted ]
     * </pre>
     *
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @param events the list of sort events to be generated
     * @return the array sorted
     */
    public static <T extends Comparable<? super T>> T[] 
        mergeSortHelper(T[] arr, List<SortEvent<T>> events) {
        if (arr.length > 1) {
            return merge(
                mergeSortHelper(Arrays.copyOfRange(arr, 0, (arr.length / 2)), events),
                mergeSortHelper(Arrays.copyOfRange(arr, arr.length / 2, arr.length), events),
                events
            );
        } else {
            return arr;
        }
    }

    /**
     * Sorts the array according to the merge sort algorithm.
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<T>> mergeSort(
            T[] arr) {
        List<SortEvent<T>> events = new ArrayList<>();
        T[] arrTmp = Arrays.copyOf(arr, arr.length);
        if (arr.length > 1) {
            T[] left = mergeSortHelper(Arrays.copyOfRange(arr, 0, arr.length / 2),
                (ArrayList<SortEvent<T>>) events);
            T[] right = mergeSortHelper(Arrays.copyOfRange(arr, arr.length / 2, arr.length),
                (ArrayList<SortEvent<T>>) events);
            T[] merged = merge(left, right, (ArrayList<SortEvent<T>>) events);
            System.arraycopy(merged, 0, arrTmp, 0, merged.length);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrTmp[i];
            copied.add(i);
            copied.add(i);
            sortedEvents.add("copy");
        }
        return events;
    }

    /**
     * Sorts the array according to the quick sort algorithm.
     * 
     * @param <T> T
     * @param arr the array to sort
     * @param lo low number 
     * @param hi high number
     * @param events the list of sort events to be generated
     */
    public static <T extends Comparable<? super T>> void 
        quickSortHelper(T[] arr, int lo, int hi, List<SortEvent<T>> events) {
        int med = hi;
        int left = lo;
        int right;
        if (hi > 0) {
            right = hi - 1;
        } else {
            right = left;
        }
        while (left < right) {
            if (arr[left].compareTo(arr[med]) > 0 && arr[right].compareTo(arr[med]) <= 0) {
                compare.add(left);
                sortedEvents.add("compare");
                events.add(new CompareEvent<>(left, right));
                swap(arr, left, right);
                swapped.add(left);
                swapped.add(right);
                events.add(new SwapEvent<>(left, right));
            } else {
                if (arr[left].compareTo(arr[med]) < 0) {
                    compare.add(left);
                    sortedEvents.add("compare");
                    events.add(new CompareEvent<>(left, med));
                    left++;
                } else if (arr[right].compareTo(arr[med]) >= 0) {
                    compare.add(right);
                    sortedEvents.add("compare");
                    events.add(new CompareEvent<>(right, med));
                    right--;
                }
            }
        }
        if (arr[left].compareTo(arr[med]) > 0) {
            compare.add(left);
            sortedEvents.add("compare");
            events.add(new CompareEvent<>(left, med));
            swap(arr, med, left);
            swapped.add(med);
            swapped.add(left);
            events.add(new SwapEvent<>(med, left));
        } else {
            left++;
        }
        if (hi - lo > 1) {
            if (left > 0) {
                quickSortHelper(arr, 0, (left - 1), events);
            }
            quickSortHelper(arr, left, hi, events);
        }
    }

    /**
     * Sorts the array according to the quick sort algorithm.
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<? super T>> List<SortEvent<T>> quickSort(T[] arr) {
        List<SortEvent<T>> events = new ArrayList<>();
        int left = 0;
        int length = arr.length;
        int right;
        if (length > 0) {
            right = length - 1;
        } else {
            right = left;
        }
        quickSortHelper(arr, 0, right, events);
        return events;
    }

    /**
     * Sorts the array according to the quick sort algorithm.
     * 
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return the sort events generated by this sort
     */
    public static <T extends Comparable<T>> List<SortEvent<T>> exchangeSort(T[] arr) {
        List<SortEvent<T>> events = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    compare.add(j);
                    sortedEvents.add("compare");
                    events.add(new CompareEvent<>(i, j));
                    swap(arr, i, j);
                    swapped.add(j);
                    swapped.add(i);
                    events.add(new SwapEvent<>(i, j));
                }
            }
        }
        return events;
    }

    /**
     * Returns the list of compare events.
     * @return the list of compare events
     */
    public static CopyEvent getCopEvent() {
        return copEvent;
    }

    CopyEvent copy = new CopyEvent(0, 0);
    SwapEvent swap = new SwapEvent(0, 0);
    CompareEvent comparing = new CompareEvent(0, 0);

    <T> void eventSort(T[] l, List<SortEvent<T>> events) {
        for (SortEvent<T> event : events) {
            event.apply(l);
        }
    }
}

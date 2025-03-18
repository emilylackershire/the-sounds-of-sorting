package edu.grinnell.csc207.soundsofsorting;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.soundsofsorting.sorts.Sorts;

public class SortsTests {
    /**
     * @param <T> the carrier type of the array
     * @param arr the array to check
     * @return true iff <code>arr</code> is sorted.
     */
    public static <T extends Comparable<? super T>> boolean sorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] makeIntTestArray() {
        return new Integer[] {
            3, 7, 9, 1, 2,
            18, 16, 15, 19, 8,
            14, 12, 5, 13, 4,
            6, 0, 17, 11, 10
        };
    }

    public void testIntSort(Consumer<Integer[]> func) {
        Integer[] arr = makeIntTestArray();
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    @Test
    public void testIntBubbleSort() {
        testIntSort(Sorts::bubbleSort);
    }
    
    @Test
    public void testIntInsertionSort() {
        testIntSort(Sorts::insertionSort);
    }
    
    @Test
    public void testIntSelectionSort() {
        testIntSort(Sorts::selectionSort);
    }

    @Test
    public void testIntMergeSort() {
        testIntSort(Sorts::mergeSort);
    }
    
    @Test
    public void testIntQuickSort() {
        //testIntSort(Sorts::quickSort);
    }

    @Test
    public void testIntExchangeSort() {
        testIntSort(Sorts::exchangeSort);
    }

    public static Boolean[] makeBoolTestArray() {
        return new Boolean[] {
            true, false, true, true, false, false, false, true, false, false, true
        };
    }

    public void testBoolSort(Consumer<Boolean[]> func) {
        Boolean[] arr = makeBoolTestArray();
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    @Test
    public void testBoolBubbleSort() {
        testBoolSort(Sorts::bubbleSort);
    }
    
    @Test
    public void testBoolInsertionSort() {
        testBoolSort(Sorts::insertionSort);
    }
    
    @Test
    public void testBoolSelectionSort() {
        testBoolSort(Sorts::selectionSort);
    }

    @Test
    public void testBoolMergeSort() {
        testBoolSort(Sorts::mergeSort);
    }
    
    @Test
    public void testBoolQuickSort() {
        //testBoolSort(Sorts::quickSort);
    }

    @Test
    public void testBoolExchangeSort() {
        testBoolSort(Sorts::exchangeSort);
    }

    public static String[] makeStringTestArray() {
        return new String[] {
            "a", "ab", "bds", "k", "kinod", "djewuih", "ieji", "mkduhy"
        };
    }

    public void testStringSort(Consumer<String[]> func) {
        String[] arr = makeStringTestArray();
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    @Test
    public void testStringBubbleSort() {
        testStringSort(Sorts::bubbleSort);
    }
    
    @Test
    public void testStringInsertionSort() {
        testStringSort(Sorts::insertionSort);
    }
    
    @Test
    public void testStringSelectionSort() {
        testStringSort(Sorts::selectionSort);
    }

    @Test
    public void testStringMergeSort() {
        testStringSort(Sorts::mergeSort);
    }
    
    @Test
    public void testStringQuickSort() {
        //testStringSort(Sorts::quickSort);
    }

    @Test
    public void testStringExchangeSort() {
        testStringSort(Sorts::exchangeSort);
    }
}
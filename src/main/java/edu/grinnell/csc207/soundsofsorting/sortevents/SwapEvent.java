package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 */
public class SwapEvent<T> implements SortEvent<T> {
    List<Integer> swapped = new ArrayList<>();

    public SwapEvent(int index1, int index2) {
        swapped.add(index1);
        swapped.add(index2);
    }
    /**
     * gets swapped events
     * 
     * @return swapped
     */
    public List<Integer> getSwapped() {
        return swapped;
    }

    /**
     * swaps
     * 
     * @param <T> T
     * @param arr array
     * @param i index 1
     * @param j index 2
     */
    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * Applies this event to the array.
     * 
     * @param arr the array to modify
     * @param index1 index 1
     * @param index2 index 2
     */
    @Override
    public void apply(T[] arr) {
        swap(arr, swapped.get(0), swapped.get(1));
    }
    

    /**
     * @return a list of the indices affected by this event
     */
    public List<Integer> getAffectedIndices() {
        return swapped;
    }

    /**
     * @return <code>true</code> iff this event is emphasized
     */
    public boolean isEmphasized() {
        return true;
    }
}
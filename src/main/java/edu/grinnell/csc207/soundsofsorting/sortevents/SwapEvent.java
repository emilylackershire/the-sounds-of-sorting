package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 */
public class SwapEvent<T> {
    List<Integer> swapped = new ArrayList<>();

    public List<Integer> getSwapped(){
        return swapped;
    }

    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * Applies this event to the array.
     * @param arr the array to modify
     */
    public void apply(T[] arr, int index1, int index2){
        swap(arr, index1, index2);
    }

    /**
     * @return a list of the indices affected by this event
     */
    public List<Integer> getAffectedIndices(){
        return swapped;
    }
    /**
     * @return <code>true</code> iff this event is emphasized
     */
    public boolean isEmphasized(){
        return true;
    }
}
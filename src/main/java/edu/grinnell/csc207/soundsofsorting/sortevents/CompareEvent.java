package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CompareEvent</code> logs a comparison a sort makes between two
 * indices in the array.
 */
public class CompareEvent<T> {
    List<Integer> compare = new ArrayList<>();

    /**
     * gets compare events
     * 
     * @return compare
     */
    public List<Integer> getCompare() {
        
        return compare;
    }

    /**
     * Applies this event to the array.
     * 
     * @param arr   the array to modify
     * @param index index
     */
    public void apply(T[] arr, int index) {
    }

    /**
     * @return a list of the indices affected by this event
     */
    public List<Integer> getAffectedIndices() {
        return compare;
    }

    /**
     * @return <code>true</code> iff this event is emphasized
     */
    public boolean isEmphasized() {
        return false;
    }
}
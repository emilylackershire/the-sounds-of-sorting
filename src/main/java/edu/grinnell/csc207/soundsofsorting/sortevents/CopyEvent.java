package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> {
    List<Integer> copied = new ArrayList<>();

    public List<Integer> getCopied(){
        return copied;
    }
    /**
     * Applies this event to the array.
     * @param arr the array to modify
     */
    public void apply(T[] arr, int index1, int index2){
        arr[index1] = arr[index2];
    }

    /**
     * @return a list of the indices affected by this event
     */
    public List<Integer> getAffectedIndices(){
        return copied;
    }
    /**
     * @return <code>true</code> iff this event is emphasized
     */
    public boolean isEmphasized(){
        return true;
    }
}

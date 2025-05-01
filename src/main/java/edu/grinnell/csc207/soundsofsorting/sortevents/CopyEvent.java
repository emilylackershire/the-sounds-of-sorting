package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T> {
    List<Integer> copied = new ArrayList<>();
    private T value;

    /**
     * Creates a new <code>CopyEvent</code> with the given index and value.
     * 
     * @param index the index of the array to copy into
     * @param value the value to copy into the array
     */
    public CopyEvent(int index, T value) {
        copied.add(index);
        this.value = value;
    }
    /**
     * gets the copied
     * 
     * @return copied
     */
    public List<Integer> getCopied() {
        return copied;
    }

    /**
     * Applies this event to the array.
     * 
     * @param arr    the array to modify
     */
    @Override
    public void apply(T[] arr) {
        arr[copied.get(0)] = value;
    }

    /**
     * @return a list of the indices affected by this event
     */
    public List<Integer> getAffectedIndices() {
        return copied;
    }

    /**
     * @return <code>true</code> iff this event is emphasized
     */
    public boolean isEmphasized() {
        return true;
    }
}

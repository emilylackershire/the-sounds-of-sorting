package edu.grinnell.csc207.soundsofsorting.sortevents;
import java.util.ArrayList;
import java.util.List;

/**
 * SortEvents are events generated during sorting that allow for playback
 * of the logged sorting algorithm.
 */
public interface SortEvent<T> {
    List<String> sorted = new ArrayList<>();

    public static List<String> getSorted(){
            return sorted;
        }

    /**
     * Applies this event to the array.
     * @param arr the array to modify
     */
    public void apply(T[] arr);

    /**
     * @return a list of the indices affected by this event
     */
    public List<Integer> getAffectedIndices();

    /**
     * @return <code>true</code> iff this event is emphasized
     */
    public boolean isEmphasized();
}

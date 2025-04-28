package edu.grinnell.csc207.soundsofsorting;

/**
 * A collection of indices into a Scale object.
 * These indices are the subject of the various sorting algorithms
 * in the program.
 */
public class NoteIndices {
    Integer[] notes;
    boolean[] highlighted;

    /**
     * @param n the size of the scale object that these indices map into
     */
    public NoteIndices(int n) {
        if (n > 0) {
            notes = new Integer[n];
            highlighted = new boolean[n];
        }
    }

    /**
     * applies a shuffle to the array given
     * 
     * @param arr - array taken in
     * @return - shuffled array
     */
    public static Integer[] shuffle(Integer[] arr) {
        int n;
        if (arr == null) {
            return arr;
        } else {
            for (int i = arr.length - 1; i >= 0; i--) {
                n = (int) (Math.random() * (i + 1));
                Integer temp = arr[i];
                arr[i] = arr[n];
                arr[n] = temp;
            }
        }
        return arr;
    }

    /**
     * Reinitializes this collection of indices to map into a new scale object
     * of the given size. The collection is also shuffled to provide an
     * initial starting point for the sorting process.
     * 
     * @param n the size of the scale object that these indices map into
     */
    public void initializeAndShuffle(int n) {
        notes = new Integer[n];
        highlighted = new boolean[n];
        for (int i = 0; i < n; i++) {
            notes[i] = i;
            highlighted[i] = false;
        }
        shuffle(this.notes);
    }

    /** @return the indices of this NoteIndices object */
    public Integer[] getNotes() {
        return notes;
    }

    /** @return the indices of this NoteIndices object */
    public int getN() {
        return notes.length;
    }

    /**
     * Highlights the given index of the note array
     * 
     * @param index the index to highlight
     */
    public void highlightNote(int index) {
        highlighted[index] = true;
    }

    /**
     * @param index the index to check
     * @return true if the given index is highlighted
     */
    public boolean isHighlighted(Integer index) {
        return highlighted[index] == true;
    }

    /** Clears all highlighted indices from this collection */
    public void clearAllHighlighted() {
        for (int i = 0; i < highlighted.length; i++) {
            highlighted[i] = false;
        }
    }
}

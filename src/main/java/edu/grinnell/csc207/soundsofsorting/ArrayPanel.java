package edu.grinnell.csc207.soundsofsorting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * A drawing panel for visualizing the contents of a @NoteIndices object.
 */
public class ArrayPanel extends JPanel {
    @SuppressWarnings("unused")
    private NoteIndices notes;
    private int WIDTH = 400;
    private int HEIGHT = 300;

    /**
     * Create a new <code>ArrayPanel</code> with the given notes and dimensions.
     * 
     * @param notes  the note indices
     * @param width  the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.WIDTH = width;
        this.HEIGHT = height;
        this.setPreferredSize(new Dimension(width, height));
    }

    /**
     * gets length
     * 
     * @param notes
     * @return returns length
     */
    public int length(NoteIndices notes) {
        Integer[] indices = notes.getNotes();
        int length = indices.length;
        return length;
    }

    /**
     * gets the max index of the notes
     * 
     * @param arr array
     * @return - max index
     */
    public int maxIndex(Integer[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }

    @Override
    public void paintComponent(Graphics g) {
        int barHeight, blue, red, green;
        double barScale, barValues, barMax;
        Integer[] indices = notes.getNotes();
        int max = maxIndex(indices);
        int barWidth = WIDTH / indices.length;
        g.clearRect(0, 0, WIDTH, HEIGHT);

        for (int i = 0; i < indices.length * barWidth; i += barWidth) {
            barHeight = ((indices[i / barWidth]) * (HEIGHT / indices[max])) + HEIGHT / indices[max];
            barValues = (indices[i / barWidth]);
            barMax = (indices[max]);
            barScale = barValues / barMax;
            red = (int) (255 * barScale);
            green = (int) (200 * barScale);
            blue = (int) (200 * barScale);
            Color color = new Color(red, green, blue);
            g.setColor(color);
            g.fillRect(i, HEIGHT - barHeight, barWidth, barHeight);
        }
    }
}
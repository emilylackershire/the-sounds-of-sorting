package edu.grinnell.csc207.soundsofsorting;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * The SortingVisualizer driver.
 */
public class SortingVisualizer {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    // static NoteIndices noteIndices = new NoteIndices(HEIGHT);
    // static int length = noteIndices.getN();

    /**
     * The main entry point to the programs
     * 
     * @param args the command-line arguments
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new BorderLayout());
        NoteIndices notes = new NoteIndices(0);

        ArrayPanel arrayPanel = new ArrayPanel(notes, WIDTH, HEIGHT);
        ControlPanel controlPanel = new ControlPanel(notes, arrayPanel);

        frame.setTitle("Sorting Visualizer");
        frame.add(controlPanel, BorderLayout.PAGE_END);
        frame.add(arrayPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

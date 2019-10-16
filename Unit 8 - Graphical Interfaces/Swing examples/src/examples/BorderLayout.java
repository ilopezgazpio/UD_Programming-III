package examples;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/*
 * A Java swing FlowLayout example
 */
public class BorderLayout
{
    /*
        A BorderLayout lays out a container, arranging its components to fit into five regions: NORTH, SOUTH, EAST, WEST and CENTER.
        For each region, it may contain no more than one component.
        When adding different components, you need to specify the orientation of it to be the one of the five regions.
     */
    public static void main(String[] args)
    {
        // Create and set up a frame window
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("BorderLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Define new buttons with different regions
        JButton jb1 = new JButton("NORTH");
        JButton jb2 = new JButton("SOUTH");
        JButton jb3 = new JButton("WEST");
        JButton jb4 = new JButton("EAST");
        JButton jb5 = new JButton("CENTER");

        // Define the panel to hold the buttons
        JPanel panel = new JPanel();
        java.awt.BorderLayout borderlayout = new java.awt.BorderLayout();
        panel.setLayout(borderlayout);

        panel.add(jb1, java.awt.BorderLayout.NORTH);
        panel.add(jb2, java.awt.BorderLayout.SOUTH);
        panel.add(jb3, java.awt.BorderLayout.WEST);
        panel.add(jb4, java.awt.BorderLayout.EAST);
        panel.add(jb5, java.awt.BorderLayout.CENTER);

        // Set the window to be visible as the default to be false
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

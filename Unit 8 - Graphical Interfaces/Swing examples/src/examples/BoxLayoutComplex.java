package examples;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Component;
import java.awt.FlowLayout;

public class BoxLayoutComplex
{
    /*
     * A swing BoxLayout example with different BoxLayout alignment settings
     * LEFT_ALIGNMENT, CENTER_ALIGNMENT, RIGHT_ALIGNMENT respectively.
     */

    public static void main(String[] args)
    {
        // Create and set up a frame window
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("BoxLayout Example Alignment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Define new buttons with different width on help of the ---
        JButton jb1 = new JButton("Button 1 -");
        JButton jb2 = new JButton("Button 2 --------");
        JButton jb3 = new JButton("Button 3 -");
        JButton jb4 = new JButton("Button 4 --------");
        JButton jb5 = new JButton("Button 5 -");
        JButton jb6 = new JButton("Button 6 --------");

        // Define the panel to hold the buttons
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        // Set up the title for different panels
        panel1.setBorder(BorderFactory.createTitledBorder("LEFT"));
        panel2.setBorder(BorderFactory.createTitledBorder("CENTER"));
        panel3.setBorder(BorderFactory.createTitledBorder("RIGHT"));

        // Set up the BoxLayout
        BoxLayout layout1 = new BoxLayout(panel1, BoxLayout.Y_AXIS);
        BoxLayout layout2 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
        BoxLayout layout3 = new BoxLayout(panel3, BoxLayout.Y_AXIS);

        panel1.setLayout(layout1);
        panel2.setLayout(layout2);
        panel3.setLayout(layout3);

        // Add the buttons into the panel with three different alignment options
        jb1.setAlignmentX(Component.LEFT_ALIGNMENT);
        jb2.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel1.add(jb1);
        panel1.add(jb2);

        jb3.setAlignmentX(Component.CENTER_ALIGNMENT);
        jb4.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(jb3);
        panel2.add(jb4);

        jb5.setAlignmentX(Component.RIGHT_ALIGNMENT);
        jb6.setAlignmentX(Component.RIGHT_ALIGNMENT);
        panel3.add(jb5);
        panel3.add(jb6);

        // Add the three panels into the frame
        frame.setLayout(new FlowLayout());
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);

        // Set the window to be visible as the default to be false
        frame.pack();
        frame.setVisible(true);
    }
}

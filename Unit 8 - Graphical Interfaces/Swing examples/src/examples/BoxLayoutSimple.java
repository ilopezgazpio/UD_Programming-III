package examples;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Insets;
import java.awt.Dimension;

public class BoxLayoutSimple
{
    /*
     In BoxLayout, it puts components in a single row or a single column.
     Only one constructor is used by BoxLayout: BoxLayout(Container target, int axis), which will lay out components along the given axis.
     For the container target, it can be a frame, a panel or other containers to hold the components.
     For the axis, four different axes could be chosen: X_AXIS, Y_AXIS, LINE_AXIS, PAGE_AXIS.
     As X_AXIS and Y_AXIS are more often used

     A swing BoxLayout example with different Boxlayout axis parameters
     BoxLayout.X_AXIS, BoxLayout.Y_AXIS respectively.
     Also add spaces between components.
     */

    public static void main(String[] args)
    {
        // Create and set up a frame window
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("BoxLayout Example X_AXIS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the panel to add buttons
        JPanel panel = new JPanel();

        // Set the BoxLayout to be X_AXIS: from left to right
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        // Set the Boxayout to be Y_AXIS from top to down
        //BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        panel.setLayout(boxlayout);

        // Set border for the panel
        panel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
        //panel.setBorder(new EmptyBorder(new Insets(50, 80, 50, 80)));

        // Define new buttons
        JButton jb1 = new JButton("Button 1");
        JButton jb2 = new JButton("Button 2");
        JButton jb3 = new JButton("Button 3");

        // Add buttons to the frame (and spaces between buttons)
        panel.add(jb1);
        //panel.add(Box.createRigidArea(new Dimension(0, 60)));
        panel.add(jb2);
        //panel.add(Box.createRigidArea(new Dimension(0, 60)));
        panel.add(jb3);

        // Set size for the frame
        //frame.setSize(300, 300);

        // Set the window to be visible as the default to be false
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

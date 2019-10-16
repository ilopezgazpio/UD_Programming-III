package examples;

import javax.swing.*;

public class HelloWorld
{
    JFrame myFrame;
    JButton myButton;

    public HelloWorld()
    {
        myFrame = new JFrame();
        myButton = new JButton();

        myFrame.getContentPane().add(myButton);
        myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        myFrame.setTitle("Hello World");
        myFrame.setSize(150, 150);
        myFrame.setVisible(true);

    }


    public static void main (String [] args)
    {
         HelloWorld myApp = new HelloWorld();
    }

}

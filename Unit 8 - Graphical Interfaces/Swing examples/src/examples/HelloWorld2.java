package examples;

import javax.swing.*;

public class HelloWorld2 extends JFrame
{
    JButton myButton;
    JPanel myPanel;


    public HelloWorld2()
    {
        myButton = new JButton();
        myPanel = new JPanel();

        myPanel.add(myButton);
        this.getContentPane().add(myPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Hello World");
        this.setSize(150, 150);
        this.setVisible(true);

    }


    public static void main (String [] args)
    {
         HelloWorld2 myApp = new HelloWorld2();
    }

}

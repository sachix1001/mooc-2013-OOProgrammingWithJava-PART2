package clicker.ui;

import clicker.applicationlogic.Calculator;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    private Calculator calculator;

    public UserInterface() {
    }
    
    public UserInterface(Calculator calculator) {
        this.calculator = calculator;
    }
    
    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.setLayout(new BorderLayout());
        JButton clickButton = new JButton("Click!");
        JLabel number = new JLabel("0");
        
        ClickListener click = new ClickListener(calculator, number);
        clickButton.addActionListener(click);
        
        container.add(clickButton, BorderLayout.SOUTH);
        container.add(number, BorderLayout.CENTER);
    }

    public JFrame getFrame() {
        return frame;
    }
}

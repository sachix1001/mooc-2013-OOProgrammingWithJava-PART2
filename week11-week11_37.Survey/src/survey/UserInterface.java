package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Survey");
        frame.setPreferredSize(new Dimension(200, 300));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
 
        createComponents(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
        // Create your app here
    }


    public JFrame getFrame() {
        return frame;
    }

    private void createComponents(Container contentPane) {
        BoxLayout layout = new BoxLayout(contentPane, BoxLayout.Y_AXIS);
        contentPane.setLayout(layout);
        
        contentPane.add(new JLabel("Are you?"));
        
        JCheckBox yes = new JCheckBox("Yes!");
        JCheckBox no = new JCheckBox("No!");
        
        contentPane.add(yes);
        contentPane.add(no);
        
        contentPane.add(new JLabel("Why?"));
        JRadioButton a = new JRadioButton("No reason.");
        JRadioButton b = new JRadioButton("Because it is fun!");
        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(a);
        buttonGroup.add(b);
        
        contentPane.add(a);
        contentPane.add(b);
        
        JButton done = new JButton("Done!");
        contentPane.add(done);
    }
}

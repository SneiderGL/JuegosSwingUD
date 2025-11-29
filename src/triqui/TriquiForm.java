package triqui;

import javax.swing.*;

public class TriquiForm {
    private JPanel panel1;
    private JButton btn01;
    private JButton btn00;
    private JButton btn10;
    private JButton btn11;
    private JButton btn02;
    private JButton btn20;
    private JButton btn21;
    private JButton btn22;
    private JButton btn12;

    public void show() {
        JFrame frame = new JFrame("Triqui UD");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

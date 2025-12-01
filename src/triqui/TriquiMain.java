package triqui;

import javax.swing.*;

public class TriquiMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TriquiForm().show();
        });
    }
}

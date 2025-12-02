package adivina;

import javax.swing.*;

public class MainAdivina {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdivinaForm().show());
    }
}

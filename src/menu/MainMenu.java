package menu;

import javax.swing.*;

public class MainMenu {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuForm().show());
    }
}

package menu;

import javax.swing.*;
import triqui.TriquiForm;
import ahorcados.AhorcadosForm;
import parejaslocas.MemoramaForm;
import adivina.AdivinaForm;

public class MenuForm {
    private JPanel panelMain;
    private JButton btnTriqui;
    private JButton btnAhorcados;
    private JButton btnParejas;
    private JButton btnAdivina;

    public MenuForm() {

        btnTriqui.addActionListener(e -> new TriquiForm().show());
        btnAhorcados.addActionListener(e -> new AhorcadosForm().show());
        btnParejas.addActionListener(e -> new MemoramaForm().show());
        btnAdivina.addActionListener(e -> new AdivinaForm().show());
    }

    public void show() {
        JFrame frame = new JFrame("Menú Juegos UD");
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

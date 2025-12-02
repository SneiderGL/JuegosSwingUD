package adivina;

import javax.swing.*;
import java.util.Random;

public class AdivinaForm {

    private JPanel panelMain;
    private JLabel lblInstruccion;
    private JTextField txtNumero;
    private JButton btnProbar;
    private JLabel lblResultado;
    private JButton btnReiniciar;

    private int numeroSecreto;

    public AdivinaForm() {
        generarNumero();

        btnProbar.addActionListener(e -> {
            String texto = txtNumero.getText().trim();

            if (texto.isEmpty()) {
                lblResultado.setText("Escribe un número.");
                return;
            }

            int intento;
            try {
                intento = Integer.parseInt(texto);
            } catch (NumberFormatException ex) {
                lblResultado.setText("Solo números válidos.");
                return;
            }

            if (intento < numeroSecreto) {
                lblResultado.setText("Muy bajo.");
            } else if (intento > numeroSecreto) {
                lblResultado.setText("Muy alto.");
            } else {
                lblResultado.setText("🎉 ¡Correcto! Era " + numeroSecreto);
            }
        });

        btnReiniciar.addActionListener(e -> {
            generarNumero();
            lblResultado.setText("Nuevo número generado.");
            txtNumero.setText("");
        });
    }

    private void generarNumero() {
        numeroSecreto = new Random().nextInt(100) + 1;
    }

    public void show() {
        JFrame f = new JFrame("Adivina el número");
        f.setContentPane(panelMain);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}

package ahorcados;

import javax.swing.*;
import java.util.Random;

public class AhorcadosForm {
    private JPanel panelMain;
    private JLabel lblPalabra;
    private JLabel lblIntentos;
    private JTextField txtLetra;
    private JButton btnProbar;
    private JTextArea txtHistorial;
    private JButton btnReiniciar;

    private final String[] palabras = {
            "AMERICA DEL CALI",
            "SOLO ROJO",
            "UNIVERSIDAD DISTRITAL",
            "PROGRAMACION ORIENTADA A OBJETOS",
            "PAPELERIA",
            "MERCADO LIBRE",
            "ESTRUCTURAS DE DATOS",
            "INGENIERIA ELECTRICA",
            "TRIQUI",
            "JAVA SWING"
    };

    private String palabraOculta;
    private char[] progreso;
    private int intentos;

    public AhorcadosForm() {
        iniciarJuego();

        btnProbar.addActionListener(e -> {
            String entrada = txtLetra.getText().toUpperCase();

            if (entrada.length() != 1) {
                JOptionPane.showMessageDialog(panelMain, "Ingresa solo UNA letra");
                return;
            }

            char letra = entrada.charAt(0);
            txtLetra.setText("");

            boolean acierto = false;

            for (int i = 0; i < palabraOculta.length(); i++) {
                if (palabraOculta.charAt(i) == letra) {
                    progreso[i] = letra;
                    acierto = true;
                }
            }

            if (!acierto) {
                intentos--;
                txtHistorial.append(letra + " ");
            }

            actualizarUI();

            if (String.valueOf(progreso).equals(palabraOculta)) {
                JOptionPane.showMessageDialog(panelMain, "¡Ganaste!");
                iniciarJuego();
            }

            if (intentos <= 0) {
                JOptionPane.showMessageDialog(panelMain,
                        "PERDISTE.\nLa palabra era:\n" + palabraOculta);
                iniciarJuego();
            }
        });

        btnReiniciar.addActionListener(e -> iniciarJuego());
    }

    private void iniciarJuego() {
        palabraOculta = palabras[new Random().nextInt(palabras.length)];

        // Reemplaza letras por _ pero deja espacios intactos
        progreso = palabraOculta.replaceAll("[A-Z]", "_").toCharArray();

        intentos = 12; // límite de intentos
        txtHistorial.setText("");
        actualizarUI();
    }

    private void actualizarUI() {
        lblPalabra.setText(String.valueOf(progreso));
        lblIntentos.setText("Intentos restantes: " + intentos);
    }

    public void show() {
        JFrame frame = new JFrame("Ahorcados");
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

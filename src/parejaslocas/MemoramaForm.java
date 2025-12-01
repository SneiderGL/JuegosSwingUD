package parejaslocas;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemoramaForm {
    private JPanel panelMain;
    private JButton btn00;
    private JButton btn01;
    private JButton btn02;
    private JButton btn03;
    private JButton btn04;
    private JButton btn05;
    private JButton btn06;
    private JButton btn07;
    private JButton btn08;
    private JButton btn09;
    private JButton btn10;
    private JButton btn11;
    private JButton btnReiniciar;
    private JLabel lblEstado;

    private JButton[] botones;
    private List<String> cartas;

    private JButton primeraSeleccion = null;
    private JButton segundaSeleccion = null;

    public MemoramaForm() {

        botones = new JButton[]{
                btn00, btn01, btn02, btn03,
                btn04, btn05, btn06, btn07,
                btn08, btn09, btn10, btn11
        };

        btnReiniciar.addActionListener(e -> iniciarJuego());

        for (JButton b : botones) {
            b.addActionListener(e -> manejarSeleccion(b));
        }

        iniciarJuego();
    }

    private void iniciarJuego() {

        List<String> base = List.of(
                "❤️",
                "(●'◡'●)",
                "╰(*°▽°*)╯",
                "CALI",
                "💕UD💕",
                "🎶memorama🎶"
        );

        cartas = new ArrayList<>();

        for (String c : base) {
            cartas.add(c);
            cartas.add(c);
        }

        Collections.shuffle(cartas);

        for (int i = 0; i < botones.length; i++) {
            botones[i].setText("❓");
            botones[i].setEnabled(true);
            botones[i].putClientProperty("valor", cartas.get(i));
        }

        primeraSeleccion = null;
        segundaSeleccion = null;

        lblEstado.setText("Encuentra los pares");
    }

    private void manejarSeleccion(JButton btn) {

        if (primeraSeleccion != null && segundaSeleccion != null) return;

        btn.setText((String) btn.getClientProperty("valor"));
        btn.setEnabled(false);

        if (primeraSeleccion == null) {
            primeraSeleccion = btn;
            return;
        }

        segundaSeleccion = btn;

        Timer timer = new Timer(800, e -> {
            if (primeraSeleccion.getClientProperty("valor")
                    .equals(segundaSeleccion.getClientProperty("valor"))) {

                lblEstado.setText("¡Acierto!");

            } else {
                lblEstado.setText("Fallaste :(");
                primeraSeleccion.setText("❓");
                primeraSeleccion.setEnabled(true);
                segundaSeleccion.setText("❓");
                segundaSeleccion.setEnabled(true);
            }

            primeraSeleccion = null;
            segundaSeleccion = null;

            if (verificarVictoria()) {
                lblEstado.setText("🎉 ¡Ganaste el memorama! 🎉");
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    private boolean verificarVictoria() {
        for (JButton b : botones) {
            if (b.getText().equals("❓")) return false;
        }
        return true;
    }

    public void show() {
        JFrame frame = new JFrame("Memorama UD");
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

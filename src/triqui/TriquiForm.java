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

    private JButton[][] board;
    private boolean turnoX = true; // true = X, false = O

    public TriquiForm() {

        // Inicializamos la matriz con los botones creados en el GUI Designer
        board = new JButton[][]{
                {btn00, btn01, btn02},
                {btn10, btn11, btn12},
                {btn20, btn21, btn22}
        };

        // Listener para cada botón
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                JButton b = board[i][j];

                b.addActionListener(e -> {
                    if (turnoX) {
                        b.setText("X");
                    } else {
                        b.setText("O");
                    }

                    b.setEnabled(false); // No permitir oprimir de nuevo

                    if (checkWinner()) {
                        String ganador = turnoX ? "X" : "O";
                        JOptionPane.showMessageDialog(panel1, "¡Ganó " + ganador + "!");
                        resetBoard();
                        return;
                    }

                    if (tableroLleno()) {
                        JOptionPane.showMessageDialog(panel1, "¡Empate!");
                        resetBoard();
                        return;
                    }

                    turnoX = !turnoX; // cambiar turno
                });
            }
        }
    }

    // Mostrar la ventana
    public void show() {
        JFrame frame = new JFrame("Triqui UD");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    // =============================
    //       LÓGICA DEL TRIQUI
    // =============================

    private boolean checkWinner() {
        // Filas
        for (int i = 0; i < 3; i++) {
            if (igual(board[i][0], board[i][1], board[i][2])) return true;
        }

        // Columnas
        for (int j = 0; j < 3; j++) {
            if (igual(board[0][j], board[1][j], board[2][j])) return true;
        }

        // Diagonal principal
        if (igual(board[0][0], board[1][1], board[2][2])) return true;

        // Diagonal secundaria
        if (igual(board[0][2], board[1][1], board[2][0])) return true;

        return false;
    }

    private boolean igual(JButton a, JButton b, JButton c) {
        return !a.getText().isEmpty() &&
                a.getText().equals(b.getText()) &&
                b.getText().equals(c.getText());
    }

    private boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getText().isEmpty()) return false;
            }
        }
        return true;
    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j].setText("");
                board[i][j].setEnabled(true);
            }
        }
        turnoX = true;
    }
}

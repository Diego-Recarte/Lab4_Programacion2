/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4_prog2;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author denam
 */

public class GUISeleccion extends JDialog {

    private JButton btnSeguir;
    private JLabel lblorden;
    private JLabel lblerror;
    private JTextField txtpalabra;
    private JPanel panel;

    private JuegoAhorcado juegoCreado;

    public GUISeleccion(GUImenu Padre) {

        super(Padre, "Seleccion", true);

        setDefaultCloseOperation(
            JDialog.DISPOSE_ON_CLOSE
        );

        Dimension pantalla =
            Toolkit.getDefaultToolkit().getScreenSize();

        setSize(
            pantalla.width,
            pantalla.height
        );

        setLayout(
            new BorderLayout(10, 10)
        );

        getContentPane().setBackground(
            Color.WHITE
        );

        setLocationRelativeTo(Padre);

        InicializarPanel();

        setVisible(true);
    }

    private void InicializarPanel() {

        JPanel Panelenvuelto =
            new JPanel(new GridBagLayout());

        lblorden =
            new JLabel("Ingrese la palabra secreta");

        lblorden.setFont(
            new Font("Arial", Font.BOLD, 20)
        );

        lblorden.setPreferredSize(
            new Dimension(600, 150)
        );

        lblorden.setMaximumSize(
            new Dimension(600, 150)
        );

        lblorden.setForeground(Color.BLACK);

        lblorden.setHorizontalAlignment(
            SwingConstants.CENTER
        );

        lblorden.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );

        txtpalabra =
            new JTextField();

        txtpalabra.setFont(
            new Font("Arial", Font.BOLD, 20)
        );

        txtpalabra.setPreferredSize(
            new Dimension(600, 100)
        );

        txtpalabra.setMaximumSize(
            new Dimension(600, 100)
        );

        txtpalabra.setHorizontalAlignment(
            SwingConstants.CENTER
        );

        txtpalabra.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );

        btnSeguir =
            new JButton("Ingresar");

        btnSeguir.setFont(
            new Font("Arial", Font.BOLD, 14)
        );

        btnSeguir.setPreferredSize(
            new Dimension(600, 150)
        );

        btnSeguir.setMaximumSize(
            new Dimension(600, 150)
        );

        btnSeguir.setForeground(Color.WHITE);
        btnSeguir.setBackground(Color.BLUE);

        btnSeguir.setFocusPainted(false);
        btnSeguir.setBorderPainted(false);
        btnSeguir.setOpaque(true);

        btnSeguir.setHorizontalAlignment(
            SwingConstants.CENTER
        );

        btnSeguir.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );

        btnSeguir.addActionListener(
            e -> crearJuego()
        );

        txtpalabra.addActionListener(
            e -> crearJuego()
        );

        lblerror =
            new JLabel(" ");

        lblerror.setFont(
            new Font("Arial", Font.BOLD, 14)
        );

        lblerror.setPreferredSize(
            new Dimension(600, 75)
        );

        lblerror.setMaximumSize(
            new Dimension(600, 75)
        );

        lblerror.setForeground(Color.RED);

        lblerror.setHorizontalAlignment(
            SwingConstants.CENTER
        );

        lblerror.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );

        panel =
            new JPanel();

        panel.setLayout(
            new BoxLayout(
                panel,
                BoxLayout.Y_AXIS
            )
        );

        panel.setPreferredSize(
            new Dimension(700, 500)
        );

        panel.setOpaque(false);

        panel.setBorder(
            BorderFactory.createEmptyBorder(
                10,
                10,
                10,
                10
            )
        );

        panel.add(lblorden);

        panel.add(
            Box.createVerticalStrut(20)
        );

        panel.add(txtpalabra);

        panel.add(
            Box.createVerticalStrut(20)
        );

        panel.add(btnSeguir);

        panel.add(
            Box.createVerticalStrut(20)
        );

        panel.add(lblerror);

        Panelenvuelto.add(panel);

        add(
            Panelenvuelto,
            BorderLayout.CENTER
        );
    }

    private void crearJuego() {

        String palabra =
            txtpalabra.getText().trim();

        if (palabra.isEmpty()) {

            lblerror.setText(
                "Debe ingresar una palabra."
            );

            return;
        }

        if (!palabra.matches(
            "[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+"
        )) {

            lblerror.setText(
                "La palabra solo debe contener letras."
            );

            return;
        }

        juegoCreado =
            new AhorcadoPalabraFija(
                palabra
            );

        dispose();
    }

    public JuegoAhorcado getJuegoCreado() {
        return juegoCreado;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4_prog2;

/**
 *
 * @author denam
 */



import javax.swing.*;
import java.awt.*;

public class GUIFinalizacion extends JDialog {

    private JButton btnSeguir;
    private JLabel lblorden;
    private JLabel lblerror;
    private JButton lblSalir;
    private JLabel txtpalabra;
    private JPanel panel;

    public GUIFinalizacion(
        GuiJuego Padre,
        boolean isVictoria
    ) {

        super(
            Padre,
            "Finalización",
            true
        );

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

        InicializarPanel(
            Padre,
            isVictoria
        );

        setVisible(true);
    }

    private void InicializarPanel(
        GuiJuego Padre,
        boolean isVictoria
    ) {

        JPanel Panelenvuelto =
            new JPanel(
                new GridBagLayout()
            );

        if (isVictoria) {

            lblorden =
                new JLabel(
                    "¡Felicidades!"
                );

        } else {

            lblorden =
                new JLabel(
                    "¡Has perdido!"
                );
        }

        lblorden.setFont(
            new Font(
                "Arial",
                Font.BOLD,
                30
            )
        );

        lblorden.setPreferredSize(
            new Dimension(
                600,
                100
            )
        );

        lblorden.setForeground(
            Color.BLACK
        );

        lblorden.setHorizontalAlignment(
            SwingConstants.CENTER
        );

        lblorden.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );

        String palabra =
            Padre
            .getJuego()
            .getPalabraSecreta();

        txtpalabra =
            new JLabel(
                "La palabra era: " + palabra
            );

        txtpalabra.setFont(
            new Font(
                "Arial",
                Font.BOLD,
                22
            )
        );

        txtpalabra.setPreferredSize(
            new Dimension(
                600,
                100
            )
        );

        txtpalabra.setHorizontalAlignment(
            SwingConstants.CENTER
        );

        txtpalabra.setAlignmentX(
            Component.CENTER_ALIGNMENT
        );

        btnSeguir =
            new JButton(
                "Ir al menú"
            );

        btnSeguir.setFont(
            new Font(
                "Arial",
                Font.BOLD,
                18
            )
        );

        btnSeguir.setPreferredSize(
            new Dimension(
                600,
                100
            )
        );

        btnSeguir.setMaximumSize(
            new Dimension(
                600,
                100
            )
        );

        btnSeguir.setForeground(
            Color.WHITE
        );

        btnSeguir.setBackground(
            Color.BLUE
        );

        btnSeguir.setFocusPainted(false);
        btnSeguir.setBorderPainted(false);
        btnSeguir.setOpaque(true);

        btnSeguir.addActionListener(e -> {

            dispose();

            Padre.dispose();

            new GUImenu();
        });

        lblSalir =
            new JButton(
                "Salir"
            );

        lblSalir.setFont(
            new Font(
                "Arial",
                Font.BOLD,
                18
            )
        );

        lblSalir.setPreferredSize(
            new Dimension(
                600,
                100
            )
        );

        lblSalir.setMaximumSize(
            new Dimension(
                600,
                100
            )
        );

        lblSalir.setForeground(
            Color.WHITE
        );

        lblSalir.setBackground(
            Color.RED
        );

        lblSalir.setFocusPainted(false);
        lblSalir.setBorderPainted(false);
        lblSalir.setOpaque(true);

        lblSalir.addActionListener(
            e -> System.exit(0)
        );

        lblerror =
            new JLabel(" ");

        panel =
            new JPanel();

        panel.setLayout(
            new BoxLayout(
                panel,
                BoxLayout.Y_AXIS
            )
        );

        panel.setPreferredSize(
            new Dimension(
                700,
                600
            )
        );

        panel.setOpaque(false);

        panel.setBorder(
            BorderFactory.createEmptyBorder(
                20,
                20,
                20,
                20
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

        panel.add(lblSalir);

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
}
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

public class GuiJuego extends JFrame {
     private JLabel lblTurnos;
     private int turno ;
    private JPanel panelAhorcado;
    private JPanel panelLetrasEncontradas;
    private JPanel panelLetrasErroneas;
    private JLabel lblPalabrasEncontradas;
    private JLabel lblPalabrasErroneas;
    private JLabel lblFallosDisponibles;
    private JTextField txtIngresar;
    private JPanel panelPalabra;
    private JButton btnComprobar;
    private JLabel lblError;

    private JLabel[][] tableroPalabra;
    private JLabel[] letrasEncontradas;
    private JLabel[] letrasErroneas;
    private JLabel[] imagenAhorcado;

    private Timer timerError;

    // referencia al juego en curso; hay que setearla desde donde se cree esta ventana
    // ej: GuiJuego gui = new GuiJuego("Palabra fija", 6); gui.setJuego(miJuego);
    private JuegoAhorcado juego;

    public GuiJuego(String mensaje, int turno) {
        this.turno = turno;
        setTitle(mensaje);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        crearInterfaz(mensaje);
        setVisible(true);
    }

    public void setJuego(JuegoAhorcado juego) {
        this.juego = juego;
    }

    private void crearInterfaz(String mensaje) {
        JPanel contenedorPrincipal = new JPanel(new GridLayout(1, 3, 20, 0));
        contenedorPrincipal.setBackground(Color.WHITE);
        contenedorPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel columnaIzquierda = crearColumnaIzquierda();
        JPanel columnaCentro = crearColumnaCentro(mensaje);
        JPanel columnaDerecha = crearColumnaDerecha();

        contenedorPrincipal.add(columnaIzquierda);
        contenedorPrincipal.add(columnaCentro);
        contenedorPrincipal.add(columnaDerecha);

        add(contenedorPrincipal, BorderLayout.CENTER);
    }

    private JPanel crearColumnaIzquierda() {
        JPanel columna = new JPanel();
        columna.setBackground(Color.WHITE);
        columna.setLayout(new BoxLayout(columna, BoxLayout.Y_AXIS));

        lblTurnos = new JLabel("Turnos");
        lblTurnos.setFont(new Font("Arial", Font.BOLD, 24));
        lblTurnos.setAlignmentX(CENTER_ALIGNMENT);

        lblPalabrasEncontradas = new JLabel("Palabras encontradas");
        lblPalabrasEncontradas.setFont(new Font("Arial", Font.BOLD, 20));
        lblPalabrasEncontradas.setAlignmentX(CENTER_ALIGNMENT);

        panelLetrasEncontradas = new JPanel(new GridLayout(6, 5, 10, 10));
        panelLetrasEncontradas.setBackground(Color.WHITE);
        panelLetrasEncontradas.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panelLetrasEncontradas.setMaximumSize(new Dimension(350, 500));
        panelLetrasEncontradas.setPreferredSize(new Dimension(350, 500));

        letrasEncontradas = new JLabel[30];
        for (int i = 0; i < letrasEncontradas.length; i++) {
            letrasEncontradas[i] = new JLabel("", JLabel.CENTER);
            letrasEncontradas[i].setFont(new Font("Arial", Font.BOLD, 22));
            letrasEncontradas[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
            letrasEncontradas[i].setVisible(false);
            panelLetrasEncontradas.add(letrasEncontradas[i]);
        }

        columna.add(lblTurnos);
        columna.add(Box.createRigidArea(new Dimension(0, 30)));
        columna.add(lblPalabrasEncontradas);
        columna.add(Box.createRigidArea(new Dimension(0, 15)));
        columna.add(panelLetrasEncontradas);

        return columna;
    }

    private JPanel crearColumnaCentro(String mensaje) {
        JPanel columna = new JPanel();
        columna.setBackground(Color.WHITE);
        columna.setLayout(new BoxLayout(columna, BoxLayout.Y_AXIS));

        lblFallosDisponibles = new JLabel("Fallos disponibles: 6");
        lblFallosDisponibles.setFont(new Font("Arial", Font.BOLD, 20));
        lblFallosDisponibles.setAlignmentX(CENTER_ALIGNMENT);

        panelAhorcado = new JPanel();
        panelAhorcado.setLayout(new GridLayout(3, 2, 10, 10));
        
        panelAhorcado.setBackground(Color.WHITE);
        panelAhorcado.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panelAhorcado.setPreferredSize(new Dimension(500, 350));
        panelAhorcado.setMaximumSize(new Dimension(500, 350));
        cargarPanelAhorcado(JuegoAhorcado.getFiguraAhorcado());
        

        txtIngresar = new JTextField();
        txtIngresar.setMaximumSize(new Dimension(80, 40));
        txtIngresar.setPreferredSize(new Dimension(80, 40));
        txtIngresar.setFont(new Font("Arial", Font.PLAIN, 22));
        txtIngresar.setHorizontalAlignment(JTextField.CENTER);
        

        panelPalabra = new JPanel();
        panelPalabra.setBackground(Color.WHITE);
        panelPalabra.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panelPalabra.setMaximumSize(new Dimension(500, 120));
        panelPalabra.setPreferredSize(new Dimension(500, 120));

        construirPanelPalabra(mensaje);

        btnComprobar = new JButton("Comprobar");
        btnComprobar.setAlignmentX(CENTER_ALIGNMENT);
        btnComprobar.setMaximumSize(new Dimension(160, 45));
        btnComprobar.setFont(new Font("Arial", Font.BOLD, 18));
        btnComprobar.addActionListener(ev->{
        detectarPalabra(txtIngresar.getText());
        });
        

        lblError = new JLabel("");
        lblError.setFont(new Font("Arial", Font.PLAIN, 14));
        lblError.setForeground(Color.RED);
        lblError.setAlignmentX(CENTER_ALIGNMENT);

        columna.add(lblFallosDisponibles);
        columna.add(Box.createRigidArea(new Dimension(0, 15)));
        columna.add(panelAhorcado);
        columna.add(Box.createRigidArea(new Dimension(0, 20)));
        columna.add(txtIngresar);
        columna.add(Box.createRigidArea(new Dimension(0, 15)));
        columna.add(panelPalabra);
        columna.add(Box.createRigidArea(new Dimension(0, 15)));
        columna.add(btnComprobar);
        columna.add(Box.createRigidArea(new Dimension(0, 10)));
        columna.add(lblError);

        return columna;
    }
    
    private void detectarPalabra(String letra){
        try {
            if (letra.length() != 1) {
                throw new LetraInvalidaException("Debes ingresar una sola letra.");
            }

            char letraChar = letra.charAt(0);
            boolean acerto = juego.procesarJugada(letraChar);
            actualizarTableroLetras(letra, acerto);
            // aquí se puede revisar juego.determinarVictoria() o si ya se acabaron los intentos

        } catch (LetraInvalidaException | LetraRepetidaException e) {
            mostrarErrorTemporal(e.getMessage());
        } finally {
            txtIngresar.setText("");
        }
    }
            
            
    
    

    private JPanel crearColumnaDerecha() {
        JPanel columna = new JPanel();
        columna.setBackground(Color.WHITE);
        columna.setLayout(new BoxLayout(columna, BoxLayout.Y_AXIS));

        lblPalabrasErroneas = new JLabel("Palabras erronesas");
        lblPalabrasErroneas.setFont(new Font("Arial", Font.BOLD, 20));
        lblPalabrasErroneas.setAlignmentX(CENTER_ALIGNMENT);

        panelLetrasErroneas = new JPanel(new GridLayout(6, 5, 10, 10));
        panelLetrasErroneas.setBackground(Color.WHITE);
        panelLetrasErroneas.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panelLetrasErroneas.setMaximumSize(new Dimension(350, 500));
        panelLetrasErroneas.setPreferredSize(new Dimension(350, 500));

        letrasErroneas = new JLabel[30];
        for (int i = 0; i < letrasErroneas.length; i++) {
            letrasErroneas[i] = new JLabel("", JLabel.CENTER);
            letrasErroneas[i].setFont(new Font("Arial", Font.BOLD, 22));
            letrasErroneas[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
            letrasErroneas[i].setVisible(false);
            panelLetrasErroneas.add(letrasErroneas[i]);
        }

        columna.add(Box.createRigidArea(new Dimension(0, 54)));
        columna.add(lblPalabrasErroneas);
        columna.add(Box.createRigidArea(new Dimension(0, 15)));
        columna.add(panelLetrasErroneas);

        return columna;
    }

    public void construirPanelPalabra(String palabra) {
        panelPalabra.removeAll();

        int columnas = palabra.length();
        panelPalabra.setLayout(new GridLayout(2, columnas, 5, 5));

        tableroPalabra = new JLabel[2][columnas];

        for (int i = 0; i < columnas; i++) {
            tableroPalabra[0][i] = new JLabel("", JLabel.CENTER);
            tableroPalabra[0][i].setFont(new Font("Arial", Font.BOLD, 26));
            tableroPalabra[0][i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
            panelPalabra.add(tableroPalabra[0][i]);
        }

        for (int i = 0; i < columnas; i++) {
            tableroPalabra[1][i] = new JLabel("-", JLabel.CENTER);
            tableroPalabra[1][i].setFont(new Font("Arial", Font.BOLD, 26));
            tableroPalabra[1][i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
            panelPalabra.add(tableroPalabra[1][i]);
        }

        int ancho = columnas * 60;
        if (ancho < 250) {
            ancho = 250;
        }
        if (ancho > 700) {
            ancho = 700;
        }

        panelPalabra.setMaximumSize(new Dimension(ancho, 120));
        panelPalabra.setPreferredSize(new Dimension(ancho, 120));

        panelPalabra.revalidate();
        panelPalabra.repaint();
    }

    public void actualizarTableroLetras(String letra, boolean seEncontro) {
        JLabel[] tableroSeleccionado;

        if (seEncontro) {
            tableroSeleccionado = letrasEncontradas;
        } else {
            tableroSeleccionado = letrasErroneas;
            Actualizarturno();
            ActualizarImagen()
        }

        for (int i = 0; i < tableroSeleccionado.length; i++) {
            if (!tableroSeleccionado[i].isVisible()) {
                tableroSeleccionado[i].setText(letra);
                tableroSeleccionado[i].setVisible(true);
                break;
            }
        }
    }

    public void mostrarErrorTemporal(String texto) {
        lblError.setText(texto);

        timerError = new Timer(2000, ev ->{
            
            lblError.setText(" ");
            
        });
        timerError.start();
        
    }
    private void Actualizarturno(){
        turno--;
        lblTurnos.setText("Fallos disponibles: "+turno);
    }

    public JTextField getTxtIngresar() {
        return txtIngresar;
    }

    public JButton getBtnComprobar() {
        return btnComprobar;
    }

    public JLabel[][] getTableroPalabra() {
        return tableroPalabra;
    }
}
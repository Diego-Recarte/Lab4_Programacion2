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
    private JTextField txtpalabra;
    private JPanel panel;
    
    
    
    public GUIFinalizacion(GuiJuego Padre, boolean isVictoria){
       super(Padre, "Seleccion", true);
 

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(pantalla.width, pantalla.height);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.WHITE);
     setLocationRelativeTo(Padre);
     
     
     InicializarPanel(Padre, isVictoria);
     this.setVisible(true);
             
     
    }
    
    private void InicializarPanel(GUImenu Padre, boolean isVictoria){
        JPanel Panelenvuelto =new JPanel(new GridBagLayout());
        
        if (isVictoria){
        lblorden = new JLabel("Felicidades");
        }else{
            lblorden = new JLabel("Fracaso");
        }

        lblorden.setFont(new Font("Arial", Font.BOLD, 20));
        lblorden.setPreferredSize(new Dimension(600, 150));
        lblorden.setMaximumSize(new Dimension(600, 150));

        lblorden.setForeground(Color.black);
      

       
        lblorden.setOpaque(false);

        lblorden.setHorizontalAlignment(SwingConstants.CENTER);
        lblorden.setAlignmentX(Component.CENTER_ALIGNMENT);

       
        
        
        
        
        txtpalabra= new JTextField();

        txtpalabra.setFont(new Font("Arial", Font.BOLD, 14));
        txtpalabra.setPreferredSize(new Dimension(600, 150));
        txtpalabra.setMaximumSize(new Dimension(600, 150));


       
        txtpalabra.setOpaque(true);

        txtpalabra.setHorizontalAlignment(SwingConstants.CENTER);
        txtpalabra.setAlignmentX(Component.CENTER_ALIGNMENT);

       
        
        
        btnSeguir = new JButton("Ir al menu");

        btnSeguir.setFont(new Font("Arial", Font.BOLD, 14));
        btnSeguir.setPreferredSize(new Dimension(600, 150));
        btnSeguir.setMaximumSize(new Dimension(600, 150));

        btnSeguir.setForeground(Color.WHITE);
        btnSeguir.setBackground(Color.blue);

        btnSeguir.setFocusPainted(false);
        btnSeguir.setBorderPainted(false);
        btnSeguir.setContentAreaFilled(false);
        btnSeguir.setOpaque(true);

        btnSeguir.setHorizontalAlignment(SwingConstants.CENTER);
        btnSeguir.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnSeguir.addActionListener(e -> {
            GUImenu men = new GUImenu();
            this.dispose();
            Padre.dispose();
        });
        
        lblSalir = new JButton("Salir");

        lblSalir.setFont(new Font("Arial", Font.BOLD, 14));
        lblSalir.setPreferredSize(new Dimension(600, 150));
        lblSalir.setMaximumSize(new Dimension(600, 150));

        lblSalir.setForeground(Color.WHITE);
        lblSalir.setBackground(Color.blue);

        lblSalir.setFocusPainted(false);
        lblSalir.setBorderPainted(false);
        lblSalir.setContentAreaFilled(false);
        lblSalir.setOpaque(true);

        lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
        lblSalir.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblSalir.addActionListener(e -> {
            System.exit(0);
        });
        panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(400, 230));
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        
        panel.add(lblorden);
        panel.add(Box.createVerticalStrut(20));
        panel.add(txtpalabra);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnSeguir);
         panel.add(Box.createVerticalStrut(20));
        panel.add(lblerror);
        Panelenvuelto.add(panel);
        add (Panelenvuelto, BorderLayout.CENTER);
        
    }
    
    
    
}

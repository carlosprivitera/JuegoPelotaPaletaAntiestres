package client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
    private Tablero tablero = new Tablero();
    private BorderLayout borderLayout1 = new BorderLayout();
    private JButton jButton1 = new JButton();

    public VentanaPrincipal() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(borderLayout1);
        this.setSize(new Dimension(400, 426));
        this.setTitle("Juego antiestrés");
        tablero.setBounds(new Rectangle(20, 25, 305, 365));
        this.getContentPane().add(tablero, BorderLayout.CENTER);
        this.getContentPane().add(jButton1, BorderLayout.NORTH);
        jButton1.setText("Iniciar juego nuevo");
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1_actionPerformed(e);
                }
            });
        tablero.lanzarJuego();
        jButton1.setFocusable(false);
        tablero.setFocusable(true);
    }
    public static void main(String[] args) {
        VentanaPrincipal vp = new VentanaPrincipal();
        vp.setDefaultCloseOperation(vp.EXIT_ON_CLOSE);
        vp.setLocationRelativeTo(null);
        vp.setVisible(true);
    }

    private void jButton1_actionPerformed(ActionEvent e) {
        tablero.iniciarJuegoNuevo();
    }
}

package client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

public class Tablero extends JPanel {
    private Paleta paleta = new Paleta();
    private Bola bola = new Bola() {
        @Override
        public boolean esColision2() {
            return paleta.miGetBounds().intersects(bola.miGetBounds());
        }
    };
    private Ciclo ciclo = new Ciclo() {
        @Override
        public void mover() {
            miMover();
        }
    };

    private Font font = new Font("Arial", 1, 16);

    public Tablero() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void miMover() {
        paleta.moverFPS();
        bola.moverFPS();
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(font);
        g2d.setColor(Color.blue);
        g2d.drawString("Atrapadas = " + bola.getAtrapadas(), 10, 40);
        g2d.drawString("No atrapadas = " + bola.getNoAtrapadas(), 10, 60);
        if((bola.getAtrapadas()>0) || (bola.getNoAtrapadas()>0)){
          g2d.drawString("Desestresando = " + bola.getAtrapadas()*100/(bola.getNoAtrapadas() + bola.getAtrapadas()) + "%", 10, 80);
        }
        g2d.setColor(Color.orange);
        paleta.pintar(g2d);
        g2d.setColor(Color.DARK_GRAY);
        bola.pintar(g2d);
    }

    private void jbInit() throws Exception {
        this.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                this_keyReleased(e);
            }

            public void keyPressed(KeyEvent e) {
                this_keyPressed(e);
            }
        });
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                this_componentResized(e);
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseMoved(MouseEvent e) {
                    this_mouseMoved(e);
                }
            });
    }

    public void lanzarJuego() {
        paleta.setAltoAncho(getHeight(), getWidth());
        bola.setAltoAncho(getHeight(), getWidth());
        ciclo.start();
    }
    public void iniciarJuegoNuevo(){
        ciclo.setLanzarPelota(true);
        bola.nuevoNuego();
    }

    private void this_keyReleased(KeyEvent e) {
        paleta.mikeyReleased(e);
    }

    private void this_keyPressed(KeyEvent e) {
        paleta.mikeyPressed(e);
    }

    private void this_componentResized(ComponentEvent e) {
        paleta.setAltoAncho(getHeight(), getWidth());
        bola.setAltoAncho(getHeight(), getWidth());
    }

    private void this_mouseMoved(MouseEvent e) {
        paleta.miMouseMoved(e.getX());
    }
}

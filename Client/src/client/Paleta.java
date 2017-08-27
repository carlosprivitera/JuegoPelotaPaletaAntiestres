package client;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paleta {
    private final int WITH = 60;
    private final int HEIGHT = 10;
    private final int VELOCIDAD = 5;
    private int x = 0;
    private int xa = 0;
    private int alto = 0;
    private int ancho = 0;

    public Paleta() {
    }

    public void setAltoAncho(int alto, int ancho) {
        this.alto = alto;
        this.ancho = ancho;
    }

    public void moverFPS() {
        if (x + xa > 0 && x + xa < ancho - WITH) {
            x = x + xa;
        } else {
            //velocidad = (int)(Math.random()*10)+5;
        }
    }

    public void pintar(Graphics2D g) {
        g.fillRect(x, alto - HEIGHT, WITH, HEIGHT);
    }

    public void mikeyReleased(KeyEvent e) {
        xa = 0;
    }

    public void mikeyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            xa = -VELOCIDAD;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            xa = VELOCIDAD;
    }

    public void miMouseMoved(int xRaton) {
        if(xRaton<ancho-WITH){
          x=xRaton;
        }  
    }

    public Rectangle miGetBounds() {
        return new Rectangle(x, alto - HEIGHT, WITH, HEIGHT);
    }
}

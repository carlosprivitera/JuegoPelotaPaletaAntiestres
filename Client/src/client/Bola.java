package client;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Bola {
    private final int DIAMETRO = 25;
    private final int VELOCIDAD = 2;
    private int x = DIAMETRO;
    private int y = DIAMETRO;
    private int xa = VELOCIDAD;
    private int ya = VELOCIDAD;
    private int angulo = 2;
    private int alto = 0;
    private int ancho = 0;
    private int atrapadas = 0;
    private int noAtrapadas = 0;

    public Bola() {
    }

    public void setAltoAncho(int alto, int ancho) {
        this.alto = alto;
        this.ancho = ancho;
    }

    public void moverFPS() {
        angulo = (int)(Math.random() * 3);
        if (x + xa < 0)
            xa = VELOCIDAD;
        if (x + xa > ancho - DIAMETRO)
            xa = -VELOCIDAD;
        if (y + ya < 0)
            ya = VELOCIDAD + angulo;
        if (y + ya > alto - DIAMETRO) {
            //game.gameOver();
            reiniciarNoAtrapada();
            noAtrapadas = noAtrapadas + 1;
        }
        if (esColision()) {
            ya = -VELOCIDAD - angulo;
            atrapadas = atrapadas + 1;
            //y = y-DIAMETER;//game.racquet.getTopY() - DIAMETER;
        }
        x = x + xa;
        y = y + ya;
    }

    private boolean esColision() {
        return esColision2();
    }

    public abstract boolean esColision2();

    public void pintar(Graphics2D g) {
        g.fillOval(x, y, DIAMETRO, DIAMETRO);
    }

    public Rectangle miGetBounds() {
        return new Rectangle(x, y, DIAMETRO, DIAMETRO);
    }

    public int getAtrapadas() {
        return atrapadas;
    }

    public int getNoAtrapadas() {
        return noAtrapadas;
    }
    private void reiniciarNoAtrapada(){
        x = (int)((Math.random() * (ancho / 2)) + DIAMETRO);
        y = DIAMETRO;
        xa = VELOCIDAD;
        ya = VELOCIDAD;
    }
    public void nuevoNuego(){
        reiniciarNoAtrapada();
        noAtrapadas=0;
        atrapadas=0;
        
    }
}



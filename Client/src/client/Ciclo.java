package client;

public abstract class Ciclo extends Thread {
    public Ciclo() {
        super();
    }
    private boolean lanzarPelota = false;

    public void setLanzarPelota(boolean lanzarPelota) {
        this.lanzarPelota = lanzarPelota;
    }

    public void run() {
        super.run();
        while (true) {
            if(lanzarPelota==true) mover();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
    }

    public abstract void mover();
}

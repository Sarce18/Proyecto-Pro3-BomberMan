package entes;

import java.awt.Color;
import java.awt.Graphics;

import sprites.Sprite;

public class Jugador {
    private double posicionX, posicionY;

    private Sprite sprite;

    public Jugador(double posicionX, double posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public void dibujar(Graphics g) {
        final int centroX = Constantes.ANCHO_PANTALLA / 2 - Constantes.LADO_SPRITE / 2;

        final int centroY = Constantes.ALTO_PANTALLA / 2 - Constantes.LADO_SPRITE / 2;

        g.setColor(Color.WHITE);
        g.fillRect(centroX, centroY, Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);
    }

    public double getPosicionX() {
        return posicionX;
    }

    public double getPosicionY() {
        return posicionY;
    }

    public void setPosicionX(double posicionX) {
        this.posicionX = posicionX;
    }

    public void setPosicionY(double posicionY) {
        this.posicionY = posicionY;
    }

}

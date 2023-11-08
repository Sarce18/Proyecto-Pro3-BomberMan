package entes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import control.GestorControles;
import sprites.Sprite;
import sprites.SpritesSheet;

public class Jugador {
    private double posicionX, posicionY;

    private char direccion;

    private SpritesSheet ss;
    private BufferedImage imagenActual;

    public Jugador(double posicionX, double posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;

        direccion = 's';

        ss = new SpritesSheet("recursos/imagenes/hojapersonajes/Bomber1.png", Constantes.LADO_SPRITE, false);

        imagenActual = ss.getSprite(0).getImagen();
    }

    public void actualizar() {
        if (GestorControles.keyboard.isArriba()) {
            direccion = 'n';
            animar();
            posicionY--;
        } else if (GestorControles.keyboard.isAbajo()) {
            direccion = 's';
            animar();
            posicionY++;
        } else if (GestorControles.keyboard.isDerecha()) {
            direccion = 'e';
            animar();
            posicionX++;
        } else if (GestorControles.keyboard.isIzquierda()) {
            direccion = 'o';
            animar();
            posicionX--;
        }
    }

    public void animar() {
        switch (direccion) {
            case 'n':
                imagenActual = ss.getSprite(0, 0).getImagen();
                break;
            case 's':
                imagenActual = ss.getSprite(0, 1).getImagen();
                break;
            case 'e':
                imagenActual = ss.getSprite(0, 3).getImagen();
                break;
            case 'o':
                imagenActual = ss.getSprite(0, 2).getImagen();
                break;

            default:
                break;
        }

    }

    public void dibujar(Graphics g) {
        final int centroX = Constantes.ANCHO_PANTALLA / 2 - Constantes.LADO_SPRITE / 2;

        final int centroY = Constantes.ALTO_PANTALLA / 2 - Constantes.LADO_SPRITE / 2;

        g.setColor(Color.WHITE);
        g.drawImage(imagenActual, centroX, centroY, null);
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

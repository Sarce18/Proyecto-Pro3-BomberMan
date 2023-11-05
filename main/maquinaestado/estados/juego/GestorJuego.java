package main.maquinaestado.estados.juego;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.maquinaestado.EstadoJuego;
import main.sprites.SpritesSheet;

/**
 * Clase que implementa el estado de juego y se encarga de gestionar el mapa y
 * los sprites del juego.
 */
public class GestorJuego implements EstadoJuego {

    private GestorMapa gm;
    SpritesSheet ss = new SpritesSheet("/recursos/imagenes/hojatexturas/001.png", 32, true);

    public void actualizar() {

    }

    /**
     * Dibuja la imagen correspondiente al sprite en la posición (100, 100) del
     * canvas.
     * 
     * @param g El objeto Graphics utilizado para dibujar.
     */
    public void dibujar(Graphics g) {
        BufferedImage imagen = ss.getSprite(2, 0).getImagen();
        g.drawImage(imagen, 100, 100, null);

    }

}
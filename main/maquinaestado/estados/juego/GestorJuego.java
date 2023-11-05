package maquinaestado.estados.juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import herramientas.CargadorRecursos;
import mapas.Mapa;
import maquinaestado.EstadoJuego;
import sprites.SpritesSheet;

/**
 * Clase que implementa el estado de juego y se encarga de gestionar el mapa y
 * los sprites del juego.
 */
public class GestorJuego implements EstadoJuego {

    private GestorMapa gm;
    // SpritesSheet ss = new SpritesSheet("recursos/imagenes/hojatexturas/1.png",
    // 32, true);

    // String texto = CargadorRecursos.leerArchivoTexto("texto/mapa.txt");

    Mapa mapa = new Mapa("texto/mapa.txt");

    public void actualizar() {

    }

    /**
     * Dibuja la imagen correspondiente al sprite en la posición (100, 100) del
     * canvas.
     * 
     * @param g El objeto Graphics utilizado para dibujar.
     */
    public void dibujar(Graphics g) {
        mapa.dibujar(g);

    }

}
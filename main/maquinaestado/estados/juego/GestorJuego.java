package maquinaestado.estados.juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import control.GestorControles;
import entes.Jugador;
import herramientas.CargadorRecursos;
import mapas.Mapa;
import maquinaestado.EstadoJuego;
import sprites.SpritesSheet;

/**
 * Clase que implementa el estado de juego y se encarga de gestionar el mapa y
 * los sprites del juego.
 */
public class GestorJuego implements EstadoJuego {

    Mapa mapa = new Mapa("texto/mapa.txt");

    Jugador jugador = new Jugador(1, 1, mapa);

    public void actualizar() {
        jugador.actualizar();

    }

    /**
     * Dibuja la imagen correspondiente al sprite en la posición (100, 100) del
     * canvas.
     * 
     * @param g El objeto Graphics utilizado para dibujar.
     */
    public void dibujar(Graphics g) {
        mapa.dibujar(g, (int) jugador.getPosicionX(), (int) jugador.getPosicionY());
        jugador.dibujar(g);
        g.setColor(Color.RED);
        g.drawString("x = " + jugador.getPosicionX(), 20, 20);
        g.drawString("y = " + jugador.getPosicionY(), 20, 30);

    }

}
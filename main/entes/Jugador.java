package entes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import control.GestorControles;
import mapas.Mapa;
import sprites.Sprite;
import sprites.SpritesSheet;

/**
 * Clase que representa al jugador del juego.
 */
public class Jugador {
    private double posicionX, posicionY;

    private int direccion;
    private int animacion;
    private int estado;

    private final int ANCHO_JUGADOR = 16;
    private final int ALTO_JUGADOR = 16;

    // Rectángulos que representan los límites del jugador
    private final Rectangle LIMITE_ARRIBA = new Rectangle(Constantes.CENTRO_VENTANA_X - ANCHO_JUGADOR / 2,
            Constantes.CENTRO_VENTANA_Y, ANCHO_JUGADOR, 1);
    private final Rectangle LIMITE_ABAJO = new Rectangle(Constantes.CENTRO_VENTANA_X - ANCHO_JUGADOR / 2,
            Constantes.CENTRO_VENTANA_Y + ALTO_JUGADOR,
            ANCHO_JUGADOR, 1);
    private final Rectangle LIMITE_IZQUIERDA = new Rectangle(Constantes.CENTRO_VENTANA_X - ANCHO_JUGADOR / 2,
            Constantes.CENTRO_VENTANA_Y,
            1, ALTO_JUGADOR);
    private final Rectangle LIMITE_DERECHA = new Rectangle(Constantes.CENTRO_VENTANA_X + ANCHO_JUGADOR / 2,
            Constantes.CENTRO_VENTANA_Y,
            1,
            ALTO_JUGADOR);

    private double velocidad = 1;

    private SpritesSheet ss;
    private BufferedImage imagenActual;

    private boolean enMovimiento;

    private Mapa mapa;

    /**
     * Constructor de la clase Jugador.
     * 
     * @param posicionX La posición inicial en el eje X del jugador.
     * @param posicionY La posición inicial en el eje Y del jugador.
     * @param mapa      El mapa en el que se encuentra el jugador.
     */
    public Jugador(double posicionX, double posicionY, Mapa mapa) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;

        direccion = 1;

        enMovimiento = false;

        ss = new SpritesSheet(Constantes.RUTA_PERSONAJE, Constantes.LADO_SPRITE, false);

        imagenActual = ss.getSprite(4).getImagen();

        animacion = 0;
        estado = 0;

        this.mapa = mapa;
    }

    /**
     * Actualiza el estado del jugador.
     */
    public void actualizar() {
        cambiarAnimacionEstado();
        enMovimiento = false;
        determinarDireccion();
        animar();

    }

    /**
     * Realiza la animación del jugador.
     */
    private void animar() {
        if (!enMovimiento) {
            estado = 0;
            animacion = 0;
        }

        imagenActual = ss.getSprite(estado, direccion).getImagen();
    }

    /**
     * Determina la dirección del jugador.
     */
    private void determinarDireccion() {
        final int velocidadX = evaluarVelocidadX();
        final int velocidadY = evaluarVelocidadY();

        if (velocidadX == 0 && velocidadY == 0) {
            return;
        }

        if ((velocidadX != 0 && velocidadY == 0) || (velocidadX == 0 && velocidadY != 0)) {
            mover(velocidadX, velocidadY);
        } else {
            if (velocidadX == -1 && velocidadY == -1) {
                if (GestorControles.keyboard.izquierda.getUltimaPulsacion() > GestorControles.keyboard.arriba
                        .getUltimaPulsacion()) {
                    mover(velocidadX, 0);
                } else {
                    mover(0, velocidadY);
                }
            }

            if (velocidadX == -1 && velocidadY == 1) {
                if (GestorControles.keyboard.izquierda.getUltimaPulsacion() > GestorControles.keyboard.abajo
                        .getUltimaPulsacion()) {
                    mover(velocidadX, 0);
                } else {
                    mover(0, velocidadY);
                }
            }

            if (velocidadX == 1 && velocidadY == -1) {
                if (GestorControles.keyboard.derecha.getUltimaPulsacion() > GestorControles.keyboard.arriba
                        .getUltimaPulsacion()) {
                    mover(velocidadX, 0);
                } else {
                    mover(0, velocidadY);
                }
            }

            if (velocidadX == 1 && velocidadY == 1) {
                if (GestorControles.keyboard.derecha.getUltimaPulsacion() > GestorControles.keyboard.abajo
                        .getUltimaPulsacion()) {
                    mover(velocidadX, 0);
                } else {
                    mover(0, velocidadY);
                }
            }
        }
    }

    /**
     * Cambia la animación y el estado del jugador.
     */
    private void cambiarAnimacionEstado() {
        if (animacion < 60) {
            animacion++;
        } else {
            animacion = 0;
        }

        if (animacion < 15) {
            estado = 0;
        } else if (animacion < 30) {
            estado = 1;
        } else if (animacion < 45) {
            estado = 2;
        } else {
            estado = 3;
        }
    }

    /**
     * Mueve al jugador en la dirección especificada.
     * 
     * @param velocidadX La velocidad en el eje X.
     * @param velocidadY La velocidad en el eje Y.
     */
    private void mover(int velocidadX, int velocidadY) {
        enMovimiento = true;

        cambiarDireccion(velocidadX, velocidadY);

        if (!fueraMapa(velocidadX, velocidadY)) {
            posicionX += velocidadX * velocidad;
            posicionY += velocidadY * velocidad;
        }

    }

    /**
     * Verifica si el jugador está fuera del mapa.
     * 
     * @param velocidadX La velocidad en el eje X.
     * @param velocidadY La velocidad en el eje Y.
     * @return true si el jugador está fuera del mapa, false en caso contrario.
     */
    private boolean fueraMapa(final int velocidadX, final int velocidadY) {

        int posicionFuturaX = (int) posicionX + velocidadX * (int) velocidad;
        int posicionFuturaY = (int) posicionY + velocidadY * (int) velocidad;

        final Rectangle bordesMapa = mapa.getBordes(posicionFuturaX, posicionFuturaY, ANCHO_JUGADOR, ALTO_JUGADOR);

        final boolean fuera;

        if (LIMITE_ARRIBA.intersects(bordesMapa) || LIMITE_ABAJO.intersects(bordesMapa)
                || LIMITE_IZQUIERDA.intersects(bordesMapa) || LIMITE_DERECHA.intersects(bordesMapa)) {
            fuera = false;
        } else {
            fuera = true;
        }
        return fuera;
    }

    /**
     * Cambia la dirección del jugador.
     * 
     * @param velocidadX La velocidad en el eje X.
     * @param velocidadY La velocidad en el eje Y.
     */
    private void cambiarDireccion(final int velocidadX, final int velocidadY) {

        if (velocidadX == 1) {
            direccion = 3;
        } else if (velocidadX == -1) {
            direccion = 2;
        }

        if (velocidadY == 1) {
            direccion = 1;
        } else if (velocidadY == -1) {
            direccion = 0;
        }

    }

    /**
     * Evalúa la velocidad en el eje X del jugador.
     * 
     * @return La velocidad en el eje X.
     */
    private int evaluarVelocidadX() {
        int velocidadX = 0;

        if (GestorControles.keyboard.izquierda.isPresionada()) {
            velocidadX = -1;
        } else if (GestorControles.keyboard.derecha.isPresionada()) {
            velocidadX = 1;
        }
        return velocidadX;
    }

    /**
     * Evalúa la velocidad en el eje Y del jugador.
     * 
     * @return La velocidad en el eje Y.
     */
    private int evaluarVelocidadY() {
        int velocidadY = 0;

        if (GestorControles.keyboard.arriba.isPresionada()) {
            velocidadY = -1;
        } else if (GestorControles.keyboard.abajo.isPresionada()) {
            velocidadY = 1;
        }
        return velocidadY;
    }

    /**
     * Dibuja al jugador en la pantalla.
     * 
     * @param g El objeto Graphics utilizado para dibujar.
     */
    public void dibujar(Graphics g) {
        final int centroX = Constantes.ANCHO_PANTALLA / 2 - Constantes.LADO_SPRITE / 2;

        final int centroY = Constantes.ALTO_PANTALLA / 2 - Constantes.LADO_SPRITE / 2;

        g.setColor(Color.GREEN);
        g.drawImage(imagenActual, centroX, centroY, null);
        g.drawRect(LIMITE_ARRIBA.x, LIMITE_ARRIBA.y, LIMITE_ARRIBA.width, LIMITE_ARRIBA.height);
        g.drawRect(LIMITE_ABAJO.x, LIMITE_ABAJO.y, LIMITE_ABAJO.width, LIMITE_ABAJO.height);
        g.drawRect(LIMITE_IZQUIERDA.x, LIMITE_IZQUIERDA.y, LIMITE_IZQUIERDA.width, LIMITE_IZQUIERDA.height);
        g.drawRect(LIMITE_DERECHA.x, LIMITE_DERECHA.y, LIMITE_DERECHA.width, LIMITE_DERECHA.height);
    }

    /**
     * Obtiene la posición actual en el eje X del jugador.
     * 
     * @return La posición actual en el eje X.
     */
    public double getPosicionX() {
        return posicionX;
    }

    /**
     * Obtiene la posición actual en el eje Y del jugador.
     * 
     * @return La posición actual en el eje Y.
     */
    public double getPosicionY() {
        return posicionY;
    }

    /**
     * Establece la posición en el eje X del jugador.
     * 
     * @param posicionX La nueva posición en el eje X.
     */
    public void setPosicionX(double posicionX) {
        this.posicionX = posicionX;
    }

    /**
     * Establece la posición en el eje Y del jugador.
     * 
     * @param posicionY La nueva posición en el eje Y.
     */
    public void setPosicionY(double posicionY) {
        this.posicionY = posicionY;
    }

}

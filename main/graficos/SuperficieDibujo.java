package graficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import control.Keyboard;
import maquinaestado.GestorEstado;

/**
 * Clase que representa la superficie de dibujo del juego.
 * Extiende la clase Canvas para poder ser dibujada en una ventana.
 */
public class SuperficieDibujo extends Canvas {

    private static final long serialVersionUID = -473990733806982846L;

    private int ancho, alto;

    private Keyboard keyboard;

    /**
     * Constructor de la clase SuperficieDibujo.
     * 
     * @param ancho Ancho de la superficie de dibujo.
     * @param alto  Alto de la superficie de dibujo.
     */
    public SuperficieDibujo(final int ancho, final int alto) {
        this.ancho = ancho;
        this.alto = alto;

        keyboard = new Keyboard();

        setIgnoreRepaint(true);
        setPreferredSize(new Dimension(ancho, alto));
        addKeyListener(keyboard);
        setFocusable(true);
        requestFocus();
    }

    /**
     * Método que dibuja la superficie de dibujo.
     * 
     * @param ge Gestor de estado del juego.
     */
    public void dibujar(final GestorEstado ge) {
        BufferStrategy buffer = getBufferStrategy();

        if (buffer == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = buffer.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, ancho, alto);

        ge.dibujar(g);

        Toolkit.getDefaultToolkit().sync();

        g.dispose();

        buffer.show();
    }

    /**
     * Método que devuelve el ancho de la superficie de dibujo.
     * 
     * @return Ancho de la superficie de dibujo.
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * Método que devuelve el alto de la superficie de dibujo.
     * 
     * @return Alto de la superficie de dibujo.
     */
    public int getAlto() {
        return alto;
    }

    /**
     * Método que devuelve el teclado asociado a la superficie de dibujo.
     * 
     * @return Teclado asociado a la superficie de dibujo.
     */
    public Keyboard getKeyboard() {
        return keyboard;
    }

    /**
     * Método que establece el ancho de la superficie de dibujo.
     * 
     * @param ancho Nuevo ancho de la superficie de dibujo.
     */
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    /**
     * Método que establece el alto de la superficie de dibujo.
     * 
     * @param alto Nuevo alto de la superficie de dibujo.
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }

    /**
     * Método que establece el teclado asociado a la superficie de dibujo.
     * 
     * @param keyboard Nuevo teclado asociado a la superficie de dibujo.
     */
    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

}

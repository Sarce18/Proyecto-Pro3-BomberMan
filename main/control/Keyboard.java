package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Clase que implementa la interfaz KeyListener para manejar eventos de teclado
public class Keyboard implements KeyListener {

    // Constante que representa el número de teclas
    private final static int NUMERO_TECLAS = 256;
    // Arreglo de booleanos que indica si una tecla está presionada o no
    private final boolean[] teclas = new boolean[NUMERO_TECLAS];

    // Variables públicas que indican si una tecla específica está presionada o no
    public boolean arriba;
    public boolean abajo;
    public boolean izquierda;
    public boolean derecha;
    public boolean correr;
    public boolean salir;

    // Método que actualiza el estado de las variables públicas según el estado de
    // las teclas
    public void actualizar() {
        arriba = teclas[KeyEvent.VK_W];
        abajo = teclas[KeyEvent.VK_S];
        izquierda = teclas[KeyEvent.VK_A];
        derecha = teclas[KeyEvent.VK_D];
        correr = teclas[KeyEvent.VK_SHIFT];
        salir = teclas[KeyEvent.VK_ESCAPE];
    }

    // Método que se ejecuta cuando se presiona una tecla
    public void keyPressed(KeyEvent e) {
        teclas[e.getKeyCode()] = true;
    }

    // Método que se ejecuta cuando se suelta una tecla
    public void keyReleased(KeyEvent e) {
        teclas[e.getKeyCode()] = false;
    }

    // Método que se ejecuta cuando se escribe una tecla (no se utiliza en este
    // caso)
    public void keyTyped(KeyEvent e) {

    }

}

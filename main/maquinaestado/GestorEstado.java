// Importamos las clases necesarias
package maquinaestado;

import maquinaestado.estados.juego.GestorJuego;
import java.awt.Graphics;

// Definimos la clase GestorEstado
public class GestorEstado {
    // Atributos de la clase
    private EstadoJuego estadoActual; // Estado actual del juego
    private EstadoJuego[] estados; // Lista de estados del juego

    // Constructor de la clase
    public GestorEstado() {
        iniciarEstados(); // Inicializamos los estados del juego
        iniciarestadoActual(); // Inicializamos el estado actual del juego
    }

    // Método para inicializar los estados del juego
    private void iniciarEstados() {
        estados = new EstadoJuego[1]; // Creamos una lista de estados con un solo elemento
        estados[0] = new GestorJuego(); // Agregamos el estado GestorJuego a la lista de estados
    }

    // Método para inicializar el estado actual del juego
    private void iniciarestadoActual() {
        estadoActual = estados[0]; // El estado actual del juego es el primer estado de la lista
    }

    // Método para actualizar el estado actual del juego
    public void actualizar() {
        estadoActual.actualizar(); // Llamamos al método actualizar del estado actual del juego
    }

    // Método para dibujar el estado actual del juego
    public void dibujar(final Graphics g) {
        estadoActual.dibujar(g); // Llamamos al método dibujar del estado actual del juego
    }

    // Getters y Setters
    public void setEstadoActual(final int nuevoEstado) {
        estadoActual = estados[nuevoEstado]; // Cambiamos el estado actual del juego
    }

    public EstadoJuego getEstadoActual() {
        return estadoActual; // Devolvemos el estado actual del juego
    }

}

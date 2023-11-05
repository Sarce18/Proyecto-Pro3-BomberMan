
import graficos.SuperficieDibujo;
import graficos.Ventana;
import maquinaestado.GestorEstado;

/**
 * Clase que representa el gestor principal del juego.
 * Es el encargado de inicializar los componentes necesarios para el juego y de
 * manejar el bucle principal del mismo.
 * 
 * @param isRunning Indica si el juego se está ejecutando o no.
 * @param titulo    El título de la ventana del juego.
 * @param ancho     El ancho de la ventana del juego.
 * @param alto      El alto de la ventana del juego.
 * @param sd        La superficie de dibujo del juego.
 * @param ventana   La ventana del juego.
 * @param ge        El gestor de estados del juego.
 */
public class GestorPrincipal {

    private boolean isRunning = false; // Indica si el juego se está ejecutando o no.
    private String titulo; // El título de la ventana del juego.
    private int ancho, alto; // El ancho y alto de la ventana del juego.

    private SuperficieDibujo sd; // La superficie de dibujo del juego.
    private Ventana ventana; // La ventana del juego.
    private GestorEstado ge; // El gestor de estados del juego.

    /**
     * Constructor de la clase GestorPrincipal.
     * 
     * @param titulo El título de la ventana del juego.
     * @param ancho  El ancho de la ventana del juego.
     * @param alto   El alto de la ventana del juego.
     */
    private GestorPrincipal(final String titulo, final int ancho, final int alto) {
        this.titulo = titulo;
        this.ancho = ancho;
        this.alto = alto;
    }

    /**
     * Método principal que inicia el juego.
     * 
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        GestorPrincipal gp = new GestorPrincipal("Juego", 800, 600);

        gp.iniciarJuego();
        gp.buclePrincipal();
    }

    /**
     * Método que inicializa el juego.
     */
    private void iniciarJuego() {
        isRunning = true;
        inicializar();
    }

    /**
     * Método que inicializa los componentes necesarios para el juego.
     */
    private void inicializar() {
        sd = new SuperficieDibujo(ancho, alto);
        ventana = new Ventana(titulo, sd);
        ge = new GestorEstado();

    }

    /**
     * Método que maneja el bucle principal del juego.
     */
    private void buclePrincipal() {

        int aps = 0; // Actualizaciones por segundo.
        int fps = 0; // Fotogramas por segundo.

        final int NS_POR_SEGUNDO = 1000000000; // Número de nanosegundos en un segundo.
        final int APS_OBJETIVO = 60; // Número de actualizaciones por segundo objetivo.
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO; // Número de nanosegundos por actualización.

        long referenciaActualizacion = System.nanoTime(); // Referencia de tiempo para la actualización.
        long referenciaContador = System.nanoTime(); // Referencia de tiempo para el contador.

        double tiempoTranscurrido;
        double delta = 0;

        while (isRunning) {
            final long inicioBucle = System.nanoTime(); // Tiempo de inicio del bucle.

            tiempoTranscurrido = inicioBucle - referenciaActualizacion;
            referenciaActualizacion = inicioBucle;

            delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;

            while (delta >= 1) {
                actualizar();
                aps++;
                delta--;
            }

            dibujar();
            fps++;

            if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {

                System.out.println("APS: " + aps + " || FPS: " + fps);

                aps = 0;
                fps = 0;

                referenciaContador = System.nanoTime();
            }
        }
    }

    /**
     * Método que actualiza los componentes del juego.
     */
    private void actualizar() {
        sd.getKeyboard().actualizar();
        ge.actualizar();
    }

    /**
     * Método que dibuja los componentes del juego.
     */
    private void dibujar() {
        sd.dibujar(ge);
    }

}
package entes;

/**
 * Clase que contiene constantes utilizadas en el juego Bomberman.
 */
public class Constantes {
    /**
     * Lado de los sprites en pixeles.
     */
    public static final int LADO_SPRITE = 32;

    /**
     * Ancho de la pantalla en pixeles.
     */
    public static int ANCHO_PANTALLA = 640;

    /**
     * Alto de la pantalla en pixeles.
     */
    public static int ALTO_PANTALLA = 360;

    /**
     * Coordenada X del centro de la ventana.
     */
    public static int CENTRO_VENTANA_X = ANCHO_PANTALLA / 2;

    /**
     * Coordenada Y del centro de la ventana.
     */
    public static int CENTRO_VENTANA_Y = ALTO_PANTALLA / 2;

    /**
     * Actualizaciones por segundo del juego.
     */
    public static int APS = 0;

    /**
     * Ruta del archivo de mapa.
     */
    public static String RUTA_MAPA = "texto/mapa.txt";

    /**
     * Ruta del icono del ratón.
     */
    public static String RUTA_ICONO_RATON = "recursos/imagenes/iconos/iconocursor.png";

    /**
     * Ruta de la imagen del personaje.
     */
    public static String RUTA_PERSONAJE = "recursos/imagenes/hojapersonajes/Bomber1.png";

    /**
     * Ruta del icono del juego.
     */
    public static String RUTA_ICONO = "recursos/imagenes/iconos/icon.png";
}

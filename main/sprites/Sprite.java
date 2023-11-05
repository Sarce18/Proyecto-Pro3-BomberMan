package sprites;

import java.awt.image.BufferedImage;

/**
 * La clase Sprite representa una imagen que puede ser mostrada en la pantalla.
 * Contiene la imagen, así como su ancho y alto.
 */
public class Sprite {
    /**
     * La imagen del sprite.
     */
    private final BufferedImage imagen;

    /**
     * El ancho del sprite.
     */
    private final int ancho;

    /**
     * La altura del sprite.
     */
    private final int alto;

    /**
     * Construye un nuevo objeto Sprite con la imagen dada.
     *
     * @param imagen la imagen del sprite.
     */
    public Sprite(final BufferedImage imagen) {
        this.imagen = imagen;

        ancho = imagen.getWidth();
        alto = imagen.getHeight();
    }

    // GETTERS

    public BufferedImage getImagen() {
        return imagen;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

}

package mapas;

import java.awt.Rectangle;

import sprites.Sprite;

/**
 * La clase Tile representa una baldosa en el mapa del juego.
 * Cada baldosa tiene un sprite, un identificador y un estado de solidez.
 */
public class Tile {
    private final Sprite sprite;
    private final int id;
    private boolean solido;

    /**
     * Crea una baldosa con el sprite y el identificador dados.
     * La baldosa se inicializa como no sólida.
     * 
     * @param sprite El sprite de la baldosa.
     * @param id     El identificador de la baldosa.
     */
    public Tile(final Sprite sprite, final int id) {
        this.id = id;
        solido = false;
        this.sprite = sprite;
    }

    /**
     * Crea una baldosa con el sprite, el identificador y el estado de solidez
     * dados.
     * 
     * @param sprite El sprite de la baldosa.
     * @param id     El identificador de la baldosa.
     * @param solido El estado de solidez de la baldosa.
     */
    public Tile(final Sprite sprite, final int id, final boolean solido) {
        this.id = id;
        this.solido = solido;
        this.sprite = sprite;
    }

    /**
     * Obtiene el identificador de la baldosa.
     * 
     * @return El identificador de la baldosa.
     */
    public int getId() {
        return id;
    }

    /**
     * Verifica si la baldosa es sólida.
     * 
     * @return true si la baldosa es sólida, false en caso contrario.
     */
    public boolean isSolido() {
        return solido;
    }

    /**
     * Obtiene el sprite de la baldosa.
     * 
     * @return El sprite de la baldosa.
     */
    public Sprite getSprite() {
        return sprite;
    }

    /**
     * Establece el estado de solidez de la baldosa.
     * 
     * @param solido El estado de solidez de la baldosa.
     */
    public void setSolido(final boolean solido) {
        this.solido = solido;
    }

    /**
     * Obtiene los límites de la baldosa en la posición dada.
     * 
     * @param x La coordenada x de la posición de la baldosa.
     * @param y La coordenada y de la posición de la baldosa.
     * @return Un objeto Rectangle que representa los límites de la baldosa.
     */
    public Rectangle getLimites(final int x, final int y) {
        return new Rectangle(x, y, sprite.getAncho(), sprite.getAlto());
    }

}

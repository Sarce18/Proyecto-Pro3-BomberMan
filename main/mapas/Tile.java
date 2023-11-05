package mapas;

import java.awt.Rectangle;

import sprites.Sprite;

public class Tile {
    private final Sprite sprite;
    private final int id;
    private boolean solido;

    public Tile(final Sprite sprite, final int id) {
        this.id = id;
        solido = false;
        this.sprite = sprite;
    }

    public Tile(final Sprite sprite, final int id, final boolean solido) {
        this.id = id;
        this.solido = solido;
        this.sprite = sprite;
    }

    public int getId() {
        return id;
    }

    public boolean isSolido() {
        return solido;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSolido(final boolean solido) {
        this.solido = solido;
    }

    public Rectangle getLimites(final int x, final int y) {
        return new Rectangle(x, y, sprite.getAncho(), sprite.getAlto());
    }

}

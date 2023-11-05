package sprites;

import java.awt.image.BufferedImage;

import herramientas.CargadorRecursos;

// Clase que representa una hoja de sprites
public class SpritesSheet {

    // Variables de instancia
    final private int anchoHojaPX, altoHojaPX, anchoHojaSprites, altoHojaSprites, anchoSprites, altoSprites;
    final private Sprite[] sprites;

    // Constructor que recibe la ruta de la imagen, el tamaño de los sprites y si la
    // hoja es opaca o no
    public SpritesSheet(final String ruta, final int spritesSize, final boolean hojaOpaca) {
        BufferedImage imagen;

        // Carga la imagen de forma opaca o translúcida según el valor de hojaOpaca
        if (hojaOpaca) {
            imagen = CargadorRecursos.cargarImagenCompatibleOpaca(ruta);
        } else {
            imagen = CargadorRecursos.cargarImagenCompatibleTranslucida(ruta);
        }

        // Asigna los valores de ancho y alto de la hoja en píxeles
        anchoHojaPX = imagen.getWidth();
        altoHojaPX = imagen.getHeight();

        // Calcula los valores de ancho y alto de la hoja en sprites
        anchoHojaSprites = anchoHojaPX / spritesSize;
        altoHojaSprites = altoHojaPX / spritesSize;

        // Asigna los valores de ancho y alto de los sprites
        anchoSprites = spritesSize;
        altoSprites = spritesSize;

        // Crea un arreglo de sprites con el tamaño de la hoja en sprites
        sprites = new Sprite[anchoHojaSprites * altoHojaSprites];

        // Rellena el arreglo de sprites con los sprites de la imagen
        rellenarSprites(imagen);
    }

    // Constructor que recibe la ruta de la imagen, el ancho y alto de los sprites y
    // si la hoja es opaca o no
    public SpritesSheet(final String ruta, final int anchoSprites, final int altoSprites, final boolean hojaOpaca) {
        BufferedImage imagen;

        // Carga la imagen de forma opaca o translúcida según el valor de hojaOpaca
        if (hojaOpaca) {
            imagen = CargadorRecursos.cargarImagenCompatibleOpaca(ruta);
        } else {
            imagen = CargadorRecursos.cargarImagenCompatibleTranslucida(ruta);
        }

        // Asigna los valores de ancho y alto de la hoja en píxeles
        anchoHojaPX = imagen.getWidth();
        altoHojaPX = imagen.getHeight();

        // Calcula los valores de ancho y alto de la hoja en sprites
        anchoHojaSprites = anchoHojaPX / anchoSprites;
        altoHojaSprites = altoHojaPX / altoSprites;

        // Asigna los valores de ancho y alto de los sprites
        this.anchoSprites = anchoSprites;
        this.altoSprites = altoSprites;

        // Crea un arreglo de sprites con el tamaño de la hoja en sprites
        sprites = new Sprite[anchoHojaSprites * altoHojaSprites];

        // Rellena el arreglo de sprites con los sprites de la imagen
        rellenarSprites(imagen);
    }

    // Método que rellena el arreglo de sprites con los sprites de la imagen
    public void rellenarSprites(final BufferedImage imagen) {
        for (int y = 0; y < altoHojaSprites; y++) {
            for (int x = 0; x < anchoHojaSprites; x++) {
                final int posicionX = x * anchoSprites;
                final int posicionY = y * altoSprites;

                sprites[x + y * anchoHojaSprites] = new Sprite(imagen.getSubimage(posicionX, posicionY, anchoSprites,
                        altoSprites));
            }
        }
    }

    // Método que devuelve el sprite en la posición indicada
    public Sprite getSprite(final int indice) {
        return sprites[indice];
    }

    // Método que devuelve el sprite en la posición indicada por x e y
    public Sprite getSprite(final int x, final int y) {
        return sprites[x + y * anchoHojaSprites];
    }

}

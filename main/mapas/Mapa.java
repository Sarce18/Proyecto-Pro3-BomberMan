package mapas;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;

import entes.Constantes;
import herramientas.CargadorRecursos;
import sprites.Sprite;
import sprites.SpritesSheet;

public class Mapa {

    // Atributos de la clase
    private String[] partes; // Arreglo de strings que almacena las partes del archivo de texto
    private final int ancho, alto; // Ancho y alto del mapa
    private final Sprite[] paleta; // Paleta de sprites utilizados en el mapa
    private final boolean[] colisiones; // Arreglo de booleanos que indica si hay colisiones en una posición del mapa
    private final int[] sprites; // Arreglo de enteros que indica qué sprite se debe utilizar en cada posición
                                 // del mapa
    private final int MARGEN_X = Constantes.ANCHO_PANTALLA / 2 - Constantes.LADO_SPRITE / 2;
    private final int MARGEN_Y = Constantes.ALTO_PANTALLA / 2 - Constantes.LADO_SPRITE / 2;

    // Constructor de la clase
    public Mapa(final String ruta) {

        // Se lee el contenido del archivo de texto
        String contenido = CargadorRecursos.leerArchivoTexto(ruta);

        // Se separa el contenido en sus partes
        partes = contenido.split("\\*");

        // Se asignan los valores de ancho y alto
        ancho = Integer.parseInt(partes[0]);
        alto = Integer.parseInt(partes[1]);

        // Se obtienen las hojas de sprites utilizadas en el mapa
        String hojasUtilizadas = partes[2];
        String[] hojasSeparadas = hojasUtilizadas.split(",");

        // Se obtiene la paleta de sprites utilizados en el mapa
        String paletaEntera = partes[3];
        String[] partesPaleta = paletaEntera.split("#");
        paleta = asignarSprite(partesPaleta, hojasSeparadas);

        // Se obtiene la información de las colisiones en el mapa
        String colisionesEnteras = partes[4];
        colisiones = extraerColisiones(colisionesEnteras);

        // Se obtiene la información de los sprites en el mapa
        String spritesEnteros = partes[5];
        String[] cadenasSprites = spritesEnteros.split(" ");
        sprites = extraerSprites(cadenasSprites);

    }

    // Método privado que asigna los sprites a la paleta
    private Sprite[] asignarSprite(final String[] partesPaleta, final String[] hojasSeparadas) {

        // Se crea un arreglo de sprites vacío
        Sprite[] paleta = new Sprite[partesPaleta.length];

        // Se carga la hoja de sprites utilizada en el mapa
        SpritesSheet hoja = new SpritesSheet("recursos/imagenes/hojatexturas/" + hojasSeparadas[0] + ".png", 32, false);

        // Se asignan los sprites a la paleta
        for (int i = 0; i < partesPaleta.length; i++) {
            String spriteTemporal = partesPaleta[i];
            String[] partesSprite = spriteTemporal.split("-");

            int indicePaleta = Integer.parseInt(partesSprite[0]);
            int indiceSpriteHoja = Integer.parseInt(partesSprite[2]);

            paleta[indicePaleta] = hoja.getSprite(indiceSpriteHoja);
        }

        // Se retorna la paleta de sprites
        return paleta;
    }

    // Método privado que extrae la información de las colisiones en el mapa
    private boolean[] extraerColisiones(final String cadenaColisiones) {

        // Se crea un arreglo de booleanos vacío
        boolean[] colisiones = new boolean[cadenaColisiones.length()];

        // Se asignan los valores de colisión al arreglo
        for (int i = 0; i < colisiones.length; i++) {
            if (cadenaColisiones.charAt(i) == '0') {
                colisiones[i] = false;
            } else {
                colisiones[i] = true;
            }
        }

        // Se retorna el arreglo de colisiones
        return colisiones;
    }

    // Método privado que extrae la información de los sprites en el mapa
    private int[] extraerSprites(final String[] cadenaSprites) {

        // Se crea un ArrayList de enteros vacío
        ArrayList<Integer> sprites = new ArrayList<Integer>();

        // Se asignan los valores de sprite al ArrayList
        for (int i = 0; i < cadenaSprites.length; i++) {
            if (cadenaSprites[i].length() == 2) {
                sprites.add(Integer.parseInt(cadenaSprites[i]));
            } else {
                String uno = "";
                String dos = "";

                String error = cadenaSprites[i];

                uno += error.charAt(0);
                uno += error.charAt(1);

                dos += error.charAt(2);
                dos += error.charAt(3);

                sprites.add(Integer.parseInt(uno));
                sprites.add(Integer.parseInt(dos));
            }
        }

        // Se crea un arreglo de enteros y se asignan los valores del ArrayList
        int[] vectorSprites = new int[sprites.size()];

        for (int i = 0; i < sprites.size(); i++) {
            vectorSprites[i] = sprites.get(i);
        }

        // Se retorna el arreglo de sprites
        return vectorSprites;
    }

    // Método que dibuja el mapa en pantalla
    public void dibujar(Graphics g, final int posicionX, final int posicionY) {

        // Se dibuja cada sprite en su posición correspondiente
        for (int y = 0; y < this.alto; y++) {
            for (int x = 0; x < this.ancho; x++) {
                BufferedImage imagen = paleta[sprites[x + y * this.ancho]].getImagen();

                int puntoX = x * Constantes.LADO_SPRITE - posicionX + MARGEN_X;
                int puntoY = y * Constantes.LADO_SPRITE - posicionY + MARGEN_Y;

                g.drawImage(imagen, puntoX, puntoY, null);
            }
        }
    }

    public Rectangle getBordes(final int posicionX, final int posicionY, final int anchoJugador,
            final int altoJugador) {

        int x = MARGEN_X - posicionX + anchoJugador;
        int y = MARGEN_Y - posicionY + altoJugador;
        int ancho = this.ancho * Constantes.LADO_SPRITE - anchoJugador * 2;
        int alto = this.alto * Constantes.LADO_SPRITE - altoJugador * 2;

        return new Rectangle(x, y, ancho, alto);
    }

}

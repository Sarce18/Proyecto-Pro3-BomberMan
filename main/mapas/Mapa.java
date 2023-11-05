package mapas;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;

import herramientas.CargadorRecursos;
import sprites.Sprite;
import sprites.SpritesSheet;

public class Mapa {

    private String[] partes;
    private final int ancho, alto;
    private final Sprite[] paleta;
    private final boolean[] colisiones;
    private final int[] sprites;

    public Mapa(final String ruta) {
        String contenido = CargadorRecursos.leerArchivoTexto(ruta);

        partes = contenido.split("\\*");

        ancho = Integer.parseInt(partes[0]);
        alto = Integer.parseInt(partes[1]);

        String hojasUtilizdas = partes[2];
        String[] hojasSeparadas = hojasUtilizdas.split(",");

        String paletaEntera = partes[3];
        String[] partesPaleta = paletaEntera.split("#");

        paleta = asignarSprite(partesPaleta, hojasSeparadas);

        String colisionesEnteras = partes[4];
        colisiones = extraerColisiones(colisionesEnteras);

        String spritesEnteros = partes[5];
        String[] cadenasSprites = spritesEnteros.split(" ");

        sprites = extraerSprites(cadenasSprites);

    }

    private Sprite[] asignarSprite(final String[] partesPaleta, final String[] hojasSeparadas) {

        Sprite[] paleta = new Sprite[partesPaleta.length];
        SpritesSheet hoja = new SpritesSheet("recursos/imagenes/hojatexturas/" + hojasSeparadas[0] + ".png", 32, false);

        for (int i = 0; i < partesPaleta.length; i++) {
            String spriteTemporal = partesPaleta[i];
            String[] partesSprite = spriteTemporal.split("-");

            int indicePaleta = Integer.parseInt(partesSprite[0]);
            int indiceSpriteHoja = Integer.parseInt(partesSprite[2]);

            paleta[indicePaleta] = hoja.getSprite(indiceSpriteHoja);
        }
        return paleta;
    }

    private boolean[] extraerColisiones(final String cadenaColisiones) {
        boolean[] colisiones = new boolean[cadenaColisiones.length()];

        for (int i = 0; i < colisiones.length; i++) {
            if (cadenaColisiones.charAt(i) == '0') {
                colisiones[i] = false;
            } else {
                colisiones[i] = true;
            }
        }

        return colisiones;
    }

    private int[] extraerSprites(final String[] cadenaSprites) {
        ArrayList<Integer> sprites = new ArrayList<Integer>();

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

        int[] vectorSprites = new int[sprites.size()];

        for (int i = 0; i < sprites.size(); i++) {
            vectorSprites[i] = sprites.get(i);
        }
        return vectorSprites;
    }

    public void dibujar(Graphics g) {
        int anchoSprite = this.paleta[0].getAncho();
        int altoSprite = this.paleta[0].getAlto();
        for (int y = 0; y < this.alto; y++) {
            for (int x = 0; x < this.ancho; x++) {
                BufferedImage imagen = paleta[sprites[x + y * this.ancho]].getImagen();
                g.drawImage(imagen, x * anchoSprite, y * altoSprite, null);
            }
        }
    }

}

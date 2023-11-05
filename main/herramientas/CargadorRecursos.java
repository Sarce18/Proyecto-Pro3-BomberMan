package main.herramientas;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Clase encargada de cargar recursos como imágenes.
 * Contiene dos métodos para cargar imágenes compatibles opacas y translúcidas.
 */
public class CargadorRecursos {

    /**
     * Carga una imagen opaca desde una ruta.
     * 
     * @param ruta la ruta de la imagen a cargar.
     * @return la imagen cargada como un objeto BufferedImage.
     */
    public static BufferedImage cargarImagenCompatibleOpaca(final String ruta) {
        Image imagen = null;

        try {
            imagen = ImageIO.read(CargadorRecursos.class.getResource(ruta));
        } catch (IOException e) {
            e.printStackTrace();
        }

        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
                .getDefaultConfiguration();

        BufferedImage imagenAcelerada = gc.createCompatibleImage(imagen.getWidth(null), imagen.getHeight(null),
                Transparency.OPAQUE);

        Graphics g = imagenAcelerada.getGraphics();
        g.drawImage(imagen, 0, 0, null);
        g.dispose();

        return imagenAcelerada;
    }

    /**
     * Carga una imagen translúcida desde una ruta.
     * 
     * @param ruta la ruta de la imagen a cargar.
     * @return la imagen cargada como un objeto BufferedImage.
     */
    public static BufferedImage cargarImagenCompatibleTranslucida(final String ruta) {
        Image imagen = null;

        try {
            imagen = ImageIO.read(CargadorRecursos.class.getResource(ruta));
        } catch (IOException e) {
            e.printStackTrace();
        }

        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
                .getDefaultConfiguration();

        BufferedImage imagenAcelerada = gc.createCompatibleImage(imagen.getWidth(null), imagen.getHeight(null),
                Transparency.TRANSLUCENT);

        Graphics g = imagenAcelerada.getGraphics();
        g.drawImage(imagen, 0, 0, null);
        g.dispose();

        return imagenAcelerada;
    }

}

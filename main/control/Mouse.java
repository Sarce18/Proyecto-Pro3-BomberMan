package control;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import herramientas.CargadorRecursos;

public class Mouse {
    private final Cursor cursor;

    public Mouse() {
        Toolkit configuracion = Toolkit.getDefaultToolkit();

        BufferedImage icono = CargadorRecursos
                .cargarImagenCompatibleTranslucida("recursos/imagenes/iconos/iconocursor.png");

        Point punta = new Point(0, 0);

        this.cursor = configuracion.createCustomCursor(icono, punta, "Cursor por defecto");
    }

    public Cursor getCursor() {
        return cursor;
    }

}

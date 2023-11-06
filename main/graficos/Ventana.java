package graficos;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import herramientas.CargadorRecursos;

// Se define la clase Ventana que extiende de JFrame
public class Ventana extends JFrame {

    private static final long serialVersionUID = 1L;

    // Se define el atributo titulo
    private String titulo;
    private final ImageIcon icono;

    // Constructor de la clase Ventana que recibe como parámetros el título y una
    // SuperficieDibujo
    public Ventana(final String titulo, final SuperficieDibujo sd) {
        this.titulo = titulo;

        BufferedImage imagen = CargadorRecursos.cargarImagenCompatibleTranslucida("recursos/imagenes/iconos/icon.png");

        this.icono = new ImageIcon(imagen);

        // Se llama al método configurarVentana
        configurarVentana(sd);
    }

    // Método que configura la ventana
    private void configurarVentana(final SuperficieDibujo sd) {

        // Se establece el título de la ventana

        setTitle(titulo);
        setIconImage(icono.getImage());

        // Se establece la operación que se realiza al cerrar la ventana

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Se establece que la ventana no es redimensionable

        setResizable(false);

        // Se establece el layout de la ventana

        setLayout(new BorderLayout());

        // Se agrega la SuperficieDibujo al centro de la ventana

        add(sd, BorderLayout.CENTER);

        // Se ajusta el tamaño de la ventana al contenido

        pack();

        // Se establece la ubicación de la ventana en el centro de la pantalla

        setLocationRelativeTo(null);

        // Se hace visible la ventana

        setVisible(true);
    }

}

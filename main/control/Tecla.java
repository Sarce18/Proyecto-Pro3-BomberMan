package control;

public class Tecla {

    private boolean presionada = false;
    private long ultimaPulsacion = System.nanoTime();

    public void teclaPulsada() {
        presionada = true;
        ultimaPulsacion = System.nanoTime();
    }

    public void teclaLiberada() {
        presionada = false;
    }

    public boolean isPresionada() {
        return presionada;
    }

    public long getUltimaPulsacion() {
        return ultimaPulsacion;
    }

}

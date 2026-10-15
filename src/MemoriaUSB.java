public class MemoriaUSB extends DispositivoAlmacenamiento {

    private boolean protegidaContraEscritura;

    public MemoriaUSB(String nombre, int capacidadMaxima, boolean protegidaContraEscritura) {
        super(nombre, capacidadMaxima);
        this.protegidaContraEscritura = protegidaContraEscritura;
    }

    @Override
    public boolean escribirDatos(String datos) {

        if (protegidaContraEscritura) {
            System.out.println("[USB " + nombre + "] Error: la memoria está protegida contra escritura.");
            return false;
        }

        if (!hayEspacioPara(datos)) {
            System.out.println("[USB " + nombre + "] Error: espacio insuficiente (libre: "
                    + getEspacioLibre() + ", requerido: " + datos.length() + ").");
            return false;
        }

        contenido = contenido + datos;
        System.out.println("[USB " + nombre + "] Datos copiados por puerto USB: \"" + datos + "\"");
        return true;
    }

    @Override
    public String leerDatos() {
        System.out.println("[USB " + nombre + "] Leyendo desde el puerto USB...");
        return contenido;
    }
}
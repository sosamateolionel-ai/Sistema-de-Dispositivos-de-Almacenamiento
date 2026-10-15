public class UnidadSSD extends DispositivoAlmacenamiento {

    private int velocidadMBs; // velocidad de transferencia

    public UnidadSSD(String nombre, int capacidadMaxima, int velocidadMBs) {
        super(nombre, capacidadMaxima);
        this.velocidadMBs = velocidadMBs;
    }

    @Override
    public boolean escribirDatos(String datos) {

        if (!hayEspacioPara(datos)) {
            System.out.println("[SSD " + nombre + "] Error: espacio insuficiente (libre: "
                    + getEspacioLibre() + ", requerido: " + datos.length() + ").");
            return false;
        }

        contenido = contenido + datos;
        System.out.println("[SSD " + nombre + "] Escritura en memoria flash a " + velocidadMBs + " MB/s: \"" + datos + "\"");
        return true;
    }

    @Override
    public String leerDatos() {
        System.out.println("[SSD " + nombre + "] Lectura instantánea sin partes móviles.");
        return contenido;
    }
}
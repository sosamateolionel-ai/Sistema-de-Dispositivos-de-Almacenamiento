public class DiscoDuro extends DispositivoAlmacenamiento {

    private int rpm;

    public DiscoDuro(String nombre, int capacidadMaxima, int rpm) {
        super(nombre, capacidadMaxima);
        this.rpm = rpm;
    }

    @Override
    public boolean escribirDatos(String datos) {

        if (!hayEspacioPara(datos)) {
            System.out.println("[HDD " + nombre + "] Error: espacio insuficiente (libre: "
                    + getEspacioLibre() + ", requerido: " + datos.length() + ").");
            return false;
        }

        contenido = contenido + datos;
        System.out.println("[HDD " + nombre + "] Escritura mecánica a " + rpm + " RPM: \"" + datos + "\"");
        return true;
    }

    @Override
    public String leerDatos() {
        System.out.println("[HDD " + nombre + "] Girando el plato y posicionando el cabezal...");
        return contenido;
    }
}
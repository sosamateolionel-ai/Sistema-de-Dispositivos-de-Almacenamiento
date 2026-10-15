public abstract class DispositivoAlmacenamiento {

    protected String nombre;
    protected int capacidadMaxima;   // en caracteres, para simplificar
    protected String contenido;

    public DispositivoAlmacenamiento(String nombre, int capacidadMaxima) {
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.contenido = "";
    }

    public String getNombre() {
        return nombre;
    }

    public int getEspacioLibre() {
        return capacidadMaxima - contenido.length();
    }

    //validar que los datos entren antes de guardarlos

    protected boolean hayEspacioPara(String datos) {
        return datos.length() <= getEspacioLibre();
    }

    // Métodos abstractos: cada dispositivo define su propio comportamiento

    public abstract boolean escribirDatos(String datos);

    public abstract String leerDatos();
}
import java.util.ArrayList;
import java.util.List;

void main() {

    List<DispositivoAlmacenamiento> dispositivos = new ArrayList<>();

    dispositivos.add(new DiscoDuro("Seagate", 50, 7200));
    dispositivos.add(new UnidadSSD("Samsung", 30, 550));
    dispositivos.add(new MemoriaUSB("Kingston", 20, false));
    dispositivos.add(new MemoriaUSB("USB Bloqueado", 20, true));

    String datos = "Informe anual 2026";

    System.out.println("=== Escritura polimórfica ===");
    for (DispositivoAlmacenamiento d : dispositivos) {
        d.escribirDatos(datos);
    }

    System.out.println("\n=== Segunda escritura (prueba de desbordamiento) ===");
    for (DispositivoAlmacenamiento d : dispositivos) {
        d.escribirDatos(datos);
    }

    System.out.println("\n=== Lectura polimórfica ===");
    for (DispositivoAlmacenamiento d : dispositivos) {
        String leido = d.leerDatos();
        System.out.println("   Contenido: \"" + leido + "\" | Espacio libre: " + d.getEspacioLibre());
    }

}

# Sistema de Dispositivos de Almacenamiento

## Descripción

Este proyecto consiste en un sistema que simula el funcionamiento de diferentes dispositivos de almacenamiento: disco duro (HDD), unidad de estado sólido (SSD) y memoria USB.

Permite escribir y leer datos, controlar el espacio disponible y validar si un dispositivo puede almacenar información. Cada tipo de dispositivo implementa su propio comportamiento mediante herencia y polimorfismo.

## Funcionamiento

1. Se crea una lista de dispositivos de almacenamiento.
2. Se agregan un disco duro Seagate, una unidad SSD Samsung, una memoria USB Kingston y una memoria USB protegida contra escritura.
3. Se intenta escribir el texto `"Informe anual 2026"` en todos los dispositivos.
4. Se realiza una segunda escritura para comprobar cómo se comporta cada dispositivo y si dispone de espacio suficiente.
5. Se leen los datos almacenados en cada dispositivo.
6. Se muestra el contenido leído y el espacio libre restante.

La memoria USB protegida rechaza las operaciones de escritura, mientras que los demás dispositivos almacenan los datos si cuentan con espacio suficiente.

## Clase abstracta `DispositivoAlmacenamiento`

Es la clase base que define los atributos y comportamientos comunes de todos los dispositivos de almacenamiento.

### Atributos

* `nombre`: nombre del dispositivo.
* `capacidadMaxima`: capacidad máxima expresada en caracteres.
* `contenido`: información almacenada en el dispositivo.

### Métodos principales

* `getNombre()`: devuelve el nombre del dispositivo.
* `getEspacioLibre()`: calcula la capacidad disponible restando la longitud del contenido actual a la capacidad máxima.
* `hayEspacioPara(String datos)`: comprueba si los datos que se desean escribir caben en el espacio disponible.
* `escribirDatos(String datos)`: método abstracto que cada subclase implementa para almacenar información.
* `leerDatos()`: método abstracto que cada subclase implementa para leer el contenido.

La clase es abstracta porque establece una estructura común, pero no representa un dispositivo concreto que pueda instanciarse directamente.

## Clase `DiscoDuro`

Representa un disco duro mecánico (HDD).

### Atributos

* `rpm`: revoluciones por minuto del disco.

### Métodos principales

* `escribirDatos(String datos)`: valida el espacio disponible y agrega los datos al contenido.
* `leerDatos()`: muestra un mensaje que simula el movimiento del plato y el posicionamiento del cabezal, y devuelve el contenido almacenado.

Utiliza `super()` para inicializar los atributos heredados de `DispositivoAlmacenamiento`.

## Clase `UnidadSSD`

Representa una unidad de estado sólido que utiliza memoria flash.

### Atributos

* `velocidadMBs`: velocidad de transferencia expresada en MB/s.

### Métodos principales

* `escribirDatos(String datos)`: verifica que exista espacio suficiente y almacena la información.
* `leerDatos()`: muestra un mensaje que representa la lectura sin partes móviles y devuelve el contenido.

## Clase `MemoriaUSB`

Representa una memoria USB que permite almacenar información, siempre que no esté protegida contra escritura.

### Atributos

* `protegidaContraEscritura`: indica si el dispositivo tiene habilitada la protección contra escritura.

### Métodos principales

* `escribirDatos(String datos)`: primero comprueba si la memoria está protegida. Si no lo está, verifica el espacio disponible y almacena los datos.
* `leerDatos()`: muestra un mensaje que simula la lectura desde el puerto USB y devuelve el contenido almacenado.

Esta clase incorpora una validación adicional que no tienen las otras subclases: puede rechazar la escritura incluso cuando dispone de espacio libre.

## Conceptos de programación utilizados

* **Programación orientada a objetos (POO):** representación de los dispositivos mediante clases y objetos.
* **Abstracción:** la clase `DispositivoAlmacenamiento` define una estructura común.
* **Herencia:** `DiscoDuro`, `UnidadSSD` y `MemoriaUSB` heredan de la clase base.
* **Polimorfismo:** una lista de tipo `DispositivoAlmacenamiento` permite trabajar con diferentes subclases mediante los mismos métodos.
* **Métodos abstractos:** cada subclase implementa su propia versión de `escribirDatos()` y `leerDatos()`.
* **Sobrescritura (`@Override`):** las subclases redefinen los métodos abstractos.
* **Encapsulamiento y modificador `protected`:** los atributos protegidos pueden utilizarse directamente desde las subclases.
* **Uso de `super()`:** permite invocar el constructor de la clase padre.
* **Colecciones:** uso de `ArrayList` y `List` para administrar varios dispositivos.
* **Validación de capacidad:** evita almacenar datos que superen el espacio disponible.
* **Condicionales:** permiten comprobar la disponibilidad de espacio y la protección contra escritura.

## Tecnologías utilizadas

* Lenguaje: Java.
* Entorno de desarrollo recomendado: IntelliJ IDEA.

## Ejecución

<img width="763" height="587" alt="image" src="https://github.com/user-attachments/assets/129cde6d-c2a4-4e4c-85a5-7e18b9301f35" />

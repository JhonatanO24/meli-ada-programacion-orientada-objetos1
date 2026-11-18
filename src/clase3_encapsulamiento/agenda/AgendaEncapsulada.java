package clase3_encapsulamiento.agenda;

public class AgendaEncapsulada {
    // Atributos privados y protegidos
    private Contacto[] contactos;
    private int cantidad;
    private final int capacidadInicial;

    // Constructor con capacidad inicial
    public AgendaEncapsulada(int capacidadInicial) {
        this.capacidadInicial = capacidadInicial;
        this.contactos = new Contacto[capacidadInicial];
        this.cantidad = 0;
    }

    public boolean agregar(Contacto c) {
        // Regla 1: No nulo y que sea válido
        if (c == null || !c.esValido()) {
            return false;
        }

        // Regla 2: Email NO duplicado (recorremos los existentes)
        for (int i = 0; i < this.cantidad; i++) {
            if (this.contactos[i].getEmail().equalsIgnoreCase(c.getEmail())) {
                return false; // ¡Ya existe un contacto con este correo!
            }
        }

        // Regla 3: Si está lleno, redimensionar automáticamente antes de insertar
        if (this.cantidad >= this.contactos.length) {
            redimensionar();
        }

        this.contactos[this.cantidad] = c;
        this.cantidad++;
        return true;
    }

    // ELIMINAR por email, corre los elementos y retorna boolean
    public boolean eliminar(String email) {
        int indiceEncontrado = -1;

        for (int i = 0; i < this.cantidad; i++) {
            if (this.contactos[i].getEmail().equalsIgnoreCase(email)) {
                indiceEncontrado = i;
                break;
            }
        }

        if (indiceEncontrado == -1) {
            return false; // No existe
        }

        // Correr los elementos una posición a la izquierda
        for (int i = indiceEncontrado; i < this.cantidad - 1; i++) {
            this.contactos[i] = this.contactos[i + 1];
        }

        this.contactos[this.cantidad - 1] = null;
        this.cantidad--;
        return true;
    }

    // BUSCAR por email (Devuelve el Contacto o null)[cite: 8]
    public Contacto buscar(String email) {
        for (int i = 0; i < this.cantidad; i++) {
            if (this.contactos[i].getEmail().equalsIgnoreCase(email)) {
                return this.contactos[i];
            }
        }
        return null;
    }

    // LISTAR: Retorna una COPIA exacta del array interno inmutabilidad
    public Contacto[] listar() {
        Contacto[] copia = new Contacto[this.cantidad];
        for (int i = 0; i < this.cantidad; i++) {
            copia[i] = this.contactos[i];
        }
        return copia;
    }

    // FILTRAR POR NOMBRE: Retorna array nuevo del tamaño EXACTO con los que empiezan por prefijo
    public Contacto[] filtrarPorNombre(String prefijo) {
        if (prefijo == null) return new Contacto[0];

        // Primero contamos cuántos coinciden para saber el tamaño exacto del nuevo array
        int contadorCoincidencias = 0;
        for (int i = 0; i < this.cantidad; i++) {
            if (this.contactos[i].getNombre().toLowerCase().startsWith(prefijo.toLowerCase())) {
                contadorCoincidencias++;
            }
        }

        // Creamos el array con el tamaño exacto
        Contacto[] resultado = new Contacto[contadorCoincidencias];
        int index = 0;
        for (int i = 0; i < this.cantidad; i++) {
            if (this.contactos[i].getNombre().toLowerCase().startsWith(prefijo.toLowerCase())) {
                resultado[index] = this.contactos[i];
                index++;
            }
        }
        return resultado;
    }

    // PRIVADO: Redimensionar que dobla el tamaño del array cuando se llena
    private void redimensionar() {
        int nuevaCapacidad = this.contactos.length * 2;
        Contacto[] nuevoArray = new Contacto[nuevaCapacidad];

        // Copiamos los elementos viejos al nuevo array más grande
        for (int i = 0; i < this.contactos.length; i++) {
            nuevoArray[i] = this.contactos[i];
        }

        this.contactos = nuevoArray; // Reemplazamos el array viejo por el duplicado
    }

    public int getCantidad() {
        return cantidad;
    }
}

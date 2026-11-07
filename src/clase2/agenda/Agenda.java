package clase2.agenda;

public class Agenda {
    private Contacto[] contactos;
    private int capacidad;
    private int cantidad;

    // Este constructor recibe la cantidad
    public Agenda(int capacidad) {
        this.capacidad = capacidad;
        this.contactos = new Contacto[capacidad];
        this.cantidad = 0;
    }

    // Aqui se agrega el contacto con validación (se retoma con booleano)
    public boolean agregar(Contacto c) {

        // Se valida si la agenda está llena o si el email no es válido
        if (estaLlena() || c.getEmail() == null || !c.getEmail().contains("@")) {
            return false;
        }
        this.contactos[this.cantidad] = c;
        this.cantidad++;
        return true;
    }

    // En esta parte s establece la eliminacion del contacto por nombre, en si corre los siguientes y devuelve boolean
    public boolean eliminar(String nombre) {
        int indiceEncontrado = -1;

        // Se busca el indice del contacto (una alternativa igual a indexof
        for (int i = 0; i < this.cantidad; i++) {
            if (this.contactos[i].getNombre().equalsIgnoreCase(nombre)) {
                indiceEncontrado = i;
                break;
            }
        }

        if (indiceEncontrado == -1) {
            return false; // No se encontro
        }


        // Aca se corren los elementos hacia la izquierda para rellenar el espacio vacio
        for (int i = indiceEncontrado; i < this.cantidad - 1; i++) {
            this.contactos[i] = this.contactos[i + 1];
        }

        // Limpia la ultima posicion que quedó duplicada
        this.contactos[this.cantidad - 1] = null;
        this.cantidad--;
        return true;
    }

    // Busca por el nombre (devuelve Contacto o null
    public Contacto buscar(String nombre) {
        for (int i = 0; i < this.cantidad; i++) {
            if (this.contactos[i].getNombre().equalsIgnoreCase(nombre)) {
                return this.contactos[i];
            }
        }
        return null;
    }

    public void listar() {
        if (estaVacia()) {
            System.out.println("📭 La agenda está vacía actualmente.\n");
            return;
        }
        for (int i = 0; i < this.cantidad; i++) {
            this.contactos[i].mostrarInfo();
        }
    }

    // solo favoritos == true
    public void listarFavoritos() {
        if (estaVacia()) {
            System.out.println("📭 La agenda está vacía.\n");
            return;
        }
        boolean hayFavoritos = false;
        for (int i = 0; i < this.cantidad; i++) {
            if (this.contactos[i].isEsFavorito()) {
                this.contactos[i].mostrarInfo();
                hayFavoritos = true;
            }
        }
        if (!hayFavoritos) {
            System.out.println("⭐ No tienes contactos marcados como favoritos.\n");
        }
    }

    // Al contar los favoritos se devuelve int recorreindo el array
    public int contarFavoritos() {
        int contador = 0;
        for (int i = 0; i < this.cantidad; i++) {
            if (this.contactos[i].isEsFavorito()) {
                contador++;
            }
        }
        return contador;
    }

    // Y estos son los helpers de utilidades
    public boolean estaVacia() {
        return this.cantidad == 0;
    }

    public boolean estaLlena() {
        return this.cantidad >= this.capacidad;
    }
}

package preeexamen_poo_jhonatan.ejercicio1_estacionamiento;

public class Estacionamiento {
    // Atributos privados: la capacidad seria fija (osea final) y ocupados se protegera de alteraciones externas
    private final int capacidad;
    private int ocupados;

    // Constructor:  este valida que la capacidad inicial no sea negativa y arranca con 0 autos ocupados
    public Estacionamiento(int capacidad) {
        if (capacidad < 0) {
            throw new IllegalArgumentException("La capacidad no puede ser negativa.");
        }
        this.capacidad = capacidad;
        this.ocupados = 0;
    }

    // Registra un auto solo si hay cupo disponible; si este esta lleno, no altera el estado y retorna false
    public boolean entrar() {
        if (this.ocupados >= this.capacidad) {
            return false;
        }
        this.ocupados++;
        return true;
    }

    // Libera un cupo si hay al menos un auto; nunca permite que ocupados baje de 0
    public void salir() {
        if (this.ocupados > 0) {
            this.ocupados--;
        }
    }

    // Devuelve cuantos cupos quedan disponibles (siempre >= 0)
    public int cuposLibres() {
        return this.capacidad - this.ocupados;
    }

    // Los getters de consulta (sin setters directos para proteger las invariantes del estado)
    public int getCapacidad() {
        return capacidad;
    }

    public int getOcupados() {
        return ocupados;
    }
}
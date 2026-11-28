package ExamenPOO_Osorio_Jhonatan.ejercicio1;

public class Sala {
    private String nombre;
    private int capacidad;
    private double precioHora;

    public Sala(String nombre, int capacidad, double precioHora) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precioHora = precioHora;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getPrecioHora() {
        return precioHora;
    }
}

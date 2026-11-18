package clase4_herencia.herencia;

public class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int velocidad;

    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = 0;
    }

    public void acelerar(int cantidad) {
        if (cantidad > 0) {
            this.velocidad += cantidad;
        }
    }

    public void frenar(int cantidad) {
        if (cantidad > 0) {
            this.velocidad -= cantidad;
            if (this.velocidad < 0) {
                this.velocidad = 0;
            }
        }
    }

    public void mostrarInfo() {
        System.out.println("----------------------------------------");
        System.out.println("Marca       : " + this.marca);
        System.out.println("Modelo      : " + this.modelo);
        System.out.println("Velocidad   : " + this.velocidad + " km/h");
    }
}
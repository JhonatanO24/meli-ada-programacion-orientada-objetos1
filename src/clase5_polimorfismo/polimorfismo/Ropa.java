package clase5_polimorfismo.polimorfismo;

public class Ropa extends Producto {
    public Ropa(String nombre, double precioBase) {
        super(nombre, precioBase);
    }

    @Override
    public double precio() {
        return this.precioBase;
    }
}

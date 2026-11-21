package clase5_polimorfismo.polimorfismo;

public class Electronico extends Producto{
    public Electronico(String nombre, double precioBase) {
        super(nombre, precioBase);
    }

    @Override
    public double precio() {
        return this.precioBase * 1.19;
    }
}

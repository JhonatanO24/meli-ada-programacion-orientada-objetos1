package clase5_polimorfismo.polimorfismo;

public class Libro extends Producto{
    public Libro(String nombre, double precioBase){
        super(nombre, precioBase);
    }

    @Override
    public double precio() {
        return this.precioBase * 0.9;
    }
}



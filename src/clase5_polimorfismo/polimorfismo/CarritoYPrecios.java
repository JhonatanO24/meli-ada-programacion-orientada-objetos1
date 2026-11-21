package clase5_polimorfismo.polimorfismo;

public class CarritoYPrecios {

    public static double precio(Producto p) {
        if (p == null) {
            return 0.0;
        }
        return p.precio();
    }

    public static void main(String[] args) {
        System.out.println("-----------------------------");
        System.out.println(" Catalogo sin el instanceof");
        System.out.println("-----------------------------");

        Producto[] carrito = {
                new Libro("Clean Code", 100.0),          // 100 * 0.9 = 90.0
                new Electronico("Audífonos BT", 200.0),  // 200 * 1.19 = 238.0
                new Ropa("Camiseta Básica", 50.0)        // 50.0
        };

        double totalCarrito = 0.0;

        for (Producto p : carrito) {
            double precioCalculado = precio(p);
            totalCarrito += precioCalculado;
            System.out.printf("%-18s | Base: $%6.2f | Final: $%6.2f%n",
                    p.getNombre(), p.getPrecioBase(), precioCalculado);
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("Total del carrito: $%.2f%n", totalCarrito);
        System.out.println("\nRefactorización sin instanceof completada!");
    }
}

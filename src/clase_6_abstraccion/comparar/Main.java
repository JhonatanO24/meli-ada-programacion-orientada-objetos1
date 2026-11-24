package clase_6_abstraccion.comparar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("C75 Cake Meow Wireless Mechanical Keyboard", 99.99));
        productos.add(new Producto("AL80 QMK/VIA Aluminum LCD Mechanical Keyboard", 109.99));
        productos.add(new Producto("C1 Silicone Tri-Mode Wireless Custom Mouse", 39.99));
        productos.add(new Producto("M2 Dual 8K Custom Wireless Gaming Mouse", 59.99));
        productos.add(new Producto("C21 Wireless Mechanical Numpad Keyboard & Calculator", 54.99));

        System.out.println("Antes de ordenar");
        for (Producto p : productos) {
            System.out.println(p);
        }

        Collections.sort(productos);

        System.out.println("\nOrdenados por precio (ascendente):");
        for (Producto p : productos) {
            System.out.println(p);
        }
    }
}

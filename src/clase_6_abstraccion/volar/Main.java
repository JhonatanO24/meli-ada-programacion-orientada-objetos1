package clase_6_abstraccion.volar;

public class Main {
    public static void main(String[] args) {
        Volador[] voladores = {
                new Pajaro(),
                new Avion(),
                new Cohete()
        };

        for (Volador v : voladores) {
            v.descripcion();
            v.despegar();
            v.volar();
            v.aterrizar();
            System.out.println("------------------");
        }
    }
}

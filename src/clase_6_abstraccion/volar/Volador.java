package clase_6_abstraccion.volar;

public interface Volador {
    void despegar();
    void volar();
    void aterrizar();

    default void descripcion() {
        System.out.println("Soy un volador");
    }
}

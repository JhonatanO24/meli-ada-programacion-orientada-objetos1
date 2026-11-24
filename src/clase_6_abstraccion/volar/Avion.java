package clase_6_abstraccion.volar;

public class Avion implements Volador {
    @Override
    public void despegar() {
        System.out.println("El Avión se encuentra en la Pista 22 preparado para el despegue...");
    }

    @Override
    public void volar() {
        System.out.println("El Avión se encuentra a 100000 m");
    }

    @Override
    public void aterrizar() {
        System.out.println("El Avión está listo para inicializar el descenso a tierra");
    }
}


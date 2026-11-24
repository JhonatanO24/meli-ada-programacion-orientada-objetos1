package clase_6_abstraccion.volar;

public class Pajaro implements Volador {
    @Override
    public void despegar() {
        System.out.println("El Pájaro aletea en el cielo...");
    }

    @Override
    public void volar() {
        System.out.println("El Pájaro se prepara para volar...");
    }

    @Override
    public void aterrizar() {
        System.out.println("El Pájaro se alista para volver a tierra...");
    }
}

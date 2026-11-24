package clase_6_abstraccion.volar;

public class Cohete implements Volador {

    @Override
    public void despegar() {
        System.out.println("El cohete activa su ignición en la plataforma listo para despegar...");
    }

    @Override
    public void volar() {
        System.out.println("El cohete mantiene su propulsión constante atravesando la atmósfera...");
    }

    @Override
    public void aterrizar() {
        System.out.println("El cohete ajusta su descenso para volver al planeta tierra...");
    }
}


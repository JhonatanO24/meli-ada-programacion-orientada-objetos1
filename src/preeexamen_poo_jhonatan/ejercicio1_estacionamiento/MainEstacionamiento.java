package preeexamen_poo_jhonatan.ejercicio1_estacionamiento;

public class MainEstacionamiento {
    public static void main(String[] args) {
        System.out.println("-------------------------------------");
        System.out.println("--- ESTACIONAMIENTO ---");
        System.out.println("-----------------------------------\n");

        // Crearemos un estacionamiento pequeño (con capacidad 2) para probar bordes facilmente
        Estacionamiento parqueadero = new Estacionamiento(2);

        // Se intneta sacar cuando esta vacio: se debe mantener en 0
        parqueadero.salir();
        System.out.println("Tras salir en vacio -> Ocupados: " + parqueadero.getOcupados()
                + ", Libres: " + parqueadero.cuposLibres());

        // Entran 2 autos: ambos deben devolver true
        System.out.println("🚗 Entra auto 1: " + parqueadero.entrar());
        System.out.println("🚗 Entra auto 2: " + parqueadero.entrar());

        // Intenta meteter in 3er auto cuando esta lleno: debe volver false y no superar la capacidad
        System.out.println("Entra auto 3 (lleno): " + parqueadero.entrar());
        System.out.println("Estado en limite -> Ocupados: " + parqueadero.getOcupados()
                + ", Libres: " + parqueadero.cuposLibres());

        // Sale 1 auto y luego entra 1 más
        parqueadero.salir();
        System.out.println("Sale 1 auto -> Libres: " + parqueadero.cuposLibres());
        System.out.println("Entra auto nuevo: " + parqueadero.entrar());
        System.out.println("Estado final -> Ocupados: " + parqueadero.getOcupados()
                + ", Libres: " + parqueadero.cuposLibres());
    }
}

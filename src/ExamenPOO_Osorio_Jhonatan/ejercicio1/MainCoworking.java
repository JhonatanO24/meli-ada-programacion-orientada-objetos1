package ExamenPOO_Osorio_Jhonatan.ejercicio1;

public class MainCoworking {
    public static void main(String[] args) {
        Coworking cw = new Coworking("Nodo Coworking");
        cw.agregarSala(new Sala("Andes", 4, 25000));
        cw.agregarSala(new Sala("Pacifico", 8, 40000));
        cw.agregarSala(new Sala("Caribe", 12, 60000));

        System.out.println("--- SOLICITUDES DE RESERVA ---");
        System.out.println("1. " + cw.reservar("Andes", "Laura", 3, 8, 10));
        System.out.println("2. " + cw.reservar("Andes", "Diego", 2, 9, 11));
        System.out.println("3. " + cw.reservar("Pacifico", "Startup Nova", 8, 9, 13));
        System.out.println("4. " + cw.reservar("Caribe", "Ada Tech", 15, 14, 16));
        System.out.println("5. " + cw.reservar("Orinoco", "Pedro", 2, 10, 12));
        System.out.println("6. " + cw.reservar("Caribe", "Ada Tech", 12, 14, 18));
        System.out.println("7. " + cw.reservar("Andes", "Diego", 2, 10, 12));
        System.out.println("8. " + cw.reservar("Pacifico", "Camila", 9, 18, 21));
        System.out.println("9. " + cw.reservar("Pacifico", "Camila", 5, 13, 15));
        System.out.println("10. " + cw.reservar("Caribe", "Julian", 6, 17, 17));

        System.out.println();
        System.out.println("--- CANCELACIONES ---");
        System.out.println("Cancelar Andes 8h: " + cw.cancelar("Andes", 8));
        System.out.println("Cancelar Caribe 9h: " + cw.cancelar("Caribe", 9));
        System.out.println("11. " + cw.reservar("Andes", "Sofia", 4, 8, 10));

        System.out.println();
        System.out.println("--- REPORTE " + cw.getNombre().toUpperCase() + " ---");
        System.out.printf("%-10s %6s %10s %10s%n", "Sala", "Horas", "Ocupacion", "Ingresos");
        for (Sala s : cw.getSalas()) {
            String n = s.getNombre();
            System.out.printf("%-10s %6d %9.1f%% %10.0f%n", n, cw.horasReservadas(n),
                    cw.calcularOcupacion(n), cw.ingresosSala(n));
        }
        System.out.printf("Ingresos totales: %.0f%n", cw.ingresosTotales());
        System.out.println("Sala mas rentable: " + cw.salaMasRentable().getNombre());
    }
}

package ExamenPOO_Osorio_Jhonatan.ejercicio2;

import java.util.ArrayList;

public class MainTarjeta {
    public static void main(String[] args) {
        TarjetaTransporte t = new TarjetaTransporte("TM-0042", "Andres Ruiz");
        System.out.println("--- OPERACIONES ---");
        t.setTitular("   ");
        System.out.println("Titular tras setTitular(\"   \"): " + t.getTitular());
        mostrar("Recarga 1500", t.recargar(1500), t);
        mostrar("Recarga 10500", t.recargar(10500), t);
        mostrar("Recarga 10000", t.recargar(10000), t);
        mostrar("Viaje B12 07:10", t.pagarViaje("B12", 430), t);
        mostrar("Viaje K43 07:50", t.pagarViaje("K43", 470), t);
        mostrar("Viaje K43 08:40", t.pagarViaje("K43", 520), t);
        mostrar("Viaje H21 08:20", t.pagarViaje("H21", 500), t);
        mostrar("Viaje H21 18:00", t.pagarViaje("H21", 1080), t);
        mostrar("Viaje B12 19:10", t.pagarViaje("B12", 1150), t);
        mostrar("Viaje G30 19:40", t.pagarViaje("G30", 1180), t);
        mostrar("Recarga 45000", t.recargar(45000), t);
        mostrar("Recarga 10000", t.recargar(10000), t);
        mostrar("Viaje G30 20:30", t.pagarViaje("G30", 1230), t);
        t.setTitular("Andres Ruiz Gomez");

        System.out.println();
        System.out.println("--- HISTORIAL " + t.getCodigo() + " " + t.getTitular() + " ---");
        ArrayList<Viaje> historial = t.getViajes();
        for (Viaje v : historial) {
            System.out.printf("%s %-4s %-11s %5d%n", v.getHoraTexto(),
                    v.getLinea(), v.getTipo(), v.getValorCobrado());
        }
        System.out.println("Total gastado: " + t.calcularTotalGastado());
        System.out.println("Normales: " + t.contarViajes("NORMAL")
                + " | Transbordos: " + t.contarViajes("TRANSBORDO")
                + " | Emergencia: " + t.contarViajes("EMERGENCIA"));
        System.out.println("Saldo final: " + t.getSaldo());

        System.out.println();
        System.out.println("--- PRUEBA DE ENCAPSULAMIENTO ---");
        historial.clear();
        System.out.println("Copia vaciada: " + historial.size() + " viajes");
        System.out.println("Viajes en la tarjeta: " + t.getViajes().size());
    }

    public static void mostrar(String etiqueta, boolean resultado, TarjetaTransporte t) {
        System.out.println(etiqueta + ": " + resultado + " | saldo " + t.getSaldo());
    }
}

package ExamenPOO_Osorio_Jhonatan.ejercicio2;

import java.util.ArrayList;

/*
 * 1. Por que esta clase no tiene setSaldo? Que problema concreto evitamos?
 *    Evitamos que cualquier codigo externo modifique el saldo arbitrariamente (por ejemplo,
 *    asignando saldos negativos o inflados sin pagar/recargar), rompiendo las reglas de
 *    recarga, transbordo y viaje de emergencia.
 *
 * 2. Que pasaria en la prueba de encapsulamiento del main si getViajes() devolviera
 *    la lista original en lugar de una copia?
 *    Al hacer historial.clear() en el main, se borrarian tambien los viajes internos de la
 *    tarjeta, haciendo que la ultima linea mostrara "0 viajes" en lugar de "6".
 */
public class TarjetaTransporte {
    public static final int TARIFA = 3000;
    public static final int TARIFA_TRANSBORDO = 500;
    public static final int VENTANA_TRANSBORDO = 60;
    public static final int SALDO_MAXIMO = 50000;
    public static final int RECARGA_MINIMA = 2000;

    private String codigo;
    private String titular;
    private int saldo;
    private boolean emergenciaUsada;
    private ArrayList<Viaje> viajes;

    public TarjetaTransporte(String codigo, String titular) {
        this.codigo = codigo;
        this.saldo = 0;
        this.emergenciaUsada = false;
        this.viajes = new ArrayList<>();
        setTitular(titular);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitular() {
        return titular;
    }

    public int getSaldo() {
        return saldo;
    }

    public boolean isEmergenciaUsada() {
        return emergenciaUsada;
    }

    public void setTitular(String titular) {
        if (titular != null && titular.trim().length() >= 3) {
            this.titular = titular.trim();
        }
    }

    public ArrayList<Viaje> getViajes() {
        return new ArrayList<>(this.viajes);
    }

    public boolean recargar(int monto) {
        if (monto < RECARGA_MINIMA || monto % 1000 != 0 || this.saldo + monto > SALDO_MAXIMO) {
            return false;
        }
        this.saldo += monto;
        if (this.saldo >= 0) {
            this.emergenciaUsada = false;
        }
        return true;
    }

    public boolean pagarViaje(String linea, int minuto) {
        Viaje ultimo = ultimoViaje();
        if (ultimo != null && minuto <= ultimo.getMinuto()) {
            return false;
        }

        int costo = calcularTarifa(linea, minuto);
        String tipoViaje;

        if (this.saldo >= costo) {
            this.saldo -= costo;
            tipoViaje = (costo == TARIFA_TRANSBORDO) ? "TRANSBORDO" : "NORMAL";
        } else if (!this.emergenciaUsada) {
            this.saldo -= costo;
            this.emergenciaUsada = true;
            tipoViaje = "EMERGENCIA";
        } else {
            return false;
        }

        this.viajes.add(new Viaje(linea, minuto, costo, tipoViaje));
        return true;
    }

    private Viaje ultimoViaje() {
        if (this.viajes.isEmpty()) {
            return null;
        }
        return this.viajes.get(this.viajes.size() - 1);
    }

    private int calcularTarifa(String linea, int minuto) {
        Viaje ultimo = ultimoViaje();
        if (ultimo != null
                && (minuto - ultimo.getMinuto()) <= VENTANA_TRANSBORDO
                && !ultimo.getLinea().equals(linea)) {
            return TARIFA_TRANSBORDO;
        }
        return TARIFA;
    }

    public int calcularTotalGastado() {
        int total = 0;
        for (Viaje v : this.viajes) {
            total += v.getValorCobrado();
        }
        return total;
    }

    public int contarViajes(String tipo) {
        int contador = 0;
        for (Viaje v : this.viajes) {
            if (v.getTipo().equals(tipo)) {
                contador++;
            }
        }
        return contador;
    }
}

package ExamenPOO_Osorio_Jhonatan.ejercicio1;

import java.util.ArrayList;

public class Coworking {
    public static final int HORA_APERTURA = 8;
    public static final int HORA_CIERRE = 20;

    private String nombre;
    private ArrayList<Sala> salas;
    private ArrayList<Reserva> reservas;

    public Coworking(String nombre) {
        this.nombre = nombre;
        this.salas = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }

    public void agregarSala(Sala sala) {
        if (sala != null) {
            this.salas.add(sala);
        }
    }

    public Sala buscarSala(String nombre) {
        for (Sala s : this.salas) {
            if (s.getNombre().equals(nombre)) {
                return s;
            }
        }
        return null;
    }

    public String reservar(String nombreSala, String cliente, int personas, int inicio, int fin) {
        Sala sala = buscarSala(nombreSala);
        if (sala == null) {
            return "ERROR: la sala " + nombreSala + " no existe";
        }
        if (inicio < HORA_APERTURA || fin > HORA_CIERRE || inicio >= fin) {
            return "ERROR: horario fuera de rango";
        }
        if (personas <= 0 || personas > sala.getCapacidad()) {
            return "ERROR: capacidad excedida (max " + sala.getCapacidad() + ")";
        }

        Reserva nueva = new Reserva(sala, cliente, personas, inicio, fin);
        for (Reserva r : this.reservas) {
            if (r.seCruzaCon(nueva)) {
                return "ERROR: se cruza con la reserva de " + r.getCliente()
                        + " (" + r.getHoraInicio() + "-" + r.getHoraFin() + ")";
            }
        }

        this.reservas.add(nueva);
        return String.format("OK: costo %.0f", nueva.calcularCosto());
    }

    public boolean cancelar(String nombreSala, int horaInicio) {
        for (int i = 0; i < this.reservas.size(); i++) {
            Reserva r = this.reservas.get(i);
            if (r.getSala().getNombre().equals(nombreSala) && r.getHoraInicio() == horaInicio) {
                this.reservas.remove(i);
                return true;
            }
        }
        return false;
    }

    public int horasReservadas(String nombreSala) {
        int totalHoras = 0;
        for (Reserva r : this.reservas) {
            if (r.getSala().getNombre().equals(nombreSala)) {
                totalHoras += r.calcularDuracion();
            }
        }
        return totalHoras;
    }

    public double calcularOcupacion(String nombreSala) {
        int horasAtencion = HORA_CIERRE - HORA_APERTURA;
        return (horasReservadas(nombreSala) * 100.0) / horasAtencion;
    }

    public double ingresosSala(String nombreSala) {
        double total = 0.0;
        for (Reserva r : this.reservas) {
            if (r.getSala().getNombre().equals(nombreSala)) {
                total += r.calcularCosto();
            }
        }
        return total;
    }

    public double ingresosTotales() {
        double total = 0.0;
        for (Reserva r : this.reservas) {
            total += r.calcularCosto();
        }
        return total;
    }

    public Sala salaMasRentable() {
        if (this.salas.isEmpty()) {
            return null;
        }
        Sala mejor = this.salas.get(0);
        double mejorIngreso = ingresosSala(mejor.getNombre());

        for (int i = 1; i < this.salas.size(); i++) {
            Sala actual = this.salas.get(i);
            double ingresoActual = ingresosSala(actual.getNombre());
            if (ingresoActual > mejorIngreso) {
                mejorIngreso = ingresoActual;
                mejor = actual;
            }
        }
        return mejor;
    }
}

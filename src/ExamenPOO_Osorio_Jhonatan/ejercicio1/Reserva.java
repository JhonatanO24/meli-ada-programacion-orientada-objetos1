package ExamenPOO_Osorio_Jhonatan.ejercicio1;

/*
 * TAD Reserva:
 * Datos:
 *  - sala (Sala): sala reservada
 *  - cliente (String): nombre del cliente
 *  - personas (int): cantidad de asistentes
 *  - horaInicio (int): hora de inicio (entera)
 *  - horaFin (int): hora de fin (entera)
 *
 * Operaciones:
 *  - Reserva(Sala, String, int, int, int): constructor que inicializa los 5 atributos
 *  - getSala(), getCliente(), getHoraInicio(), getHoraFin(): getters de consulta
 *  - calcularDuracion(): int -> devuelve horaFin - horaInicio
 *  - calcularCosto(): double -> duracion * precioHora; si duracion >= 4, aplica 10% de descuento
 *  - seCruzaCon(Reserva): boolean -> true si comparten Sala y sus rangos horarios se solapan
 */
public class Reserva {
    private Sala sala;
    private String cliente;
    private int personas;
    private int horaInicio;
    private int horaFin;

    public Reserva(Sala sala, String cliente, int personas, int horaInicio, int horaFin) {
        this.sala = sala;
        this.cliente = cliente;
        this.personas = personas;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Sala getSala() {
        return sala;
    }

    public String getCliente() {
        return cliente;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public int calcularDuracion() {
        return this.horaFin - this.horaInicio;
    }

    public double calcularCosto() {
        double subtotal = calcularDuracion() * this.sala.getPrecioHora();
        if (calcularDuracion() >= 4) {
            return subtotal * 0.9;
        }
        return subtotal;
    }

    public boolean seCruzaCon(Reserva otra) {
        if (otra == null || this.sala != otra.sala) {
            return false;
        }
        return this.horaInicio < otra.horaFin && otra.horaInicio < this.horaFin;
    }
}


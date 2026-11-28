package preeexamen_poo_jhonatan.ejercicio3_cuenta;

public class CuentaBancaria {
    // Hueco 1 cerrado: 'saldo' es private (antes era public), evitando alteraciones externas
    // como cuenta.saldo = -999999; y sin setter libre para proteger las reglas de negocio.
    private double saldo;

    // Constructor: inicializa el saldo en 0.0 para partir siempre de un estado válido.
    public CuentaBancaria() {
        this.saldo = 0.0;
    }

    // Getter de consulta: permite leer el saldo de forma segura sin modificarlo directamente.
    public double getSaldo() {
        return saldo;
    }

    // Hueco 2 y 4 cerrados: valida que el monto sea positivo (> 0) y retorna boolean
    // para indicar si el depósito se aplicó (true) o fue rechazado (false, ej. monto <= 0).
    public boolean depositar(double m) {
        if (m <= 0) {
            return false;
        }
        this.saldo += m;
        return true;
    }

    // Hueco 3 y 4 cerrados: rechaza montos <= 0 o mayores al saldo actual (sin sobregiros)
    // y devuelve boolean para comunicar si el retiro fue exitoso o rechazado.
    public boolean retirar(double m) {
        if (m <= 0 || m > this.saldo) {
            return false;
        }
        this.saldo -= m;
        return true;
    }
}

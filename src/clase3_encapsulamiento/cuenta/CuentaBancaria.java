package clase3_encapsulamiento.cuenta;

public class CuentaBancaria {

    private final String numeroCuenta;
    private final String titular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String titular) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = 0;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean depositar(double monto) {
        if (monto <= 0) {
            return false;
        }
        this.saldo += monto;
        return true;
    }

    public boolean retirar(double monto) {
        if (monto <= 0 || monto > this.saldo) {
            return false;
        }
        this.saldo -= monto;
        return true;
    }

    public boolean transferir(CuentaBancaria destino, double monto) {
        if (destino == null) {
            return false;
        }
        if (!this.retirar(monto)) {
            return false;
        }

        destino.depositar(monto);
        return true;
    }

    public void mostrarInfo() {
        System.out.println("----------------------------------------");
        System.out.println("Cuenta N°  : " + this.numeroCuenta);
        System.out.println("Titular    : " + this.titular);
        System.out.printf("💲 Saldo Actual: $%.2f USD\n", this.saldo);
        System.out.println("----------------------------------------");
    }
}

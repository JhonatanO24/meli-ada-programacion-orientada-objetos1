package ExamenPOO_Osorio_Jhonatan.ejercicio2;

public class Viaje {
    private String linea;
    private int minuto;
    private int valorCobrado;
    private String tipo;

    public Viaje(String linea, int minuto, int valorCobrado, String tipo) {
        this.linea = linea;
        this.minuto = minuto;
        this.valorCobrado = valorCobrado;
        this.tipo = tipo;
    }

    public String getLinea() {
        return linea;
    }

    public int getMinuto() {
        return minuto;
    }

    public int getValorCobrado() {
        return valorCobrado;
    }

    public String getTipo() {
        return tipo;
    }

    public String getHoraTexto() {
        return String.format("%02d:%02d", minuto / 60, minuto % 60);
    }
}

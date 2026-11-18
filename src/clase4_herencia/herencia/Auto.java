package clase4_herencia.herencia;

public class Auto extends Vehiculo {
    private int puertas;

    public Auto(String marca, String modelo, int puertas) {
        super(marca, modelo);
        this.puertas = puertas;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Puertas     : " + this.puertas);
        System.out.println("----------------------------------------");
    }
}

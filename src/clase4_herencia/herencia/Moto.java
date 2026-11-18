package clase4_herencia.herencia;

public class Moto extends Vehiculo {
    private int cilindrada;

    public Moto(String marca, String modelo, int cilindrada) {
        super(marca, modelo);
        this.cilindrada = cilindrada;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Cilindrada : " + this.cilindrada + " cc");
        System.out.println("----------------------------------------");
    }
}


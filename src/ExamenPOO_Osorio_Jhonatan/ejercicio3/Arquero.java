package ExamenPOO_Osorio_Jhonatan.ejercicio3;

public class Arquero extends Personaje {
    private int disparos;

    public Arquero(String nombre, int vida, int ataque, int defensa) {
        super(nombre, vida, ataque, defensa);
        this.disparos = 0;
    }

    @Override
    public String getTipo() {
        return "Arquero";
    }

    @Override
    protected int calcularDanio(Personaje objetivo) {
        this.disparos++;
        int danio = Math.max(1, getAtaque() - objetivo.getDefensa() / 2);
        if (this.disparos % 3 == 0) {
            danio *= 2;
        }
        return danio;
    }
}

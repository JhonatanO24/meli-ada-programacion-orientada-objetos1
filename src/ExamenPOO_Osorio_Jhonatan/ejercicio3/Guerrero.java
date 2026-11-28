package ExamenPOO_Osorio_Jhonatan.ejercicio3;

public class Guerrero extends Personaje {
    private int escudo;

    public Guerrero(String nombre, int vida, int ataque, int defensa, int escudo) {
        super(nombre, vida, ataque, defensa);
        this.escudo = escudo;
    }

    public Guerrero(String nombre) {
        this(nombre, 70, 14, 5, 2);
    }

    @Override
    public String getTipo() {
        return "Guerrero";
    }

    @Override
    protected int calcularDanio(Personaje objetivo) {
        int danio = Math.max(1, getAtaque() - objetivo.getDefensa());
        if (getVida() <= getVidaMaxima() / 2) {
            danio *= 2;
        }
        return danio;
    }

    @Override
    public int recibirDanio(int danio) {
        int reducido = Math.max(1, danio - this.escudo);
        return super.recibirDanio(reducido);
    }
}

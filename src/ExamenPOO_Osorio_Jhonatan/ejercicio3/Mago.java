package ExamenPOO_Osorio_Jhonatan.ejercicio3;

public class Mago extends Personaje {
    public static final int COSTO_HECHIZO = 15;
    private int mana;

    public Mago(String nombre, int vida, int ataque, int defensa, int mana) {
        super(nombre, vida, ataque, defensa);
        this.mana = mana;
    }

    public Mago(String nombre) {
        this(nombre, 40, 10, 2, 30);
    }

    public int getMana() {
        return mana;
    }

    @Override
    public String getTipo() {
        return "Mago";
    }

    @Override
    protected int calcularDanio(Personaje objetivo) {
        if (this.mana >= COSTO_HECHIZO) {
            this.mana -= COSTO_HECHIZO;
            return getAtaque() * 2;
        }
        this.mana += 10;
        return 3;
    }

    @Override
    public String toString() {
        return super.toString() + " mana " + this.mana;
    }
}

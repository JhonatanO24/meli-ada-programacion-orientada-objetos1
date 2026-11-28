package ExamenPOO_Osorio_Jhonatan.ejercicio3;

public abstract class Personaje {
    private String nombre;
    private int vidaMaxima;
    private int vida;
    private int ataque;
    private int defensa;

    public Personaje(String nombre, int vidaMaxima, int ataque, int defensa) {
        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }

    public abstract String getTipo();

    protected abstract int calcularDanio(Personaje objetivo);

    public int atacar(Personaje objetivo) {
        int danioCalculado = calcularDanio(objetivo);
        return objetivo.recibirDanio(danioCalculado);
    }

    public int recibirDanio(int danio) {
        int real = Math.max(0, danio);
        this.vida = Math.max(0, this.vida - real);
        return real;
    }

    public void curar(int puntos) {
        if (!estaVivo() || puntos <= 0) {
            return;
        }
        this.vida = Math.min(this.vidaMaxima, this.vida + puntos);
    }

    public void curar() {
        curar(10);
    }

    @Override
    public String toString() {
        return this.nombre + " [" + getTipo() + "] " + this.vida + "/" + this.vidaMaxima;
    }
}

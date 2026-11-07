package clase2.agenda;

public class Contacto {
    private String nombre;
    private String email;
    private String telefono;
    private boolean esFavorito;

    // Constructor
    public Contacto(String nombre, String email, String telefono, boolean esFavorito) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.esFavorito = esFavorito;
    }

    // En este caso me dio la curiosidad de usar los getters para mas simplicidad, pero tambien se puede hacer por medio de retornos
    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public boolean isEsFavorito() {
        return esFavorito;
    }

    public void mostrarInfo() {
        String fav = esFavorito ? "⭐ Sí" : "No";
        System.out.println("👤 Nombre   : " + nombre);
        System.out.println("📧 Email    : " + email);
        System.out.println("📞 Teléfono : " + telefono);
        System.out.println("🌟 Favorito : " + fav);
        System.out.println("----------------------------------------");
    }
}

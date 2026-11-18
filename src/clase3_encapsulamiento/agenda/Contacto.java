package clase3_encapsulamiento.agenda;

public class Contacto {
    private String nombre;
    private String email;
    private String telefono;

    public Contacto(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }

    // Regla de validación básica para el punto 3
    public boolean esValido() {
        return nombre != null && !nombre.trim().isEmpty() &&
                email != null && email.contains("@") && email.contains(".");
    }

    public void mostrarInfo() {
        System.out.println("👤 Nombre: " + nombre + " | 📧 Email: " + email + " | 📞 Tel: " + telefono);
    }
}

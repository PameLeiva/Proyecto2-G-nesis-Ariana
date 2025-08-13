
package lógica;

import java.time.LocalDate;

/**
 *
 * @author Génesis Leiva
 * @author Ariana Araya
 */
public class Persona {
    private int ced;
    private String nom;
    private LocalDate fechNac;
    private String direccion;
    private int telefono;
    private String email;

    public Persona() {
        this.ced = 0;
        this.nom = "";
        this.fechNac = null;
        this.direccion = "";
        this.telefono = 0;
        this.email = "";
    }
    
      public Persona(int ced, String nom, LocalDate fechNac, String direccion, int telefono, String email) {
        this.ced = ced;
        this.nom = nom;
        this.fechNac = fechNac;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public int getCed() {
        return ced;
    }

    public void setCed(int ced) {
        this.ced = ced;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getFechNac() {
        return fechNac;
    }

    public void setFechNac(LocalDate fechNac) {
        this.fechNac = fechNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

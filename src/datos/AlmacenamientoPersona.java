package datos;

import java.util.ArrayList;
import lógica.Persona;

/**
 *
 * @author Génesis Leiva
 * @author Ariana Araya
 */
public class AlmacenamientoPersona {


/**
 *
 * @author Génesis Leiva
 * @author Ariana Araya
 */

    private ArrayList<Persona> listaPersonas;

    public AlmacenamientoPersona() {
        this.listaPersonas = new ArrayList();
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    //CRUD
    public void insertarPersona(Persona persona) {
        if (this.listaPersonas != null) {
            this.listaPersonas.add(persona);
        }
    }

    public void editarPersona(int i, Persona newPersona) {
        if (i >= 0 && newPersona != null && !listaPersonas.isEmpty()) {
            this.listaPersonas.set(i, newPersona);
        }
    }

    public boolean eliminarPersona(Persona Persona) {
        if (this.listaPersonas.contains(Persona)) {
            this.listaPersonas.remove(Persona);
            return true;
        }
        return false; //Estudiante no existe en el Array
    }

    public Persona buscarCedula(int ced) {
        for (Persona e : listaPersonas) {
            if (e.getCed() == ced) {
                return e;
            }
        }
        return null;
    }
}



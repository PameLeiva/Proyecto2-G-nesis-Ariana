package datos;

import java.util.ArrayList;
import lógica.Beneficios;

/**
 * @author Génesis Leiva
 * @author Ariana Araya
 */
public class AlmacenamientoBeneficios {
    
    private ArrayList<Beneficios> listaBeneficios;
    private int siguienteId = 1; // empieza en 1

    
    public AlmacenamientoBeneficios() {
        this.listaBeneficios = new ArrayList<>();
    }
    
    public ArrayList<Beneficios> getListaBeneficios() {
        return listaBeneficios;
    }
    
    public void setListaBeneficios(ArrayList<Beneficios> listaBeneficios) {
        this.listaBeneficios = listaBeneficios;
    }
    
    // CRUD
    public void insertarBeneficio(Beneficios beneficio) {
        if (this.listaBeneficios != null && beneficio != null) {
            beneficio.setIdBeneficio(siguienteId++);
            this.listaBeneficios.add(beneficio);
        }
    }
    
    public void editarBeneficio(int index, Beneficios nuevoBeneficio) {
        if (index >= 0 && nuevoBeneficio != null && !listaBeneficios.isEmpty() 
            && index < listaBeneficios.size()) {
            this.listaBeneficios.set(index, nuevoBeneficio);
        }
    }
    
    public boolean eliminarBeneficio(Beneficios beneficio) {
        if (this.listaBeneficios.contains(beneficio)) {
            this.listaBeneficios.remove(beneficio);
            return true;
        }
        return false;
    }
    
    public Beneficios buscarId(int id) {
        for (Beneficios b : listaBeneficios) {
            if (b.getIdBeneficio() == id) {
                return b;
            }
        }
        return null;
    }
    
    public int buscarIndice(int id) {
        for (int i = 0; i < listaBeneficios.size(); i++) {
            if (listaBeneficios.get(i).getIdBeneficio() == id) {
                return i;
            }
        }
        return -1;
    }
    
    
}
package es.iespuertolacruz.rubengonzalezrodriguez;

import java.util.HashMap;
import java.util.Map;

public class GestionPlantas {

    // Variables de clase

    HashMap<String, Planta> plantas;

    // Constructores

    /**
     * Constructor por defecto de GestionPlantas
     */
    public GestionPlantas() {
        plantas = new HashMap<>();
    }

    /**
     * Constructor con parametros de GestionPlantas
     * 
     * @param plantas objeto planta
     */
    public GestionPlantas(Map<String, Planta> plantas) {
        this.plantas = (HashMap<String, Planta>) plantas;
    }

    // Getter and Setter

    public Map<String, Planta> getPlantas() {
        return this.plantas;
    }

    public void setPlantas(Map<String, Planta> plantas) {
        this.plantas = (HashMap<String, Planta>) plantas;
    }

    // Metodos y funciones

    /**
     * Metodo que inserta una planta en el HashMap
     * 
     * @param id     de la planta
     * @param planta planta a insertar
     * @throws PlantaException excepcion propia de planta
     */
    public void insertar(String id, Planta planta) throws PlantaException {
        if (!existe(id)) {
            plantas.put(id, planta);
        } else {
            throw new PlantaException("La planta con clave " + id + "ya existia en la lista");
        }
    }

    /**
     * Funcion que comprueba si existe una planta con esa clave
     * 
     * @param id a comprobar
     * @return True si existe o false si no existe
     */
    public boolean existe(String id) {
        return plantas.containsKey(id);
    }

    /**
     * Metodo que elimina una planta en el HashMap
     * 
     * @param id de la planta
     * @throws PlantaException excepcion propia de planta
     */
    public void eliminar(String id) throws PlantaException {
        if (existe(id)) {
            plantas.remove(id);
        } else {
            throw new PlantaException("La planta con clave " + id + "no existia en la lista");
        }
    }

    /**
     * Funcion que busca un id y devuelve la planta
     * 
     * @param id de la planta a buscar
     * @return Planta a buscar
     */
    public Planta buscar(String id) {
        if (existe(id)) {
            return plantas.get(id);
        } else {
            return null;
        }
    }

    /**
     * Funcion que devuelve un string con la informacion de a planta
     * 
     * @param id de la planta
     * @return String con la informacion
     */
    public String mostarPlanta(String id) {
        Planta planta = buscar(id);
        return planta.toString();
    }

    /**
     * Funcion que devuelve el numero de plantas que hay
     * 
     * @param id de la planta
     * @return numero de plantas
     */
    public int obtenerCantidad(String id) {
        Planta planta = buscar(id);
        if(planta != null) {
            return planta.getArticulos();
        } else {
            return 0;
        }
    }

}

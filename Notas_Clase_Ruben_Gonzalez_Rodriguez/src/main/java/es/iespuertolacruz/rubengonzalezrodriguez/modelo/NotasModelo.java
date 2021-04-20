package es.iespuertolacruz.rubengonzalezrodriguez.modelo;

import java.util.HashMap;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Nota;

public class NotasModelo {

    // Variables de clase

    Nota nota;
    HashMap<String, Nota> notas;

    // Constructores

    /**
     * Constructor por defecto de AlumnosModelo
     */
    public NotasModelo() {
        notas = new HashMap<>();
    }

    // Metodos y funciones

    /**
     * Metodo que inserta una nota en la lista de notas
     * 
     * @param nota a insertar
     */
    public void insertar(Nota nota) {
        notas.put(nota.getAsignatura(), nota);
    }

    /**
     * Metodo que elimina a una nota de la lista de notas
     * 
     * @param nota a eliminar
     */
    public void eliminar(Nota nota) {
        notas.remove(nota.getAsignatura());
    }

    /**
     * Funcion que devuelve una nota buscada por el nombre de la asignatura
     * 
     * @param asignatura a buscar
     */
    public Nota buscar(String asignatura) {
        nota = notas.get(asignatura);
        return nota;
    }

    /**
     * Funcion que comprueba si existe una nota
     * 
     * @param nota a verificar
     * @return true si existe o false si no existe
     */
    public boolean existe(Nota nota) {
        Nota notaAencontrar;
        notaAencontrar = buscar(nota.getAsignatura());
        return notaAencontrar != null;
    }

    /**
     * Funcion que muestra el contenido de la lista
     * 
     * @return String con los elementos
     */
    public String mostrarLista() {
        return notas.toString();
    }

}

package es.iespuertolacruz.rubengonzalezrodriguez.modelo;

import java.util.ArrayList;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Vehiculo;
import es.iespuertolacruz.rubengonzalezrodriguez.excepciones.FicheroException;

public class VehiculoModelo {

    // Variables de clase

    Fichero fichero;

    // Constructores

    /**
     * Constructor por defecto con fichero inicializado
     */
    public VehiculoModelo() {
        fichero = new Fichero();
    }

    // Metodos y funciones

    public void insertar(Vehiculo vehiculo) throws FicheroException {
        fichero.insertar(vehiculo);
    }

    public void eliminar(Vehiculo vehiculo) throws FicheroException {
        fichero.eliminar(vehiculo);
    }

    public Vehiculo buscar(String matricula) throws FicheroException {
        Vehiculo vehiculo = null;
        ArrayList<Vehiculo> listaVehiculos;
        listaVehiculos = (ArrayList<Vehiculo>) fichero.obtenerListado();
        int i = 0;
        while (i < listaVehiculos.size() && vehiculo == null) {
            if (matricula.equals(listaVehiculos.get(i).getMatricula())) {
                vehiculo = listaVehiculos.get(i);
            }
            i++;
        }
        return vehiculo;
    }

    public void modificar(Vehiculo vehiculoAlmacenado, Vehiculo vehiculo) throws FicheroException {
        fichero.modificar(vehiculoAlmacenado, vehiculo);
    }
}

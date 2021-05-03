package es.iespuertolacruz.rubengonzalezrodriguez.controller;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Vehiculo;
import es.iespuertolacruz.rubengonzalezrodriguez.excepciones.FicheroException;
import es.iespuertolacruz.rubengonzalezrodriguez.excepciones.VehiculoException;
import es.iespuertolacruz.rubengonzalezrodriguez.modelo.VehiculoModelo;

/**
 * Constrolador de la clase Vehiculo
 */
public class VehiculoController {

    // Variables de clase

    VehiculoModelo vehiculoModelo;

    // Constructores

    public VehiculoController() {
        vehiculoModelo = new VehiculoModelo();
    }

    // Metodos y funciones

    /**
     * Metodo que valida un vehiculo
     * 
     * @param vehiculo a validar
     * @throws VehiculoException excepcion propia
     */
    public void validar(Vehiculo vehiculo) throws VehiculoException {
        String mensaje = "";

        if (vehiculo == null) {
            mensaje = "El vehiculo es nulo";
            throw new VehiculoException(mensaje);
        }

        if (vehiculo.getMatricula() == null || vehiculo.getMatricula().isEmpty()) {
            mensaje = "La matricla del vehiculo es nula o vacia, ";
        }
        if (vehiculo.getMarca() == null || vehiculo.getMarca().isEmpty()) {
            mensaje += "La marca del vehiculo es nula o vacia.";
        }

        if (!mensaje.isEmpty()) {
            throw new VehiculoException(mensaje);
        }
    }

    public void insertar(Vehiculo vehiculo) throws VehiculoException, FicheroException {
        validar(vehiculo);
        if (existe(vehiculo)) {
            throw new VehiculoException("El vehiculo indicado ya existe");
        }
        vehiculoModelo.insertar(vehiculo);
    }

    public void eliminar(Vehiculo vehiculo) throws VehiculoException, FicheroException {
        validar(vehiculo);
        if (!existe(vehiculo)) {
            throw new VehiculoException("El vehiculo indicado no existe");
        }
        vehiculoModelo.eliminar(vehiculo);
    }

    public void eliminar(String matricula) throws VehiculoException, FicheroException {
        Vehiculo vehiculo;
        vehiculo = buscar(matricula);
        eliminar(vehiculo);
    }

    public Vehiculo buscar(String matricula) throws FicheroException {
        Vehiculo vehiculo = null;
        vehiculo = vehiculoModelo.buscar(matricula);
        return vehiculo;
    }

    public void modificar(Vehiculo vehiculo) throws VehiculoException, FicheroException {
        Vehiculo vehiculoAlmacenado;

        validar(vehiculo);
        vehiculoAlmacenado = buscar(vehiculo.getMatricula());
        if (vehiculoAlmacenado == null) {
            throw new VehiculoException("El vehiculo indicado no existe");
        }
        vehiculoModelo.modificar(vehiculoAlmacenado, vehiculo);
    }

    private boolean existe(Vehiculo vehiculo) throws FicheroException {
        boolean encontrado = false;
        Vehiculo vehiculoEncontrado;

        vehiculoEncontrado = buscar(vehiculo.getMatricula());
        if (vehiculoEncontrado != null) {
            encontrado = true;
        }
        return encontrado;
    }
}

package es.iespuertolacruz.rubengonzalezrodriguez.modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Vehiculo;
import es.iespuertolacruz.rubengonzalezrodriguez.excepciones.FicheroException;

public class Fichero {

    private static final String SE_HA_PRODUCIDO_UN_ERROR_EN_EL_VOLCADO_DEL_FICHERO = "Se ha producido un error en el volcado del fichero";
    private static final String RETORNO_CARRO = "\n";
    private static final String NOMBRE_FICHERO = "FicheroVehiculos.txt";

    /**
     * Funcion que verifica si el fichero existe
     * 
     * @param fichero a validar
     * @return true si existe o flase si no existe
     */
    public boolean validarFichero(File fichero) {
        return fichero.exists();
    }

    /**
     * Funcion que verifica si se trata de un directorio no
     * 
     * @param path de la ruta a validad
     * @return boolean Si/No se trata de un directorio
     */
    public boolean esDirectorio(String path) {
        File fichero = new File(path);
        return fichero.isDirectory();
    }

    /**
     * Metodo encargado de elimianr un fichero/directorio
     * 
     * @param nombre del fichero/directorio a elimina
     * @throws FicheroException error controlado
     */
    public void eliminar(String nombre) throws FicheroException {
        File fichero = new File(nombre);
        if (validarFichero(fichero)) {
            fichero.delete();
        } else {
            throw new FicheroException("No se puede eliminar un fichero que no existe");
        }
    }

    /**
     * Metodo encargado de crear un fichero
     * 
     * @param nombre del fichero a crear
     * @throws FicheroException
     */
    public void crear(String nombre, String cadenaTexto) throws FicheroException {
        FileWriter fichero = null;
        try {
            fichero = new FileWriter(nombre);
            fichero.write(cadenaTexto + "\n");
            fichero.close();
        } catch (Exception ex) {
            throw new FicheroException("Se ha producido un error en la escritura del fichero", ex);
        } finally {
            if (fichero != null) {
                try {
                    fichero.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Funcion encargada de leer un fichero
     * 
     * @param nombre nombre del fichero a leer
     * @throws FicheroException excepcion controlada
     */
    public String leer(String nombre) throws FicheroException {
        StringBuilder informacion = null;
        File fichero = null;
        Scanner scanner = null;

        try {
            fichero = new File(nombre);
            if (!validarFichero(fichero)) {
                throw new FicheroException("El fichero a leer no existe");
            }
            informacion = new StringBuilder();
            scanner = new Scanner(fichero);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine(); // Guardamos la linea en un String
                informacion.append(linea + RETORNO_CARRO);
            }
        } catch (FicheroException e) {
            throw e;
        } catch (Exception e) {
            throw new FicheroException("Se ha producido un error en la lectura del fichero", e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return informacion.toString();
    }

    /**
     * Funcion encargada de obtener el listado de vehiculos del fichero
     * 
     * @return listado de vehiculos
     * @throws FicheroException excepcion controlada
     */
    public List<Vehiculo> obtenerListado() throws FicheroException {
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        File fichero = null;
        Scanner scanner = null;

        try {
            fichero = new File(NOMBRE_FICHERO);
            if (!validarFichero(fichero)) {
                throw new FicheroException("El fichero a leer no existe");
            }
            scanner = new Scanner(fichero);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                Vehiculo vehiculo = new Vehiculo(linea);
                listaVehiculos.add(vehiculo);
            }
        } catch (FicheroException exception) {
            throw exception;
        } catch (Exception exception) {
            throw new FicheroException("Se ha producido un error en la lectura del fichero", exception);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return listaVehiculos;
    }

    /**
     * Metodo encargado de almacenar un vehiculo en el fichero
     * 
     * @param vehiculo a insertar
     * @throws FicheroException excepcion controlada
     */
    public void insertar(Vehiculo vehiculo) throws FicheroException {
        List<Vehiculo> listaVehiculos;
        listaVehiculos = obtenerListado();
        listaVehiculos.add(vehiculo);
        try {
            crear(NOMBRE_FICHERO, listaVehiculos.toString());
        } catch (FicheroException exception) {
            throw new FicheroException(SE_HA_PRODUCIDO_UN_ERROR_EN_EL_VOLCADO_DEL_FICHERO, exception);
        }
    }

    /**
     * Metodo encargado de eliminar un vehiculo del fichero
     * 
     * @param vehiculo a eliminar
     * @throws FicheroException excepcion controlada
     */
    public void eliminar(Vehiculo vehiculo) throws FicheroException {
        List<Vehiculo> listaVehiculos;
        listaVehiculos = obtenerListado();
        listaVehiculos.remove(vehiculo);
        try {
            crear(NOMBRE_FICHERO, listaVehiculos.toString());
        } catch (FicheroException exception) {
            throw new FicheroException(SE_HA_PRODUCIDO_UN_ERROR_EN_EL_VOLCADO_DEL_FICHERO, exception);
        }
    }

    /**
     * Metodo encargado de modificar un elemento del fichero
     * 
     * @param vehiculoAlmacenado elemento a actualizar
     * @param vehiculo elemento con la informacion actualizada
     * @throws FicheroException
     */
    public void modificar(Vehiculo vehiculoAlmacenado, Vehiculo vehiculo) throws FicheroException {
        List<Vehiculo> listaVehiculos = obtenerListado();
        int posicion = -1;
        posicion = listaVehiculos.indexOf(vehiculoAlmacenado);
        listaVehiculos.remove(posicion);
        listaVehiculos.add(posicion, vehiculo);
        crear(NOMBRE_FICHERO, listaVehiculos.toString());
    }

}
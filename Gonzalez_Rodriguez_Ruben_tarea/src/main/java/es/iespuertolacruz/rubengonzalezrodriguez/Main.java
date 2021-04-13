package es.iespuertolacruz.rubengonzalezrodriguez;

public class Main {

    public static void main(String[] args) {

        GestionCuenta gestionCuenta;
        Cuenta cuenta;

        cuenta = new Cuenta("Antonio López","1000-2365-85-1230456789",2500,0);
        gestionCuenta = new GestionCuenta(cuenta);

        System.out.println("El saldo actual es "+ cuenta.getSaldo() + ". ¿Cuanto desea extraer?");

        try {
            gestionCuenta.retirar(2300);
        } catch (CuentaException e){
            System.out.print("Fallo al ingresar");
        }

        System.out.println("El saldo actual es "+ cuenta.getSaldo());
        System.out.println("¿Cuanto desea ingresar?");

        try {
            gestionCuenta.ingresar(695);
        } catch (Exception e) {
            System.out.print("Fallo al ingresar");
        }
    }
}
package testing_p1_3c1;

import java.util.Scanner;

public class InterfazUsuario {
    private Scanner scanner;

    public InterfazUsuario() {
        this.scanner = new Scanner(System.in);
    }

    // Método para escribir en pantalla
    public void escribir(String mensaje) {
        System.out.println(mensaje);
    }

    // Método para leer enteros controlando excepciones de formato 
    public int leerEntero(String mensaje) throws NumberFormatException {
        System.out.print(mensaje + " ");
        String entrada = scanner.nextLine();
        try {
            return Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            // Requisito: lanzar excepción si se pasan letras
            throw new NumberFormatException("Error: El valor introducido '" + entrada + "' no es un número entero válido.");
        }
    }

    // Métodos adicionales sugeridos por el enunciado (para completar el componente)
    public double leerDoble(String mensaje) throws NumberFormatException {
        System.out.print(mensaje + " ");
        String entrada = scanner.nextLine();
        try {
            return Double.parseDouble(entrada);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Error: El valor no es un número decimal válido.");
        }
    }

    public String leerCadena(String mensaje) {
        System.out.print(mensaje + " ");
        return scanner.nextLine();
    }
    
    public void cerrar() {
        scanner.close();
    }
}
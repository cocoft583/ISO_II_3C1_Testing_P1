package testing_p1_3c1;

public class App {
    public static void main(String[] args) {
        // Instanciamos el componente de interfaz
        InterfazUsuario interfaz = new InterfazUsuario();

        boolean continuar = true;

        while (continuar) {
            try {
                interfaz.escribir("COMPROBADOR DE AÑO BISIESTO.");
                
                // 1. Leemos el dato usando el componente de interfaz
                int valorAnio = interfaz.leerEntero("Introduzca un año (o escriba '0' para salir):");

                if (valorAnio == 0) {
                    continuar = false;
                    interfaz.escribir("Saliendo del programa...");
                    continue;
                }

                // 2. Creamos el objeto de dominio
                // Esto puede lanzar FechaInvalidaException si es negativo
                Año anioObjeto = new Año(valorAnio);

                // 3. Ejecutamos la lógica
                if (anioObjeto.esBisiesto()) {
                    interfaz.escribir("El año " + anioObjeto.getAño() + " ES bisiesto.");
                } else {
                    interfaz.escribir("El año " + anioObjeto.getAño() + " NO es bisiesto.");
                }

            } catch (FechaInvalidaException e) {
                // Capturamos error de lógica de negocio (negativos)
                interfaz.escribir("Error de Dominio: " + e.getMessage());
                
            } catch (NumberFormatException e) {
                // Capturamos error de formato (letras)
                interfaz.escribir("Error de Formato: " + e.getMessage());
                
            } catch (Exception e) {
                interfaz.escribir("Ocurrió un error inesperado: " + e.getMessage());
            }
            
            interfaz.escribir(""); // Salto de línea estético
        }
        
        interfaz.cerrar();
    }
}
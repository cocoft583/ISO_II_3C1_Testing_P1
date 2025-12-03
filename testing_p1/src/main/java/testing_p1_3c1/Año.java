package testing_p1_3c1;

public class Año {
    private int año;

    public Año(int año) throws FechaInvalidaException {
        // 1. VALIDACIÓN: El año 0 no existe históricamente.
        if (año == 0) {
            throw new FechaInvalidaException("El año 0 no existe en el calendario histórico.");
        }
        
        // 2. VALIDACIÓN: Límite inferior (45 a.C.)
        if (año < -45) {
            throw new FechaInvalidaException("Año fuera de rango: El calendario Juliano empezó en el 45 a.C. (-45)");
        }
        
        this.año = año;
    } 

    public int getAño() {
        return año;
    }

    public boolean esBisiesto() {
        // primera condición: años antes de cristo eran cada 3 años y desde el -9 hubo un parón.
        if (año >= -45 && año <= -9) {
            // si la diferencia con el -45 es múltiplo de 3, es bisiesto.
            return (Math.abs(año - (-45)) % 3) == 0;
        }

        // segunda condición: años entre -8 y 7 no hay años bisiestos.
        if (año >= -8 && año < 8) {
            return false;
        }

        // tercera condición: Calendario Juliano (8 d.C. hasta 1581)
        // a partir del 8 d.C, son bisiestos cada 4 años.
        if (año < 1582) {
            return año % 4 == 0;
        } 

        // cuarta condición: Calendario Gregoriano (desde 1582 en adelante)
        // son bisiestos los múltiplos de 4, excepto los múltiplos de 100
        // salvo los múltiplos de 400.
        else {
            return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
        }
    }
}

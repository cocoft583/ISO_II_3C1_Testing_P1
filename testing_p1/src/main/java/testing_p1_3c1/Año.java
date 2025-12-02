package testing_p1_3c1;

public class Año {
    private int año;

    public Año(int año)throws FechaInvalidaException {
        if (año < 0) {
            throw new FechaInvalidaException("Año inválido: " + año);
        }
        this.año = año;
    } 

    public int getAño() {
        return año;
    }

    public boolean esBisiesto(){
        return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
    }
}

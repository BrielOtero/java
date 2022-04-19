//Clase Pelota
public class Pelota {
    // Atributos, características, propiedades.
    public String tipo;
    private double radio;

    // Constructor.

    public Pelota() {
        this.tipo = "Playa";
        this.radio = 40;
    }

    public Pelota(String tipo, double radio) {
        this.tipo = tipo;
        this.radio = radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return this.radio;// Se puede omitir el this porque no hay conflicto.
    }

    public void inflar() {
        this.radio++;
    }

    public void inflar(int incremento) {
        this.radio += incremento;
    }
}
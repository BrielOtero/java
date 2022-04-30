//Clase
public class Geometria {
  // Atributos, caracteristicas, propiedades.
  public boolean figura;
  private double altura;
  private double base;

  public void setAltura(double altura) {
    this.altura = altura;
  }

  public void setBase(double base) {
    this.base = base;

  }

  public double getAltura() {
    return this.altura;
  }

  public double getBase() {
    return this.base;
  }

  // Constructores.
  public Geometria() {
    this.figura = false;
    this.base = 2;
    this.altura = 2;
  }

  public Geometria(double base, double altura) {
    this.figura = false;
    this.base = base;
    this.altura = altura;
  }

  public Geometria(boolean figura, double altura, double base) {
    this.figura = figura;
    this.base = base;
    this.altura = altura;
  }

  // Metodos.

  // Sin parametros
  public double area() {

    if (this.figura) {
      return (this.altura * this.base);
    } else {
      return (this.base * this.altura) / 2;
    }

  }

  // Sin parametros
  public double perimetro() {

    if (this.figura) {
      return (this.base + this.altura) * 2;
    } else {
      return this.base + this.altura + diagonal();
    }

  }

  // Sin parametros
  public double diagonal() {

    return Math.sqrt(this.base * this.base + this.altura * this.altura);

  }

  public String tipo() {
    if (this.figura) {
      return "Rectangulo";
    } else {
      return "Triangulo";
    }

  }
}

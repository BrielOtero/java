
//Clase
public class Fecha {
    // Atributos, caracteristicas, propiedades.
    private int dia;
    private int mes;
    private int ano;

    // Constructores y metodos.
    public Fecha() {
        this.dia = 1;
        this.mes = 1;
        this.ano = 2000;
    }

    public Fecha(int dia, int mes, int ano) {
        setDia(dia);
        setMes(mes);
        this.ano = ano;
    }

    public int getDia() {
        return this.dia;
    }

    public int getMes() {
        return this.mes;
    }

    public int getAno() {
        return this.ano;
    }

    public void setDia(int dia) {
        if (dia < 1 || dia > 31) {
            this.dia = 1;
        } else {
            this.dia = dia;
        }

    }

    public void setMes(int mes) {
        if (mes < 1 || mes > 12) {
            this.mes = 1;
        } else {
            this.mes = mes;
        }
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String fechaFormateada(boolean fecha) {
        String mesTexto = "Prueba";
        if (fecha) {
            return this.dia + "\\" + this.mes + "\\" + this.ano;
        } else {
            switch (this.mes) {
                case 1:
                    mesTexto = "Enero";
                    break;
                case 2:
                    mesTexto = "Febrero";
                    break;
                case 3:
                    mesTexto = "Marzo";
                    break;
                case 4:
                    mesTexto = "Abril";
                    break;
                case 5:
                    mesTexto = "Mayo";
                    break;
                case 6:
                    mesTexto = "Junio";
                    break;
                case 7:
                    mesTexto = "Julio";
                    break;
                case 8:
                    mesTexto = "Agosto";
                    break;
                case 9:
                    mesTexto = "Septiembre";
                    break;
                case 10:
                    mesTexto = "Octubre";
                    break;
                case 11:
                    mesTexto = "Noviembre";
                    break;
                case 12:
                    mesTexto = "Diciembre";
                    break;
                default:
                    break;
            }
            return this.dia + " de " + mesTexto + " de " + this.ano;
        }
    }

    public static int diferenciasFechas(Fecha fecha1, Fecha fecha2) {
        if (fecha1.getAno() > fecha2.getAno()) {
            return fecha1.getAno() - fecha2.getAno();
        } else {
            return fecha2.getAno() - fecha1.getAno();
        }
    }

}

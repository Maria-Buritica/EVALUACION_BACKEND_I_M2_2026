public class Gato extends Paciente {
    private int nivelEstres;

    public Gato(String nombre, double peso, int edad) {
        super(nombre, peso, edad, 6, 15);
        setNivelEstres(0);
    }

    public int getNivelEstres() {
        return nivelEstres;
    }

    public void setNivelEstres(int nivelEstres) {
        if (nivelEstres < 0 || nivelEstres > 10) {
            throw new IllegalArgumentException("Estres invalido");
        }
        this.nivelEstres = nivelEstres;
    }

    @Override
    public String getTipo() {
        return "Gato";
    }
}

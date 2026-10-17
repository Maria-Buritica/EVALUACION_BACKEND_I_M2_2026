public class Perro extends Paciente {
    private String raza;
    private boolean vacunado;

    public Perro(String nombre, double peso, int edad, String raza, boolean vacunado) {
        super(nombre, peso, edad, 10, 80);
        setRaza(raza);
        setVacunado(vacunado);
    }

    public String getRaza() {
        return raza;
    }
    public boolean isVacunado() {
        return vacunado;
    }

    public void setRaza(String raza) {
        if (raza == null || raza.trim().isEmpty()) {
            throw new IllegalArgumentException("Raza invalida");
        }
        this.raza = raza.trim();
    }

    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
        if (!vacunado) {
            setEstado("CUARENTENA");
        } else if ("CUARENTENA".equals(getEstado())) {
            setEstado("INGRESADO");
        }
    }

    @Override
    public String getTipo() {
        return "Perro";
    }
}

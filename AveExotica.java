public class AveExotica extends Paciente {
    private double envergadura;

    public AveExotica(String nombre, double peso, int edad, double envergadura) {
        super(nombre, peso, edad, 3, 15);
        setEnvergadura(envergadura);
    }

    public double getEnvergadura() {
        return envergadura;
    }

    public void setEnvergadura(double envergadura) {
        if (!Double.isFinite(envergadura) || envergadura <= 0) {
            throw new IllegalArgumentException("Envergadura invalida");
        }
        this.envergadura = envergadura;
    }

    @Override
    public String getTamanoNecesario() {
        String tamano = super.getTamanoNecesario();
        if (envergadura > 60 && "S".equals(tamano)) {
            return "M";
        }
        return tamano;
    }

    @Override
    public String getTipo() {
        return "Ave";
    }
    @Override
    public String getZonaNecesaria() {
        return "B";
    }
}
